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

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.lz.www.ambts.R;
import com.lz.www.ambts.ui.AmbLogActivity;
import com.lz.www.ambts.ui.AnimationActivity;
import com.lz.www.ambts.ui.AttendActivity;
import com.lz.www.ambts.ui.ContractsActivity;
import com.lz.www.ambts.ui.EmployeePhotoActivity;
import com.lz.www.ambts.ui.LogActivity;
import com.lz.www.ambts.ui.MapActivity;
import com.lz.www.ambts.ui.NewsDetailActivity;
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
    private int[] icon = { R.drawable.app_notice,R.drawable.app_schedule, R.drawable.app_tel,
                             R.drawable.app_fee, R.drawable.app_attend, R.drawable.app_photo,
                             R.drawable.app_audit, R.drawable.app_scan, R.drawable.app_map_c,
                             R.drawable.app_log2, R.drawable.app_dczj_white,R.drawable.app_more_a };
    private String[] iconName = { "企业公告","日程安排", "通讯录",
                                     "费用报销","考勤管理","员工风采",
                                     "工作审批","扫一扫","地理位置",
                                     "系统日志", "关于道成",  "更多", };

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
                        Toast.makeText(getActivity(),"该功能还未开放！",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Intent it4=new Intent(getActivity(),AttendActivity.class);
                        startActivity(it4);
                        break;
                    case 5:
                        Intent it5=new Intent(getActivity(),PhotoActivity.class);
                        startActivity(it5);
                        break;
                    case 6:
                        Toast.makeText(getActivity(),"该功能还未开放！",Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
//                        Intent it7=new Intent(getActivity(),RockActivity.class);
//                        startActivity(it7);
                        IntentIntegrator integrator=new IntentIntegrator(getActivity());
                        integrator.initiateScan();
                        break;
                    case 8:
                        Intent it10=new Intent(getActivity(), MapActivity.class);
                        startActivity(it10);
                        break;
                    case 9:
                        Intent it9=new Intent(getActivity(), LogActivity.class);
                        startActivity(it9);
                        break;
                    case 10:
                        Intent it = new Intent(getActivity(), NewsDetailActivity.class);
                        it.putExtra("url","http://www.simchn.com/");
                        it.putExtra("title","关于道成");
                        startActivity(it);
                        break;
                    case 11:
                        Toast.makeText(getActivity(),"敬请期待！",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getActivity(),"敬请期待！",Toast.LENGTH_SHORT).show();
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
