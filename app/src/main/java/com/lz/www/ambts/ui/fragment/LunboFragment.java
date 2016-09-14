package com.lz.www.ambts.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.AdDomain;
import com.lz.www.ambts.util.LocalData;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016-08-19.
 */
public class LunboFragment extends Fragment {

    public static String IMAGE_CACHE_PATH = "imageloader/Cache"; // 图片缓存路径

    @InjectView(R.id.vpLunBo)
    ViewPager adViewPager;
//    @InjectView(R.id.tv_date)
//    TextView tv_date;
    @InjectView(R.id.tv_title)
    TextView tv_title;
//    @InjectView(R.id.tv_topic_from)
//    TextView tv_topic_from;
//    @InjectView(R.id.tv_topic)
//    TextView tv_topic;
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

    private List<ImageView> imageViews;// 滑动的图片集合
    private List<View> dots; // 图片标题正文的那些点
    private List<View> dotList;
    int currentItem = 0; // 当前图片的索引号
    private ScheduledExecutorService scheduledExecutorService;//定时服务
//    private ImageLoader mImageLoader;    // 异步加载图片
//    private DisplayImageOptions options;  // 异步加载图片参数
    private List<AdDomain> adList;    // 轮播banner的数据


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_lunbo, container,false);
        ButterKnife.inject(this,view);
        // 使用ImageLoader之前初始化
        initImageLoader();
        // 获取图片加载实例
//        mImageLoader = ImageLoader.getInstance();
//        options = new DisplayImageOptions.Builder()
//                .showStubImage(R.drawable.top_banner_android)
//                .showImageForEmptyUri(R.drawable.top_banner_android)
//                .showImageOnFail(R.drawable.top_banner_android)
//                .cacheInMemory(true).cacheOnDisc(true)
//                .bitmapConfig(Bitmap.Config.RGB_565)
//                .imageScaleType(ImageScaleType.EXACTLY).build();

        initAdData();
        startAd();
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        // 当Activity不可见的时候停止切换
        scheduledExecutorService.shutdown();
    }

    private void initImageLoader() {
//        File cacheDir = com.nostra13.universalimageloader.utils.StorageUtils.getOwnCacheDirectory(getActivity().getApplicationContext(),IMAGE_CACHE_PATH);
//        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).build();

//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity())
//                .defaultDisplayImageOptions(defaultOptions)
//                .memoryCache(new LruMemoryCache(12 * 1024 * 1024))
//                .memoryCacheSize(12 * 1024 * 1024)
//                .discCacheSize(32 * 1024 * 1024).discCacheFileCount(100)
//                .discCache(new UnlimitedDiscCache(cacheDir))
//                .threadPriority(Thread.NORM_PRIORITY - 2)
//                .tasksProcessingOrder(QueueProcessingType.LIFO).build();

 //       ImageLoader.getInstance().init(config);
    }

    private void initAdData() {
        // 广告数据
        adList = LocalData.getBannerAd();
        imageViews = new ArrayList<ImageView>();
        // 点
        dots = new ArrayList<View>();
        dotList = new ArrayList<View>();

        dots.add(dot0);
        dots.add(dot1);
        dots.add(dot2);
        dots.add(dot3);
        dots.add(dot4);

        adViewPager.setAdapter(new MyAdapter());// 设置填充ViewPager页面的适配器
        // 设置一个监听器，当ViewPager中的页面改变时调用
        adViewPager.setOnPageChangeListener(new MyPageChangeListener());
        addDynamicView();
    }

    private void addDynamicView() {
        // 动态添加图片和下面指示的圆点
        // 初始化图片资源
        for (int i = 0; i < adList.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            // 异步加载图片
           // mImageLoader.displayImage(adList.get(i).getImgUrl(), imageView,options);
//            imageView.setImageResource(adList.get(i).getImgID());

            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.with(getActivity())
                    .load(adList.get(i).getImgID())
                    .resize(350,210)
                    .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE)
                    .into(imageView);
            imageViews.add(imageView);
            dots.get(i).setVisibility(View.VISIBLE);
            dotList.add(dots.get(i));
        }
    }

    private void startAd() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // 当Activity显示出来后，每两秒切换一次图片显示
        scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2, TimeUnit.SECONDS);
    }


    //循环轮播主线程处理
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            adViewPager.setCurrentItem(currentItem);
        };
    };

    //循环轮播
    private class ScrollTask implements Runnable {
        @Override
        public void run() {
            synchronized (adViewPager) {
                currentItem = (currentItem + 1) % imageViews.size();
                handler.obtainMessage().sendToTarget();
            }
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
//            tv_date.setText(adDomain.getDate());
//            tv_topic_from.setText(adDomain.getTopicFrom());
//            tv_topic.setText(adDomain.getTopic());
            dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            dots.get(position).setBackgroundResource(R.drawable.dot_focused);
            oldPosition = position;
        }
    }

    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return adList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = imageViews.get(position);
            ((ViewPager) container).addView(iv);
            final AdDomain adDomain = adList.get(position);
            // 在这个方法里面设置图片的点击事件
            iv.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // 处理跳转逻辑
                }
            });
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

}
