package com.example.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.AdViewPagerAdapter;
import com.example.myapplication.entity.AdImage;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends Fragment implements ViewPager.OnPageChangeListener {
    //广告轮播图相关
    public static final int MSG_AD_ID=1;//广告自动滑动的消息id

    private ViewPager viewPager;
    private TextView tvDesc;//图片的描述
    private LinearLayout llPoint;//指示器的布局

    private List<AdImage> adImages;//数据
    private List<ImageView> imageViews;//图片的集合
    private int lastPos;//之前的位置

    public CourseFragment() {
        // Required empty public constructor
    }
    private static CourseFragment fragment;
    public static CourseFragment newInstance(){
        if(fragment==null){
            fragment=new CourseFragment();
        }
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course, container, false);

        //初始化数据、图片和控件对象
        initAdData();  //AdImage的集合
        initAdView(view);
        initIndicator(view);

        //设置ViewPager的初始状态
        lastPos = 0;
        llPoint.getChildAt(0).setEnabled(true);
        tvDesc.setText(adImages.get(0).getDesc());
        viewPager.setAdapter(new AdViewPagerAdapter(imageViews));
        return view;
    }

    private void initAdData(){
        adImages = new ArrayList<>();
        for (int i = 0; i<3;i++){
            AdImage adImage = new AdImage();
            adImage.setId(i+1);
            switch (i){
                case 0:
                    adImage.setImg("banner_1");
                    adImage.setDesc("新一代Apple Watch发布");
                    break;
                case 1:
                    adImage.setImg("banner_2");
                    adImage.setDesc("寒武纪发布AI芯片");
                    break;
                case 2:
                    adImage.setImg("banner_3");
                    adImage.setDesc("Google发布AI语音助手");
                    break;
                default:
                    break;
            }
            adImages.add(adImage);
        }
    }

    //初始化控件，生成图片合计
    private void initAdView(View view){
        tvDesc = view.findViewById(R.id.tv_desc);

        viewPager = view.findViewById(R.id.vp_banner);
        viewPager.addOnPageChangeListener(this);//设置ViewPager的监听

        imageViews = new ArrayList<>();
        for (int i = 0; i< adImages.size();i++){
            AdImage adImage = adImages.get(i);

            //添加图片到集合中
            ImageView iv = new ImageView(getContext());
            if("banner_1".equals(adImage.getImg())){
                iv.setBackgroundResource(R.drawable.zed);
            }else if("banner_2".equals(adImage.getImg())){
                iv.setBackgroundResource(R.drawable.zed);
            }else if("banner_3".equals(adImage.getImg())){
                iv.setBackgroundResource(R.drawable.zed);
            }
            imageViews.add(iv);
        }
    }

    //添加指示器圆点
    private void initIndicator(View view){
        llPoint = view.findViewById(R.id.ll_point);

        View pointView;
        for(int i = 0; i< adImages.size();i++){
            pointView = new View(getContext());
            pointView.setBackgroundResource(R.drawable.indicator_bg);
            pointView.setEnabled(false);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(16,16);
            if(i != 0){
                params.leftMargin = 10;
            }
            llPoint.addView(pointView,params);
        }
    }

    @Override
    public void onPageSelected(int position){
        int currentPos = position % adImages.size();
        tvDesc.setText(adImages.get(currentPos).getDesc());

        llPoint.getChildAt(lastPos).setEnabled(false);
        llPoint.getChildAt(currentPos).setEnabled(true);
        lastPos = currentPos;
    }


    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }


    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
