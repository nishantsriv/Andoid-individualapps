package com.technosavy.showmedistance.helper;

import android.os.Build;


public class AppUtils {


    public static boolean hasM() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }
}
