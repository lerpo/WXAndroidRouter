package com.wx.router;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by mlxu on 17/1/6.
 */
public class RouterUtil {
    private final static String fileName = "urlmap.json";
    private static Map<String,String> maplist;
    public static  void initMaplistOfFile(Context context, String fileName)
    {

        if(maplist == null){
            synchronized (RouterUtil.class){
                if(maplist == null){
                    maplist = new HashMap<>();
                    StringBuffer sb = new StringBuffer();
                    AssetManager am = context.getAssets();
                    try {
                        BufferedReader bf = new BufferedReader(new InputStreamReader(am.open(fileName)));
                        String next = "";
                        while (null != (next = bf.readLine())){
                            sb.append(next);
                        }

                    }catch (IOException e){
                        e.printStackTrace();
                        sb.delete(0,sb.length());
                    }
                    try {
                        JSONArray jsonArray = new JSONArray(sb.toString().trim());
                        for(int i = 0; i < jsonArray.length(); i++){
                            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                            Iterator<String> keyIter= jsonObject.keys();
                            Map<String,String> map = new HashMap<String,String>();
                            String key;
                            Object value;
                            while (keyIter.hasNext()) {
                                key = keyIter.next();
                                value = jsonObject.get(key);
                                maplist.put(key, (String)value);
                            }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static String getActivity(Context context,String urlkey){
        initMaplistOfFile(context, fileName);
        String value = "";
        try {
            value = maplist.get(urlkey);
        }catch (Exception e){
            value = "";
            Log.w("UrlError",urlkey+"值不存在");
        }
        return value;
    }


}
