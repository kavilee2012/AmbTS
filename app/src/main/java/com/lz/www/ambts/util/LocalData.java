package com.lz.www.ambts.util;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.AdDomain;
import com.lz.www.ambts.model.bean.Attend;
import com.lz.www.ambts.model.bean.Notice;

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
        adDomain.setTitle("阿米巴解决方案领导者");
        adDomain.setAd(false);
        adDomain.setImgID(R.drawable.banner6);
        adDomain.setTargetUrl("http://www.simclouds.com/");
        adList.add(adDomain);

        AdDomain adDomain2 = new AdDomain();
        adDomain2.setId("2");
        adDomain2.setDate("3月5日");
        adDomain2.setTitle("【理念 + 算盘】经营实学创始人--田和喜");
        adDomain2.setAd(false);
        adDomain2.setImgID(R.drawable.banner3);
        adDomain2.setTargetUrl("http://www.simchn.com/index.php?g=home&m=article&a=show&id=17");
        adList.add(adDomain2);

        AdDomain adDomain3 = new AdDomain();
        adDomain3.setId("3");
        adDomain3.setDate("3月6日");
        adDomain3.setTitle("什么是【理念 + 算盘】？");
        adDomain3.setAd(false);
        adDomain3.setImgID(R.drawable.banner2);
        adDomain3.setTargetUrl("http://www.simchn.com/index.php?g=home&m=page&a=index&id=34");
        adList.add(adDomain3);

        AdDomain adDomain4 = new AdDomain();
        adDomain4.setId("4");
        adDomain4.setDate("3月7日");
        adDomain4.setTitle("金正大集团启动阿米巴项目");
        adDomain4.setAd(false);
        adDomain4.setImgID(R.drawable.banner4);
        adDomain4.setTargetUrl("http://www.simchn.com/index.php?g=home&m=article&a=show&id=1130");
        adList.add(adDomain4);

        AdDomain adDomain5 = new AdDomain();
        adDomain5.setId("5");
        adDomain5.setDate("3月8日");
        adDomain5.setTitle("9月广州课程，期待你的加入！");
        adDomain5.setAd(true); // 代表是广告
        adDomain5.setImgID(R.drawable.banner1);
        adDomain5.setTargetUrl("http://www.simchn.com/index.php?g=home&m=kecheng&a=show&id=7");
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

    public static List<Notice> getNoticeList() {
        List<Notice> list = new ArrayList<Notice>();
        Notice m1=new Notice();
        m1.setID(1);
        m1.setTitle("阿米巴管理软件V2.0已正式发布！");
        m1.setContent("由我公司研发的，拥有自主知识产权的《阿米巴管理软件V2.0》已于2016年8月25日正式发布，请功能增加了内部交易，量化公权功能等，欢迎下载试用！");
        m1.setAddTime("2016-8-25");
        m1.setAddUser("市场部");
        list.add(m1);

        Notice m2=new Notice();
        m2.setID(2);
        m2.setTitle("9月5号上午10点，销售部员工参加新产品培训");
        m2.setContent("销售部员工请注意，下周一（9月5号）上午10点，将在大会议室进行公司新产品培训，由李经理主持，请大家准时参加，不要迟到。");
        m2.setAddTime("2016-9-3");
        m2.setAddUser("销售部");
        list.add(m2);

        Notice m3=new Notice();
        m3.setID(3);
        m3.setTitle("八月份优秀员工评选结果出炉");
        m3.setContent("经过各部门领导以及公司领导的评选，八月份优秀员工前三名获奖名单已经出炉。第一名：田元  第二名：崔华  第三名：舒进华。 恭喜获奖的小伙伴，其它小伙伴也请继续努力！！！");
        m3.setAddTime("2016-9-1");
        m3.setAddUser("人事部");
        list.add(m3);

        Notice m4=new Notice();
        m4.setID(4);
        m4.setTitle("八月份考勤统计已经发布，请及时核对！");
        m4.setContent("八月份考勤统计已经发布到管理系统，请各位通过‘术-->考勤管理’进行及时核对，如有疑问，请联系人事部。");
        m4.setAddTime("2016-9-3");
        m4.setAddUser("人事部");
        list.add(m4);

        Notice m5=new Notice();
        m5.setID(5);
        m5.setTitle("十月份销售部员工自定目标清单");
        m5.setContent("十月份销售部各员工自定的信息目标清单已经贴到公告栏，请各位相互帮助，早日完成目标，加油！！！");
        m5.setAddTime("2016-9-15");
        m5.setAddUser("销售部");
        list.add(m5);

        Notice m6=new Notice();
        m6.setID(6);
        m6.setTitle("关于八周年庆各部门分工安排");
        m6.setContent("关于八周年庆各部门分工安排已经贴到公告栏，请各部门领导安排好各成员的工作事项，谢谢！");
        m6.setAddTime("2016-9-21");
        m6.setAddUser("行政部");
        list.add(m6);

        return list;
    }

    public static List<Notice> getLogList() {
        List<Notice> list = new ArrayList<Notice>();
        Notice m1=new Notice();
        m1.setID(1);
        m1.setTitle("操作：登录失败");
        m1.setContent("网络连接超时");
        m1.setAddTime("2016-10-3");
        m1.setAddUser("lz");
        list.add(m1);

        Notice m2=new Notice();
        m2.setID(2);
        m2.setTitle("操作：上传头像");
        m2.setContent("");
        m2.setAddTime("2016-10-4");
        m2.setAddUser("lz");
        list.add(m2);

        Notice m3=new Notice();
        m3.setID(3);
        m3.setTitle("操作：网络发生异常");
        m3.setContent("17:29:31.305 2263-2263/com.lz.www.ambts E/dalvikvm: Could not find class 'android.os.PersistableBundle', referenced from method com.lz.www.ambts.ui.HomeActivity.access$super");
        m3.setAddTime("2016-10-6");
        m3.setAddUser("lz");
        list.add(m3);

        Notice m4=new Notice();
        m4.setID(4);
        m4.setTitle("操作：网络发生异常");
        m4.setContent("17:29:31.310 2263-2263/com.lz.www.ambts E/dalvikvm: Could not find class 'android.app.ActivityManager$TaskDescription', referenced from method com.lz.www.ambts.ui.HomeActivity.access$super");
        m4.setAddTime("2016-10-8");
        m4.setAddUser("未知");
        list.add(m4);

        Notice m5=new Notice();
        m5.setID(5);
        m5.setTitle("操作：未知异常");
        m5.setContent("16:50:21 PSI and index do not match: PSI and index do not match");
        m5.setAddTime("2016-10-15");
        m5.setAddUser("未知");
        list.add(m5);

        Notice m6=new Notice();
        m6.setID(6);
        m6.setTitle("操作：添加日程安排");
        m6.setContent("");
        m6.setAddTime("2016-10-21");
        m6.setAddUser("lz");
        list.add(m6);

        return list;
    }
}
