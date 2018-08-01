package com.dajia.yzyfu.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class User extends AppCompatActivity{
    public int login () {
        return 0;
    }

    public Map getStorage () {
        SharedPreferences sp = getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if(sp.getString("username","noval").equals("noval")){
            return null;
        }else{
            Map<String,String> map = new HashMap<String,String>();
            map.put("username",sp.getString("username","noval"));
            map.put("password",sp.getString("password","noval"));
            map.put("id",sp.getString("id","noval"));
            return map;
        }
    }
}
