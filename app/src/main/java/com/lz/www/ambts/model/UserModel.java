package com.lz.www.ambts.model;

import android.os.Handler;
import android.os.Message;

import com.lz.www.ambts.model.jk.IUserModel;
import com.lz.www.ambts.net.HttpService;
import com.lz.www.ambts.util.Config;

/**
 * Created by Administrator on 2016/7/24.
 */
public class UserModel implements IUserModel {

    @Override
    public void getOneUser(String name, String pwd, final GetOneUserCallback callback) {
        final String url = Config.AMB_API + "act=login&name=" + name + "&pwd=" + pwd;

        final Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.obj.toString().equals("1")){
                    callback.onSuccess();
                }else{
                    callback.onFail();
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                Thread.sleep(3000);
                }catch(InterruptedException ex){}
                String re= HttpService.doGet(url);
                Message msg=new Message();
                msg.obj=re;
                handler.sendMessage(msg);
            }
        }).start();

    }



    @Override
    public void addUser(User user) {

    }

    @Override
    public void getUserList(GetUserListCallback callback) {

    }
}
