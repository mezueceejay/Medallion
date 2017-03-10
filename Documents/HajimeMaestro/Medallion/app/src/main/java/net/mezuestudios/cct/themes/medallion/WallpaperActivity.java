package net.mezuestudios.cct.themes.medallion;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class WallpaperActivity extends AppCompatActivity implements View.OnClickListener {
//For Setting wallpapers but will be updating later.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {
        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.medallion_wall);
        WallpaperManager myWallpaperManager = WallpaperManager
                .getInstance(getApplicationContext());

        try {
            myWallpaperManager.setBitmap(mBitmap);
            Snackbar.make(view, getString(R.string.wallpaper_set), Snackbar.LENGTH_LONG).show();
        } catch (IOException e) {
            Snackbar.make(view, getString(R.string.wallpaper_error), Snackbar.LENGTH_LONG).show();
        }

    }
}
