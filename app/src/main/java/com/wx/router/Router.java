package com.wx.router;

import android.content.Context;
import android.content.Intent;

/**
 * Created by mlxu on 17/1/6.
 */

public class Router {

    public static Class getActivityClassForName(Context context, String name) {
        Class clazz;
        try {
            clazz = Class.forName(name);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
        return clazz;
    }

    public static Intent initIntentWithActivityKey(Context context, String key) {
        Class clazz;
        String activityName = RouterUtil.getActivity(context,key);
        try {
            if (activityName == "" || activityName == null) {
                clazz = RouterError.errorClass(context);
            } else {
                clazz = Class.forName(activityName);
            }

        } catch (ClassNotFoundException e) {
            //            throw new RuntimeException(e);
            clazz = RouterError.errorClass(context);
        }
        Intent intent = new Intent(context, clazz);
        intent.putExtra("URLKEY",key);    //路径key唯一识别页面跳转位置
        return intent;
    }
}
