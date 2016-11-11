package com.technosavy.showmedistance.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;


public class AppPreferences {

    private SharedPreferences mPreferences;


    public AppPreferences(Context context) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }


    public AppPreferences(Context context, String name, int mode) {
        mPreferences = context.getSharedPreferences(name, mode);
    }


    public void setDefaultValues(Context context, int resId, boolean readAgain) {
        PreferenceManager.setDefaultValues(context, resId, readAgain);
    }


    public void putFloat(String key, float value) {
        Editor prefEdit = mPreferences.edit();
        prefEdit.putFloat(key, value);
        prefEdit.apply();
    }


    public float getFloat(String key, float defValue) throws ClassCastException {
        return mPreferences.getFloat(key, defValue);
    }



}
