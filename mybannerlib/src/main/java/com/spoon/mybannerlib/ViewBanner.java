package com.spoon.mybannerlib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.RequestManager;
import com.spoon.mybannerlib.bean.Banner;

public class ViewBanner extends RelativeLayout {
    private Banner banner;
    private ImageView iv_banner;

    public ViewBanner(Context context) {
        super(context, null);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_banner, this, true);
        iv_banner = (ImageView) findViewById(R.id.iv_banner);
    }

    public void initData(RequestManager manager, Banner banner) {
        this.banner = banner;
        manager.load(banner.getImg()).into(iv_banner);
    }

    public String getTitle() {
        return banner.getName();
    }
}
