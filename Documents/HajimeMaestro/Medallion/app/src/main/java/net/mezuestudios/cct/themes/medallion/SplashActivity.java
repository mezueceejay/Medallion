package net.mezuestudios.cct.themes.medallion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//
///**
// * Created by mezuestudios on 3/5/2017.
// */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Fast Boot SplashActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

