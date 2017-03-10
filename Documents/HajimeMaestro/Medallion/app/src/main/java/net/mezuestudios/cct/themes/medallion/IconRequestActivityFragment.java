package net.mezuestudios.cct.themes.medallion;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.melnykov.fab.FloatingActionButton;
import com.pkmmte.requestmanager.AppInfo;
import com.pkmmte.requestmanager.PkRequestManager;

import java.util.LinkedList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class IconRequestActivityFragment extends Fragment {
    // Request Manager
    private PkRequestManager mRequestManager;

    // App List
    private final List<AppInfo> mApps = new LinkedList<>();

    // List & Adapter
    private ListView mList;
    private ListAdapter mAdapter;
    private View mProgress;
    private FloatingActionButton fab;

    public IconRequestActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_icon_request, container, false);
        showNewAdviceDialog();

        // Populate your ListView with your apps
        mList = (ListView) root.findViewById(R.id.appList);
        mList.setVisibility(View.GONE);

        // Progress
        mProgress = root.findViewById(R.id.progress);

        new GrabApplicationsTask().execute();

        // Set basic listener to your ListView
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Mark the app as selected
                AppInfo mApp = mApps.get(position);
                mApp.setSelected(!mApp.isSelected());
                mApps.set(position, mApp);

                // Let the adapter know you selected something
                mAdapter.notifyDataSetChanged();
            }
        });

        fab = (FloatingActionButton) root.findViewById(R.id.send_btn);
        fab.hide(true);
        fab.attachToListView(mList);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRequestManager.setActivity(getActivity());
                if (mRequestManager.getNumSelected() < 1)
                    mRequestManager.sendRequest(true, false);
                else
                    mRequestManager.sendRequestAsync();
                Snackbar.make(root, getString(R.string.building_request), Snackbar.LENGTH_LONG).show();
            }
        });

        return root;
    }

    private class GrabApplicationsTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            try {
                mRequestManager = PkRequestManager.getInstance(getActivity());
                mRequestManager.setDebugging(false);
                mRequestManager.loadAppsIfEmpty();
                // Get the list of apps
                mApps.addAll(mRequestManager.getApps());
            } catch (Exception ex) {
                //could happen that the activity detaches :D
            }
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            mAdapter = new ListAdapter(mApps);
            mList.setAdapter(mAdapter);
            if (mAdapter != null)
                mAdapter.notifyDataSetChanged();
            if (mList != null)
                mList.setVisibility(View.VISIBLE);
            if (fab != null)
                fab.show(true);
            if (mProgress != null)
                mProgress.setVisibility(View.GONE);
        }
    }

    // You should probably put this in a separate .java file
    public class ListAdapter extends BaseAdapter {

        private final List<AppInfo> mApps;

        public ListAdapter(List<AppInfo> apps) {
            this.mApps = apps;
        }

        @Override
        public int getCount() {
            return mApps.size();
        }

        @Override
        public AppInfo getItem(int position) {
            return mApps.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            AppInfo mApp = mApps.get(position);

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                convertView = inflater.inflate(R.layout.request_item, parent, false);

                holder = new ViewHolder();
                holder.imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);
                holder.txtName = (TextView) convertView.findViewById(R.id.txtName);
                holder.chkSelected = (CheckBox) convertView.findViewById(R.id.chkSelected);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.txtName.setText(mApp.getName());
            holder.imgIcon.setImageDrawable(mApp.getImage());
            holder.chkSelected.setChecked(mApp.isSelected());

            return convertView;
        }

        private class ViewHolder {
            public ImageView imgIcon;
            public TextView txtName;
            public CheckBox chkSelected;
        }
    }

    private void showNewAdviceDialog() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        if (!prefs.getBoolean("dontshowagain", false)) {
            new MaterialDialog.Builder(getActivity())
                    .title(R.string.advice)
                    .content(R.string.request_advice)
                    .positiveText(R.string.close)
                    .backgroundColorRes(R.color.colorPrimary)
                    .titleColorRes(R.color.white)
                    .contentColorRes(R.color.white)
                    .neutralText(R.string.dontshow)
                    .callback(new MaterialDialog.ButtonCallback() {
                        @Override
                        public void onPositive(MaterialDialog dialog) {
                            PreferenceManager.getDefaultSharedPreferences(getActivity())
                                    .edit().putBoolean("dontshowagain", false).commit();
                        }

                        @Override
                        public void onNeutral(MaterialDialog dialog) {
                            PreferenceManager.getDefaultSharedPreferences(getActivity())
                                    .edit().putBoolean("dontshowagain", true).commit();
                        }
                    }).show();
        }

    }
}