package site.duqian.weex;

import android.app.Application;
import android.util.Log;

import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import site.duqian.weex.extend.adapter.ImageAdapter;
import site.duqian.weex.extend.compontent.RichText;
import site.duqian.weex.extend.module.MyMoudle;
import site.duqian.weex.extend.module.PhoneInfoModule;

/**
 * 注意要在Manifest中启用
 * 参考manifest，否则会抛出ExceptionInInitializerError
 * 要实现ImageAdapter 否则图片不能下载
 * gradle 中一定要添加一些依赖，否则初始化会失败。
 * compile 'com.android.support:recyclerview-v7:23.1.1'
 * compile 'com.android.support:support-v4:23.1.1'
 * compile 'com.android.support:appcompat-v7:23.1.1'
 * compile 'com.alibaba:fastjson:1.1.45'
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            InitConfig config = new InitConfig.Builder().setImgAdapter(new ImageAdapter()).build();
            WXSDKEngine.initialize(this, config);
            WXSDKEngine.registerModule("MyMoudle", MyMoudle.class);
            WXSDKEngine.registerModule("PhoneInfoModule", PhoneInfoModule.class);
            WXSDKEngine.registerComponent("RichText", RichText.class, false);
        } catch (WXException e) {
            e.printStackTrace();
            Log.d("dq", "initialize weex sdk error " + e.toString());
        }
    }
}
