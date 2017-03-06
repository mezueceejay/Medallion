package net.mezuestudios.cct.themes.medallion.launchers;

import android.content.Context;
import android.content.Intent;

public class SmartproLauncher {
    public SmartproLauncher(Context context) {
        Intent smartlauncherIntent = new Intent("ginlemon.smartlauncher.setGSLTHEME");
        smartlauncherIntent.putExtra("package", context.getPackageName());
        context.startActivity(smartlauncherIntent);
    }
}
