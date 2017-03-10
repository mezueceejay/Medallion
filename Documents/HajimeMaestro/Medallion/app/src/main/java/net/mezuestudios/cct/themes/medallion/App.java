package net.mezuestudios.cct.themes.medallion;

import android.app.Application;
import android.os.SystemClock;

import java.util.concurrent.TimeUnit;

///**
// * Created by mezue on 3/5/2017.
// */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        Timer for Splash Activity
        // Don't do this! This is just so cold launches take some time
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
    }
}
