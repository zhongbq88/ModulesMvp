package com.zbq.library.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Administrator on 2016/4/5.
 */
public class SpUtil {
    static SharedPreferences prefs;

    public static String getDataByKey(String key) {
        return prefs.getString(key, "");
    }

    public static void init(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static String getUser() {
        return prefs.getString("user", "");
    }

    public static void setUser(String user) {
        prefs.edit().putString("user", user).apply();
    }

    public static String getData(String key) {
        return prefs.getString(key, "");
    }

    public static void setData(String key, String data) {
        prefs.edit().putString(key, data).apply();
    }
}
