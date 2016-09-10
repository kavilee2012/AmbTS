package com.lz.www.ambts.ui.fragment;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.Photo;
import com.lz.www.ambts.model.bean.User;
import com.lz.www.ambts.presenter.jk.IWoPresenter;
import com.lz.www.ambts.ui.HeadPhotoActivity;
import com.lz.www.ambts.ui.LoginActivity;
import com.lz.www.ambts.ui.component.DaggerWoComponent;
import com.lz.www.ambts.ui.jk.IWoView;
import com.lz.www.ambts.ui.module.WoModule;
import com.lz.www.ambts.util.Config;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class WoFragment extends Fragment implements IWoView {

   boolean isLogin=true;
   User mUser = null;
   @Inject
   IWoPresenter mPresenter;

   @InjectView(R.id.tvWoHead)
   TextView tvMeHead;
   @InjectView(R.id.toolWoLogo)
   ImageView ivMeLogo;
   @InjectView(R.id.tvWoName)
   TextView tvName;
   @InjectView(R.id.tvWoPhone)
   TextView tvMobile;
   @InjectView(R.id.tvModityPassword)
   TextView tvPassword;
   @InjectView(R.id.tvWoSex)
   TextView tvSex;
   @InjectView(R.id.tvWoBirthday)
   TextView tvBirthday;
   @InjectView(R.id.btnLoginOut)
   Button btnLoginOut;
   @InjectView(R.id.toolWoLogin)
   TextView toolLogin;
   @InjectView(R.id.toolWoName)
   TextView toolName;

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

      inflater.inflate(R.menu.toolbar_menu_wo,menu);
      super.onCreateOptionsMenu(menu, inflater);
   }

   @OnClick({R.id.tvWoHead,R.id.tvWoName,R.id.tvWoPhone,R.id.tvWoBirthday,R.id.tvWoSex,R.id.tvModityPassword,R.id.tvAbout,R.id.btnLoginOut,R.id.toolWoLogin})
   public void OnClick(View view){
      switch (view.getId()){
         case R.id.tvWoHead:
            openSetHeadPhoto();
            break;
         case R.id.tvWoName:
            openSetUserName();
            break;
         case R.id.tvWoPhone:
            openSetMobile();
            break;
         case R.id.tvModityPassword:
            openSetPassword();
            break;
         case R.id.tvWoSex:
            openSetSex();
            break;
         case R.id.tvWoBirthday:
            openSetBirthday();
            break;
         case R.id.tvAbout:
            openSetAbout();
            break;
         case R.id.toolWoLogin:
               //登录
               Intent it=new Intent(view.getContext(), LoginActivity.class);
               startActivityForResult(it,0);
            break;
         case R.id.btnLoginOut:
               //退出登录
               mPresenter.deleteUserInfo();
            break;
      }
   }

   @Override
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
      switch (requestCode){
         case 0:
            if(resultCode== Activity.RESULT_OK)
               mPresenter.loadUserInfo();
            break;
         case 1:
            if(resultCode== Activity.RESULT_OK)
               mPresenter.loadUserInfo();
            break;
      }
      super.onActivityResult(requestCode, resultCode, data);
   }

   @Override
   public void onResume() {
      super.onResume();
      //mPresenter.loadUserInfo();
   }

   @Override
   public void showLoginView(User user) {
      mUser=user;

      //登录显示
      toolName.setVisibility(View.VISIBLE);
      toolLogin.setVisibility(View.GONE);
      btnLoginOut.setVisibility(View.VISIBLE);

      toolName.setText(user.getUserName());

      Photo photo=user.getPhoto();
      if(photo==null) {
         ivMeLogo.setImageResource(R.drawable.user);
      }else {
         String imgUrl = Config.AMB_IMG +  photo.getUrl().substring(2);

         Picasso.with(getActivity()).load(imgUrl).placeholder(R.drawable.user).error(R.drawable.user).into(ivMeLogo);
      }


      tvName.setText("昵       称    --    "+user.getUserName());
      tvMobile.setText("联系电话    --    "+user.getMobile());
      tvSex.setText("性       别    --    "+(user.isSex()?"男":"女"));//  String.valueOf(user.isSex()));
      Date date=user.getBirthDay();
      if(date!=null) {
         SimpleDateFormat formatter = new SimpleDateFormat("MM 月 dd 日");
         tvBirthday.setText("生       日    --    " + formatter.format(date));
      }else {
         tvBirthday.setText("生       日    --    " + "未设置");
      }


      tvMeHead.setClickable(true);
      tvName.setClickable(true);
      tvMobile.setClickable(true);
      tvName.setClickable(true);
      tvPassword.setClickable(true);
      tvSex.setClickable(true);
      tvBirthday.setClickable(true);

   }

   @Override
   public void showNoLoginView() {

      //未登录显示
      toolName.setVisibility(View.GONE);
      toolLogin.setVisibility(View.VISIBLE);
      btnLoginOut.setVisibility(View.GONE);

      toolName.setText("");
      ivMeLogo.setImageResource(R.drawable.user);
      tvName.setText("昵       称");
      tvMobile.setText("联系电话");
      tvSex.setText("性       别");
      tvBirthday.setText("生       日");

      tvMeHead.setClickable(false);
      tvName.setClickable(false);
      tvMobile.setClickable(false);
      tvName.setClickable(false);
      tvPassword.setClickable(false);
      tvSex.setClickable(false);
      tvBirthday.setClickable(false);
   }

   @Override
   public void openSetHeadPhoto() {
      Intent it=new Intent(this.getContext(), HeadPhotoActivity.class);
      ivMeLogo.setDrawingCacheEnabled(true);
      it.putExtra("Bitmap",ivMeLogo.getDrawingCache());
      startActivityForResult(it,1);
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

   String mSelectedSex = "";
   @Override
   public void openSetSex() {

      new AlertDialog.Builder(getActivity()).setTitle("请选择性别")
              .setSingleChoiceItems(R.array.sex, (mUser.isSex()?1:0), new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
//                    Toast.makeText(getActivity(), "你点击了："+String.valueOf(i), Toast.LENGTH_SHORT).show();
                    String sex = getResources().getStringArray(R.array.sex)[i];
                   mSelectedSex = sex;
                 }
              })
              .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                    if (!mSelectedSex.isEmpty() && (mSelectedSex.equals("男") != mUser.isSex())) {
                       mUser.setSex(mSelectedSex.equals("男"));
                       mPresenter.setSex(mUser);
                    }
                 }
              })
              .setNegativeButton("取消", null).show();
   }

   @Override
   public void openSetBirthday() {
      Calendar calendar=Calendar.getInstance(Locale.CHINA);

     DatePickerDialog dialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
         @Override
         public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            String dateStr = i + "-" + i1 + "-" + i2;
            SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
            try {
               Date birthday=formatter.parse(dateStr);
               mUser.setBirthDay(birthday);
               mPresenter.setBirthday(mUser);
            } catch (ParseException e) {
               e.printStackTrace();
            }
         }
      }, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
      dialog.getDatePicker().setCalendarViewShown(false);
      dialog.setTitle("请选择出生日期");
      dialog.show();
   }

   @Override
   public void openSetAbout() {
      new AlertDialog.Builder(getActivity()).setTitle("阿米巴软件").setMessage("当前版本：V1.0").show();
   }

   @Override
   public void showSuccess(int type, String msg) {

   }

   @Override
   public void showFail(int type, String msg) {
      Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
   }
}
