package net.mezuestudios.cct.themes.medallion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.pkmmte.requestmanager.PkRequestManager;
import com.pkmmte.requestmanager.RequestSettings;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Grab a reference to the manager and store it in a variable. This helps make code shorter.
        PkRequestManager mRequestManager = PkRequestManager.getInstance(this);
        mRequestManager.setDebugging(false);
        // Set your custom settings. Email address is required! Everything else is set to default.
        mRequestManager.setSettings(new RequestSettings.Builder()
                .addEmailAddress(getResources().getString(R.string.email_id))
                .emailSubject(getResources().getString(R.string.email_request_subject))
                .emailPrecontent(getResources().getString(R.string.request_precontent))
                .saveLocation(Environment.getExternalStorageDirectory().getAbsolutePath() + getResources().getString(R.string.request_save_location))
                .build());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ko_fi = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.donate_link)));
                startActivity(ko_fi);
            }
        });
        CardView apply = (CardView) findViewById(R.id.applycard);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apply_icon = new Intent(MainActivity.this, ApplyActivity.class);
                startActivity(apply_icon);
            }
        });
        CardView wallpaper = (CardView) findViewById(R.id.wall_card);
        wallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wallpaper_icon = new Intent(MainActivity.this, WallpaperActivity.class);
                startActivity(wallpaper_icon);
            }
        });
        CardView about = (CardView) findViewById(R.id.about_card);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about_intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(about_intent);
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://www.mezuestudios.net23.net/medallion"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://net.mezuestudios.cct.themes.medallion/http/www.mezuestudios.net23.net/medallion")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://www.mezuestudios.net23.net/medallion"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://net.mezuestudios.cct.themes.medallion/http/www.mezuestudios.net23.net/medallion")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
