package com.lz.www.ambts.ui.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lz.www.ambts.R;
import com.lz.www.ambts.ui.HeadPhotoActivity;


public class WoFragment extends Fragment {

   TextView txtUpdateHead;

   @Nullable
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_wo,container,false);
      txtUpdateHead=(TextView)view.findViewById(R.id.tvMeHead);
      txtUpdateHead.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent it=new Intent(getActivity(), HeadPhotoActivity.class);
            startActivity(it);
            Toast.makeText(getActivity(),"clicked head",Toast.LENGTH_SHORT).show();
         }
      });

      return view;
   }
}
