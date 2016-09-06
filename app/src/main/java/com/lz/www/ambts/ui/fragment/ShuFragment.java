package com.lz.www.ambts.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lz.www.ambts.R;
import com.lz.www.ambts.ui.AmbLogActivity;
import com.lz.www.ambts.ui.AnimationActivity;
import com.lz.www.ambts.ui.AttendActivity;
import com.lz.www.ambts.ui.ContractsActivity;
import com.lz.www.ambts.ui.EmployeePhotoActivity;
import com.lz.www.ambts.ui.NoticeActivity;
import com.lz.www.ambts.ui.PhotoActivity;
import com.lz.www.ambts.ui.RockActivity;
import com.lz.www.ambts.ui.ScheduleActivity;
import com.lz.www.ambts.ui.ShakeActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016-06-24.
 */
public class ShuFragment extends Fragment {

    private SimpleAdapter mAdapter=null;
    private List<Map<String, Object>> data_list;
    // 图片封装为一个数组
    private int[] icon = { R.drawable.shu_notice,R.drawable.shu_date, R.drawable.shu_tel,
            R.drawable.pictures_no, R.drawable.pictures_no, R.drawable.shu_home,
            R.drawable.pictures_no, R.drawable.pictures_no, R.drawable.pictures_no,
            R.drawable.pictures_no, R.drawable.pictures_no,R.drawable.pictures_no };
    private String[] iconName = {"企业公告","日程安排", "通讯录","考勤管理","费用报销","员工风采","摇一摇",  "绘画动画","地理位置", "系统日志", "null",  "null", };

    @InjectView(R.id.gvShu)
    GridView gridView;

    @InjectView(R.id.myTool)
    Toolbar toolbar;
    @InjectView(R.id.toolTvTitle)
    TextView toolTvTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_shu,container,false);

        ButterKnife.inject(this,view);

        toolTvTitle.setText("应用工具");

        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.ivGvShu,R.id.tvGvShu};
        mAdapter = new SimpleAdapter(getActivity(), data_list, R.layout.item_gv_shu, from, to);
        //配置适配器
        gridView.setAdapter(mAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent it0=new Intent(getActivity(),NoticeActivity.class);
                        startActivity(it0);
                        break;
                    case 1:
                        Intent it1=new Intent(getActivity(),ScheduleActivity.class);
                        startActivity(it1);
                        break;
                    case 2:
                        Intent it2=new Intent(getActivity(),ContractsActivity.class);
                        startActivity(it2);
                        break;
                    case 3:
                        Intent it3=new Intent(getActivity(),AttendActivity.class);
                        startActivity(it3);
                        break;
                    case 4:
//                        Intent it4=new Intent(getActivity(),AttendActivity.class);
//                        startActivity(it4);
                        Toast.makeText(getActivity(),"该功能还未开放！",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Intent it5=new Intent(getActivity(),EmployeePhotoActivity.class);
                        startActivity(it5);
                        break;
                    case 6:
                        Intent it6=new Intent(getActivity(),RockActivity.class);
                        startActivity(it6);
                        break;
                    case 7:
                        Intent it7=new Intent(getActivity(),AnimationActivity.class);
                        startActivity(it7);
                        break;
                    case 8:
//                        Intent it10=new Intent(getActivity(), MapActivity.class);
//                        startActivity(it10);
                        break;
                    case 9:
                        Intent it11=new Intent(getActivity(), AmbLogActivity.class);
                        startActivity(it11);
                        break;
                    default:
                        Toast.makeText(getActivity(),"你点击了第" + i + "项",Toast.LENGTH_SHORT).show();
                        break;

                }
              //  Toast.makeText(getActivity(),"你点击了第" + i + "项",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }


}
