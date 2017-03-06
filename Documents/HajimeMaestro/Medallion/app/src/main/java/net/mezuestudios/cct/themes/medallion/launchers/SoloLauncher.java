package net.mezuestudios.cct.themes.medallion.launchers;

import android.content.Context;
import android.content.Intent;

import net.mezuestudios.cct.themes.medallion.R;


public class SoloLauncher {
    public SoloLauncher(Context context) {
        Intent soloApply = context.getPackageManager().getLaunchIntentForPackage("home.solo.launcher.free");
        Intent solo = new Intent("home.solo.launcher.free.APPLY_THEME");
        solo.putExtra("EXTRA_PACKAGENAME", context.getPackageName());
        solo.putExtra("EXTRA_THEMENAME", context.getString(R.string.app_name));
        context.sendBroadcast(solo);
        context.startActivity(soloApply);
    }
}
