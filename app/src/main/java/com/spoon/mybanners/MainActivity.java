package com.spoon.mybanners;

import android.Manifest;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.spoon.mybannerlib.BannerHeader;
import com.spoon.mybannerlib.bean.Banner;
import com.spoon.mybannerlib.bean.PageBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MPermissionsActivity {

    private RequestManager mImgLoader;
    private BannerHeader mHeaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestPermission(new String[]{Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0x0001);
    }

    /**
     * 权限成功回调函数
     *
     * @param requestCode
     */
    @Override
    public void permissionSuccess(int requestCode) {
        super.permissionSuccess(requestCode);
        switch (requestCode) {
            case 0x0001:
                setContentView(getHeaderView());
                break;
        }

    }

    public View getHeaderView() {
        mHeaderView = new BannerHeader(this);
        mHeaderView.setOnBannerClick(new BannerHeader.OnBannerClick() {
            @Override
            public void onClick(Banner banner) {
                Toast.makeText(MainActivity.this, banner.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        mHeaderView.setRefreshLayout(null);
        getBannerList();
        return mHeaderView;
    }

    /**
     * 获取一个图片加载管理器
     *
     * @return RequestManager
     */
    public synchronized RequestManager getImgLoader() {
        if (mImgLoader == null)
            mImgLoader = Glide.with(this);
        return mImgLoader;
    }

    public void getBannerList() {
        final PageBean<Banner> banners = new PageBean<>();
        List<Banner> bannerList = new ArrayList<>();
        Banner banner = new Banner();
        banner.setId(78803);
        banner.setName("2016开源中国源创会年终盛典");
        banner.setImg("http://static.oschina.net/uploads/cooperation/75323/ubuntu-forum-black-sql_89cc6798-d602-4e9c-a89e-aebc10a71962.jpg");
        banner.setHref("http://www.oschina.net/2016-beijing-ceremony");
        banner.setPubDate("2016-11-17 15:11:15");
        bannerList.add(banner);
        banner = new Banner();
        banner.setId(2207700);
        banner.setName("高手问答 | React 全栈整合开发");
        banner.setImg("https://static.oschina.net/uploads/cooperation/75323/ubuntu-forum-black-sql_ce30eb23-4cee-4e32-b130-6d9740b8eade.jpg");
        banner.setHref("http://www.oschina.net/2016-beijing-ceremony");
        banner.setPubDate("2016-11-17 15:11:15");
        bannerList.add(banner);
        banner = new Banner();
        banner.setId(79403);
        banner.setName("谁需要 GUI？—— Linux 终端生存之道");
        banner.setImg("https://static.oschina.net/uploads/cooperation/78083/chrome55-save-at-least-35-percent-memory_98201bf4-d344-4d55-a591-e66ad05c4bf1.jpg");
        banner.setHref("http://www.oschina.net/2016-beijing-ceremony");
        banner.setPubDate("2016-11-17 15:11:15");
        bannerList.add(banner);
        banners.setItems(bannerList);
        mHeaderView.initData(getImgLoader(), banners.getItems());
    }
}
