package com.lz.www.ambts.util;


import com.lz.www.ambts.model.HttpResponse;
import com.lz.www.ambts.model.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-07-01.
 */
public class JsonUtils {

    public static HttpResponse parseJson(String jsonData) {
        HttpResponse r = new HttpResponse();
        List<User> uList = null;
        try {
            uList = new ArrayList<User>();
            //String jsonStr= "{\"code\":\"0\",\"msg\":\"成功\",\"count\":\"1\",\"data\":[{\"ID\":0,\"UserCode\":\"lz\",\"UserName\":null,\"Password\":\"123\",\"Mobile\":\"12557\",\"SBU\":null},{\"ID\":0,\"UserCode\":\"lz\",\"UserName\":null,\"Password\":\"123\",\"Mobile\":\"12557\",\"SBU\":null}]}";
            //jsonData="{\"code\":\"0\",\"msg\":\"成功\",\"count\":\"2\",\"data\":[{\"ID\":0,\"UserCode\":\"lz\",\"UserName\":null,\"Password\":\"123\",\"Mobile\":\"12557\",\"SBU\":null},{\"ID\":0,\"UserCode\":\"lz\",\"UserName\":null,\"Password\":\"123\",\"Mobile\":\"12557\",\"SBU\":null}]}";
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray=jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                User u=new User();
                JSONObject o = jsonArray.getJSONObject(i);
                u.setUserCode(o.getString("UserCode"));
                u.setUserName(o.getString("UserName"));
                u.setPassword(o.getString("Password"));
                uList.add(u);
            }
            r.setCode(jsonObject.getString("code"));
            r.setCount(jsonObject.getString("count"));
            r.setList(uList);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return r;
    }
}
