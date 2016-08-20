package com.lz.www.ambts.ui.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.User;
import com.lz.www.ambts.presenter.jk.IWoPresenter;
import com.lz.www.ambts.ui.HeadPhotoActivity;
import com.lz.www.ambts.ui.jk.IWoView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class WoFragment extends Fragment implements IWoView {

   @Inject
   IWoPresenter mPresenter;

   @InjectView(R.id.tvMeHead)
   TextView txtUpdateHead;
   @InjectView(R.id.ivMeLogo)
   ImageView ivMeLogo;
   @InjectView(R.id.tvB1)
   TextView tv2Code;
   @InjectView(R.id.tvB2)
   TextView tvScan;
   @InjectView(R.id.tvB3)
   TextView tvB3;
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
      return view;
   }

   @OnClick(R.id.tvMeHead)
   private void OnClick(View view){

   }

   @Override
   public void showLoginView(User user) {
      tvName.setText("昵称："+user.getUserName());
      tvMobile.setText("联系电话："+user.getMobile());
      tvSex.setText("性别："+String.valueOf(user.isSex()));
      tvPassword.setText("个人密码："+user.getPassword());
   }

   @Override
   public void showNoLoginView() {
      tvName.setText("昵称");
      tvMobile.setText("联系电话");
      tvSex.setText("性别");
      tvPassword.setText("个人密码");
   }

   @Override
   public void openSetHeadPhoto() {
      Intent it=new Intent(getActivity(), HeadPhotoActivity.class);
      startActivity(it);
      Toast.makeText(getActivity(),"clicked head",Toast.LENGTH_SHORT).show();
   }

   @Override
   public void openSetUserName() {

   }

   @Override
   public void openSetMobile() {

   }

   @Override
   public void openSetPassword() {

   }

   @Override
   public void showSuccess(int type, String msg) {

   }

   @Override
   public void showFail(int type, String msg) {
      Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
   }
}
