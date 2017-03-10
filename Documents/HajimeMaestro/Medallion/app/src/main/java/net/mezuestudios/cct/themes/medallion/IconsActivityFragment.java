package net.mezuestudios.cct.themes.medallion;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.mezuestudios.cct.themes.medallion.tabs.AllIcons;
import net.mezuestudios.cct.themes.medallion.tabs.DrawerIcons;
import net.mezuestudios.cct.themes.medallion.tabs.GamesIcons;
import net.mezuestudios.cct.themes.medallion.tabs.GoogleIcons;
import net.mezuestudios.cct.themes.medallion.tabs.LatestIcons;
import net.mezuestudios.cct.themes.medallion.tabs.SystemIcons;

/**
 * A placeholder fragment containing a simple view.
 */
public class IconsActivityFragment extends Fragment {
    private ViewPager mPager;
    private SlidingTabLayout mTabs;


    public IconsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_icons, container, false);
        mPager = (ViewPager) root.findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager()));
        mTabs = (SlidingTabLayout) root.findViewById(R.id.tabs);
        mTabs.setViewPager(mPager);
        mTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.accent);
            }
        });

        return root;
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        String[] tabs;

        public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.tabs);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = new Fragment();
            switch (position) {
                case 0:
                    f = new LatestIcons();
                    break;
                case 1:
                    f = new SystemIcons();
                    break;
                case 2:
                    f = new GoogleIcons();
                    break;
                case 3:
                    f = new GamesIcons();
                    break;
                case 4:
                    f = new AllIcons();
                    break;
                case 5:
                    f = new DrawerIcons();
                    break;
            }
            return f;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public int getCount() {
            return 6;
        }
    }

}
