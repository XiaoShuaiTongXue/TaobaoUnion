package com.shuai.taobaounion.utils;

import android.util.Log;

public class LogUtils {
    private static  int current_level = 4;
    private static final int DEBUG_LEVEL = 4;
    private static final int INFO_LEVEL = 3;
    private static final int WARNING_LEVEL = 2;
    private static final int ERROR_LEVEL = 1;

    public static void d(Class clazz,String log){
        if (DEBUG_LEVEL<= current_level){
            Log.d(clazz.getSimpleName(),log);
        }
    }

    public static void i(Class clazz,String log){
        if (INFO_LEVEL<= current_level){
            Log.i(clazz.getSimpleName(),log);
        }
    }
    public static void w(Class clazz,String log){
        if (WARNING_LEVEL<= current_level){
            Log.w(clazz.getSimpleName(),log);
        }
    }

    public static void e(Class clazz,String log){
        if (ERROR_LEVEL<= current_level){
            Log.e(clazz.getSimpleName(),log);
        }
    }

}
