package com.lz.www.ambts.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.NewsModel;
import com.lz.www.ambts.model.bean.AdDomain;
import com.lz.www.ambts.presenter.NewsPresenter;
import com.lz.www.ambts.ui.adapter.BannerPagerAdapter;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by Administrator on 2016-08-04.
 */
public class BannerActivity extends AppCompatActivity {


    public static String IMAGE_CACHE_PATH = "imageloader/Cache"; // 图片缓存路径

    @InjectView(R.id.vp)
    ViewPager adViewPager;
    List<ImageView> imageViews;// 滑动的图片集合

    @InjectView(R.id.tv_date)
    TextView tv_date;
    @InjectView(R.id.tv_title)
    TextView tv_title;
    @InjectView(R.id.tv_topic_from)
    TextView tv_topic_from;
    @InjectView(R.id.tv_topic)
    TextView tv_topic;

    private int currentItem = 0; // 当前图片的索引号
    // 定义的五个指示点
    @InjectView(R.id.v_dot0)
    View dot0;
    @InjectView(R.id.v_dot1)
    View dot1;
    @InjectView(R.id.v_dot2)
    View dot2;
    @InjectView(R.id.v_dot3)
    View dot3;
    @InjectView(R.id.v_dot4)
    View dot4;

    @InjectView(R.id.btnLoad)
    Button btnTest;
    @InjectView(R.id.imgTest)
    ImageView imgTest;

    private List<View> dots; // 图片标题正文的那些点
    private List<View> dotList;
    private List<AdDomain> adList;// 轮播banner的数据

    // 定时任务
    private ScheduledExecutorService scheduledExecutorService;

    // 异步加载图片
    private ImageLoader mImageLoader;
    private DisplayImageOptions options;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_banner);

        ButterKnife.inject(this);

        btnTest=(Button)findViewById(R.id.btnLoad);
        imgTest=(ImageView)findViewById(R.id.imgTest);


        // 使用ImageLoader之前初始化
//        initImageLoader();

        // 获取图片加载实例
        mImageLoader = ImageLoader.getInstance();
//        options = new DisplayImageOptions.Builder()
//                .showStubImage(R.drawable.top_banner_android)
//                .showImageForEmptyUri(R.drawable.top_banner_android)
//                .showImageOnFail(R.drawable.top_banner_android)
//                .cacheInMemory(true).cacheOnDisc(true)
//                .bitmapConfig(Bitmap.Config.RGB_565)
//                .imageScaleType(ImageScaleType.EXACTLY).build();

        initAdData();

        //startAd();

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageLoader.displayImage("drawable://" + R.drawable.mn2
                        ,imgTest
                        );
            }
        });
    }


//    private void initImageLoader() {
//        File cacheDir = com.nostra13.universalimageloader.utils.StorageUtils
//                .getOwnCacheDirectory(getApplicationContext(),
//                        IMAGE_CACHE_PATH);
//
//        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
//                .cacheInMemory(true).cacheOnDisc(true).build();
//
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
//                this).defaultDisplayImageOptions(defaultOptions)
//                .memoryCache(new LruMemoryCache(12 * 1024 * 1024))
//                .memoryCacheSize(12 * 1024 * 1024)
//                .discCacheSize(32 * 1024 * 1024).discCacheFileCount(100)
//                .discCache(new UnlimitedDiscCache(cacheDir))
//                .threadPriority(Thread.NORM_PRIORITY - 2)
//                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
//
//        ImageLoader.getInstance().init(config);
//    }

    /**
     * 初始化广告数据
     */
    private void initAdData() {
        // 广告数据
        adList = new NewsModel().getAdList();
        imageViews = new ArrayList<ImageView>();
        // 点
        dots = new ArrayList<View>();
        dotList = new ArrayList<View>();
//        dot0 = findViewById(R.id.v_dot0);
//        dot1 = findViewById(R.id.v_dot1);
//        dot2 = findViewById(R.id.v_dot2);
//        dot3 = findViewById(R.id.v_dot3);
//        dot4 = findViewById(R.id.v_dot4);
        dots.add(dot0);
        dots.add(dot1);
        dots.add(dot2);
        dots.add(dot3);
        dots.add(dot4);

//        tv_date = (TextView) findViewById(R.id.tv_date);
//        tv_title = (TextView) findViewById(R.id.tv_title);
//        tv_topic_from = (TextView) findViewById(R.id.tv_topic_from);
//        tv_topic = (TextView) findViewById(R.id.tv_topic);

//        adViewPager = (ViewPager) findViewById(R.id.vp);
        adViewPager.setAdapter(new MyAdapter());// 设置填充ViewPager页面的适配器
        // 设置一个监听器，当ViewPager中的页面改变时调用
        adViewPager.setOnPageChangeListener(new MyPageChangeListener());

        // 动态添加图片和下面指示的圆点
        // 初始化图片资源
        for (int i = 0; i < adList.size(); i++) {
            ImageView imageView = new ImageView(this);
            // 异步加载图片
            mImageLoader.displayImage(adList.get(i).getImgUrl(), imageView, options);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageViews.add(imageView);
            dots.get(i).setVisibility(View.VISIBLE);
            dotList.add(dots.get(i));
        }
    }

//    private void addDynamicView() {
//        // 动态添加图片和下面指示的圆点
//        // 初始化图片资源
//        for (int i = 0; i < adList.size(); i++) {
//            ImageView imageView = new ImageView(this);
//            // 异步加载图片
//            mImageLoader.displayImage(adList.get(i).getImgUrl(), imageView,
//                    options);
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageViews.add(imageView);
//            dots.get(i).setVisibility(View.VISIBLE);
//            dotList.add(dots.get(i));
//        }
//    }


    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            adViewPager.setCurrentItem(currentItem);
        };
    };

    private void startAd() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // 当Activity显示出来后，每两秒切换一次图片显示
        scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2,
                TimeUnit.SECONDS);
    }

    private class ScrollTask implements Runnable {

        @Override
        public void run() {
            synchronized (adViewPager) {
                currentItem = (currentItem + 1) % imageViews.size();
                handler.obtainMessage().sendToTarget();
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 当Activity不可见的时候停止切换
        scheduledExecutorService.shutdown();
    }

    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return adList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = imageViews.get(position);
            //((ViewPager) container).addView(iv);
            container.addView(iv);

//            final AdDomain adDomain = adList.get(position);
//            // 在这个方法里面设置图片的点击事件
//            iv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // 处理跳转逻辑
//                }
//            });
            return iv;
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {

        }

        @Override
        public void finishUpdate(View arg0) {

        }

    }

    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        private int oldPosition = 0;

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int position) {
            currentItem = position;
            AdDomain adDomain = adList.get(position);
            tv_title.setText(adDomain.getTitle()); // 设置标题
            tv_date.setText(adDomain.getDate());
            tv_topic_from.setText(adDomain.getTopicFrom());
            tv_topic.setText(adDomain.getTopic());
            dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            dots.get(position).setBackgroundResource(R.drawable.dot_focused);
            oldPosition = position;
        }
    }
}
