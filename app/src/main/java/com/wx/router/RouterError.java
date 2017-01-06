package com.wx.router;

import android.content.Context;

/**
 * Created by mlxu on 17/1/6.
 */
public class RouterError {

  public static Class errorClass(Context context){
      return Router.getActivityClassForName(context,RouterUtil.getActivity(context,"MSG003"));
  }
}
