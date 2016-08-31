package com.lz.www.ambts.presenter;

import com.lz.www.ambts.model.bean.MyResponse;
import com.lz.www.ambts.model.bean.User;
import com.lz.www.ambts.model.jk.IUserService;
import com.lz.www.ambts.model.jk.IWoService;
import com.lz.www.ambts.presenter.jk.IWoPresenter;
import com.lz.www.ambts.ui.jk.IWoView;
import com.lz.www.ambts.util.Config;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016-08-22.
 */
public class WoPresenter implements IWoPresenter {

    IWoView mView;
    IUserService mModel;

    public WoPresenter(IWoView mView, IUserService mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }

    @Override
    public void loadUserInfo() {
//        User user= new User();
//        user.setUserCode("admin");
//        user.setUserName("管理员");
//        user.setMobile("158768574");
//        user.setPassword("admin");
//        mModel.getOne()
        if(Config.LoginUser==null&&!Config.AMB_TOKEN.isEmpty()){
            Call<MyResponse<User>> call=mModel.getOne(Config.AMB_TOKEN);
            call.enqueue(new Callback<MyResponse<User>>() {
                @Override
                public void onResponse(Call<MyResponse<User>> call, Response<MyResponse<User>> response) {
                    User user=(User)response.body().getData();
                    Config.LoginUser=user;
                    mView.showLoginView(user);
                }

                @Override
                public void onFailure(Call<MyResponse<User>> call, Throwable t) {
                    mView.showNoLoginView();
                    mView.showFail(0,"获取用户信息失败,请检查网络!");
                }
            });
        }
    }

    @Override
    public void deleteUserInfo() {
        Config.AMB_TOKEN="";
        Config.LoginUser=null;
        mView.showNoLoginView();
    }

    @Override
    public void setHeadPhoto() {

    }

    @Override
    public void setUserName(User user) {
        mView.showLoginView(user);
    }

    @Override
    public void setMobile(User user) {
        mView.showLoginView(user);
    }

    @Override
    public void setPassword(User user) {
        mView.showLoginView(user);
    }

    @Override
    public void setSex(User user) {
        mView.showLoginView(user);
    }

    @Override
    public void setBirthday(User user) {
        mView.showLoginView(user);
    }

    @Override
    public void start() {
        if(Config.LoginUser==null){
            mView.showNoLoginView();
        }else {
            mView.showLoginView(Config.LoginUser);
        }
    }
}
