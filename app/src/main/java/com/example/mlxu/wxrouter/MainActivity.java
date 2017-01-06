package com.example.mlxu.wxrouter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wx.router.Router;
import com.wx.router.RouterUtil;
public class MainActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.v("activity","activity:" + RouterUtil.getActivity(this, "MSG001"));
//        Log.v("activity", "activity:" + RouterUtil.getActivity(this, "MSG002"));
//        Log.v("activity", "activity:" + RouterUtil.getActivity(this, "MSG003"));
    }

    public void buttonClick(View v){
        int id = v.getId();
        switch (id){
            case R.id.btn1:{
//                Router.startActivityForName(this, RouterUtil.getActivity(this, "MSG001"));
                startActivity(Router.initIntentWithActivityKey(this, "MSG001"));

            }break;
            case R.id.btn2:{
                startActivity(Router.initIntentWithActivityKey(this, "MSG002"));
            }break;
            case R.id.btn3: {
                Intent intent = Router.initIntentWithActivityKey(this, "MSG003");
                intent.putExtra("url","http://www.baidu.com");
                startActivity(intent);
            }break;
            case R.id.btn4: {
                Intent intent = Router.initIntentWithActivityKey(this, "MSG005");
                intent.putExtra("url", "http://www.baidu.com");
                startActivity(intent);
            }break;
        }

    }
}
