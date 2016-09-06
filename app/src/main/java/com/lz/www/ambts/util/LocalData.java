package com.lz.www.ambts.util;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.AdDomain;
import com.lz.www.ambts.model.bean.Attend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-09-06.
 */
public class LocalData {
    /**
     * 轮播广播模拟数据
     *
     * @return
     */
    public static List<AdDomain> getBannerAd() {

        List<AdDomain> adList = new ArrayList<AdDomain>();

        AdDomain adDomain = new AdDomain();
        adDomain.setId("1");
        adDomain.setDate("3月4日");
        adDomain.setTitle("中国阿米巴落地领导者--道成智聚");
        adDomain.setAd(false);
        adDomain.setImgID(R.drawable.banner5);
        adList.add(adDomain);

        AdDomain adDomain2 = new AdDomain();
        adDomain2.setId("2");
        adDomain2.setDate("3月5日");
        adDomain2.setTitle("【理念 + 算盘】经营实学创始人--田和喜");
        adDomain2.setAd(false);
        adDomain2.setImgID(R.drawable.banner3);
        adList.add(adDomain2);

        AdDomain adDomain3 = new AdDomain();
        adDomain3.setId("3");
        adDomain3.setDate("3月6日");
        adDomain3.setTitle("什么是【理念 + 算盘】？");
        adDomain3.setAd(false);
        adDomain3.setImgID(R.drawable.banner2);
        adList.add(adDomain3);

        AdDomain adDomain4 = new AdDomain();
        adDomain4.setId("4");
        adDomain4.setDate("3月7日");
        adDomain4.setTitle("金正大集团启动阿米巴项目");
        adDomain4.setAd(false);
        adDomain4.setImgID(R.drawable.banner4);
        adList.add(adDomain4);

        AdDomain adDomain5 = new AdDomain();
        adDomain5.setId("5");
        adDomain5.setDate("3月8日");
        adDomain5.setTitle("9月广州课程，期待你的加入！");
        adDomain5.setAd(true); // 代表是广告
        adDomain5.setImgID(R.drawable.banner1);
        adList.add(adDomain5);

        return adList;
    }

    //获取考勤数据
    public static List<Attend> getAttendList(){
        List<Attend> list = new ArrayList<Attend>();

        Attend m1=new Attend();
        m1.setID(1);
        m1.setDateDisplay("七月");
        m1.setShouldDays(23);
        m1.setActualDays(20);
        m1.setLateCount(3);
        m1.setLeaveCount(2);
        m1.setAbsentCount(1);
        list.add(m1);

        Attend m2=new Attend();
        m2.setID(2);
        m2.setDateDisplay("八月");
        m2.setShouldDays(24);
        m2.setActualDays(23);
        m2.setLateCount(2);
        m2.setLeaveCount(1);
        m2.setAbsentCount(0);
        list.add(m2);

        Attend m3=new Attend();
        m3.setID(3);
        m3.setDateDisplay("九月");
        m3.setShouldDays(22);
        m3.setActualDays(23);
        m3.setLateCount(3);
        m3.setLeaveCount(0);
        m3.setAbsentCount(0);
        list.add(m3);

        return list;
    }
}
