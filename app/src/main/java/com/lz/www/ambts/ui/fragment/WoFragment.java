package com.lz.www.ambts.ui.fragment;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.User;
import com.lz.www.ambts.presenter.jk.IWoPresenter;
import com.lz.www.ambts.ui.HeadPhotoActivity;
import com.lz.www.ambts.ui.LoginActivity;
import com.lz.www.ambts.ui.component.DaggerWoComponent;
import com.lz.www.ambts.ui.jk.IWoView;
import com.lz.www.ambts.ui.module.WoModule;
import com.lz.www.ambts.util.Config;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class WoFragment extends Fragment implements IWoView {

   boolean isLogin=true;
   String mSelectedSex = "";
   User mUser = null;
   @Inject
   IWoPresenter mPresenter;

   @InjectView(R.id.tvMeHead)
   TextView tvMeHead;
   @InjectView(R.id.ivMeLogo)
   ImageView ivMeLogo;
   @InjectView(R.id.tvLine1)
   TextView tvName;
   @InjectView(R.id.tvLine2)
   TextView tvMobile;
   @InjectView(R.id.tvLine3)
   TextView tvPassword;
   @InjectView(R.id.tvLine4)
   TextView tvSex;
   @InjectView(R.id.btnLoginOut)
   Button btnLoginOut;

   @Nullable
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_wo,container,false);
      ButterKnife.inject(this,view);

      DaggerWoComponent.builder().woModule(new WoModule(this)).build().inject(this);

      mPresenter.start();

      return view;
   }

   @Override
   public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
      super.onCreateOptionsMenu(menu, inflater);
      inflater.inflate(R.menu.toolbar_menu_wo,menu);
   }

   @OnClick({R.id.tvMeHead,R.id.tvLine1,R.id.tvLine2,R.id.tvLine3,R.id.tvLine4,R.id.btnLoginOut})
   public void OnClick(View view){
      switch (view.getId()){
         case R.id.tvMeHead:
            openSetHeadPhoto();
            break;
         case R.id.tvLine1:
            openSetUserName();
            break;
         case R.id.tvLine2:
            openSetMobile();
            break;
         case R.id.tvLine3:
            openSetPassword();
            break;
         case R.id.tvLine4:
            openSetSex();
            break;
         case R.id.btnLoginOut:
            if(Config.LoginUser==null){
               //登录
               Intent it=new Intent(getActivity(), LoginActivity.class);
               startActivityForResult(it,0);
            }else {
               //退出登录
               mPresenter.deleteUserInfo();
            }
            break;
      }
   }

   @Override
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
//      switch (requestCode){
//         case 0:
//            if(resultCode== Activity.RESULT_OK)
//               mPresenter.loadUserInfo();
//            break;
//      }
      super.onActivityResult(requestCode, resultCode, data);
   }

   @Override
   public void onResume() {
      super.onResume();
      mPresenter.loadUserInfo();
   }

   @Override
   public void showLoginView(User user) {
      mUser=user;

      ivMeLogo.setImageResource(R.drawable.mn1);
      tvMeHead.setText("修改头像");
      tvName.setText("昵    称："+user.getUserName());
      tvMobile.setText("联系电话："+user.getMobile());
      tvSex.setText("性    别："+String.valueOf(user.isSex()));
      tvPassword.setText("个人密码："+user.getPassword());

      tvMeHead.setClickable(true);
      tvName.setClickable(true);
      tvMobile.setClickable(true);
      tvName.setClickable(true);
      tvPassword.setClickable(true);
      tvSex.setClickable(true);

      btnLoginOut.setText("退出登录");
   }

   @Override
   public void showNoLoginView() {
      ivMeLogo.setImageResource(R.drawable.user);
      tvMeHead.setText("未登录");
      tvName.setText("昵    称");
      tvMobile.setText("联系电话");
      tvSex.setText("性    别");
      tvPassword.setText("个人密码");

      tvMeHead.setClickable(false);
      tvName.setClickable(false);
      tvMobile.setClickable(false);
      tvName.setClickable(false);
      tvPassword.setClickable(false);
      tvSex.setClickable(false);

      btnLoginOut.setText("点击登录");
   }

   @Override
   public void openSetHeadPhoto() {
      Intent it=new Intent(getActivity(), HeadPhotoActivity.class);
      startActivity(it);
      Toast.makeText(getActivity(),"clicked head",Toast.LENGTH_SHORT).show();
   }

   @Override
   public void openSetUserName() {
      final EditText inputServer = new EditText(getActivity());
      inputServer.setFocusable(true);
      new AlertDialog.Builder(getActivity()).setTitle("请填写新昵称：")
              .setView(inputServer)
              .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                    String txt=inputServer.getText().toString();
                    mUser.setUserName(txt);
                    mPresenter.setUserName(mUser);
                    Toast.makeText(getActivity(),txt,Toast.LENGTH_SHORT).show();
                 }
              })
              .setNegativeButton("取消",null)
              .show();
   }

   @Override
   public void openSetMobile() {
      final EditText inputServer = new EditText(getActivity());
      inputServer.setFocusable(true);
      new AlertDialog.Builder(getActivity()).setTitle("请填写新号码：")
              .setView(inputServer)
              .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                    String txt=inputServer.getText().toString();
                    mUser.setMobile(txt);
                    mPresenter.setMobile(mUser);
                    Toast.makeText(getActivity(),txt,Toast.LENGTH_SHORT).show();
                 }
              })
              .setNegativeButton("取消",null)
              .show();
   }

   @Override
   public void openSetPassword() {
      final EditText inputServer = new EditText(getActivity());
      inputServer.setFocusable(true);
      new AlertDialog.Builder(getActivity()).setTitle("请填写新密码：")
              .setView(inputServer)
              .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                    String txt=inputServer.getText().toString();
                    mUser.setPassword(txt);
                    mPresenter.setPassword(mUser);
                    Toast.makeText(getActivity(),txt,Toast.LENGTH_SHORT).show();
                 }
              })
              .setNegativeButton("取消",null)
              .show();
   }

   @Override
   public void openSetSex() {

      new AlertDialog.Builder(getActivity()).setTitle("请选择性别")
              .setSingleChoiceItems(R.array.sex, 0, new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getActivity(), "你点击了："+String.valueOf(i), Toast.LENGTH_SHORT).show();
                    String sex = getResources().getStringArray(R.array.sex)[i];
                   mSelectedSex = sex;
                 }
              })
              .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                    //Toast.makeText(getActivity(), "你点击了："+String.valueOf(i), Toast.LENGTH_SHORT).show();
                    if (!mSelectedSex.isEmpty() && (mSelectedSex.equals("男") != mUser.isSex()))
                       mUser.setSex(mSelectedSex.equals("男"));
                       mPresenter.setSex(mUser);
                 }
              })
              .setNegativeButton("取消", null).show();
   }

   @Override
   public void showSuccess(int type, String msg) {

   }

   @Override
   public void showFail(int type, String msg) {
      Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
   }
}
