package com.lz.www.ambts.ui.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;


import com.lz.www.ambts.R;
import com.lz.www.ambts.model.BigSorts;
import com.lz.www.ambts.model.SubSorts;
import com.lz.www.ambts.model.bean.Fa;
import com.lz.www.ambts.model.bean.Report;
import com.lz.www.ambts.presenter.jk.IReportPresenter;
import com.lz.www.ambts.ui.adapter.FaAdapter;
import com.lz.www.ambts.ui.component.DaggerReportComponent;
import com.lz.www.ambts.ui.jk.IReportView;
import com.lz.www.ambts.ui.module.ReportModule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016-06-23.
 */
public class ReportFragment extends Fragment implements IReportView {

    @Inject
    IReportPresenter mPresenter;

    @InjectView(R.id.elvFa)
    ExpandableListView elvFa;
    @InjectView(R.id.btnReportDate)
    Button btnDate;
    @InjectView(R.id.tvNoData)
    TextView tvNoData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fa_report,container,false);

        ButterKnife.inject(this,view);

        DaggerReportComponent.builder()
                .reportModule(new ReportModule(this))
                .build()
                .inject(this);

        btnDate.setText("2016 年 9 月");
        mPresenter.start();

        return view;
    }

    @OnClick(R.id.btnReportDate)
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.btnReportDate:
                Calendar calendar=Calendar.getInstance(Locale.CHINA);
                DatePickerDialog dialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        int month=i1+1;
                        String chinaDateStr = i + " 年 " + month + " 月";
                        btnDate.setText(chinaDateStr);

                        String ym=String.valueOf(i) + String.format("%02d",month);
                        mPresenter.loadAllList(ym);

//                        String dateStr = i + "-" + i1 + "-" + i2;
//                        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//                        try {
//                            Date date = formatter.parse(dateStr);
//                            String ym = formatter.format(date);
//                            mPresenter.loadAllList(ym);
//                        } catch (ParseException e) {
//                            e.printStackTrace();
//                        }
                    }
                }, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                dialog.getDatePicker().setCalendarViewShown(false);
                dialog.setTitle("请选择出生日期");
                dialog.show();
                break;
        }
    }




    @Override
    public void showAllList(ArrayList<Fa> groupList, ArrayList<ArrayList<Fa>> subList) {
        tvNoData.setVisibility(View.GONE);
        elvFa.setVisibility(View.VISIBLE);
        FaAdapter faAdapter=new FaAdapter(groupList,subList,getActivity());
        elvFa.setAdapter(faAdapter);
        elvFa.expandGroup(0);
    }

    @Override
    public void showLoadError() {
        tvNoData.setVisibility(View.VISIBLE);
        elvFa.setVisibility(View.GONE);
       // Toast.makeText(getActivity(), "加载错误", Toast.LENGTH_SHORT).show();
    }
}
