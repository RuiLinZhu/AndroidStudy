package com.example.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.entity.AdImage;

import java.util.List;

public class AdBannerFragment extends Fragment {
    private ImageView iv;

    private String ab;
    private List<AdImage> adImages;

//    private AdBannerFragment() {
//
//    }

    public static AdBannerFragment newInstance() {
        return new AdBannerFragment();
    }

    public static AdBannerFragment newInstance(Bundle args) {
        AdBannerFragment fragment = new AdBannerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 获取广告图片的名称
        Bundle arg = getArguments();
        if (arg != null) {
            ab = arg.getString("ad");
        } else {
            ab = "banner_1";
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        // 根据图片名称加载广告图片
        if (ab != null) {
            if ("banner_1".equals(ab)) {
                iv.setImageResource(R.drawable.zed);
            } else if ("banner_2".equals(ab)) {
                iv.setImageResource(R.drawable.zed);
            } else if ("banner_3".equals(ab)) {
                iv.setImageResource(R.drawable.zed);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (iv != null) {
            iv.setImageDrawable(null);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        iv = new ImageView(getActivity());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        iv.setLayoutParams(params);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        return iv;
    }
}
