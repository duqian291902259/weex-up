package com.weex.sample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;
import com.weex.sample.Constants;
import com.weex.sample.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MultiInstanceActivity extends AppCompatActivity {

    @BindView(R.id.containerA)
    FrameLayout containerA;
    @BindView(R.id.containerB)
    FrameLayout containerB;
    //server端js测试
    private static String BASE_HOST ="http://192.168.0.68:8081";
    //private static String LOCAL_JS_URL = BASE_HOST+"/dist/hello.js";
    //private static String TEST_URL = BASE_HOST+"/dist/postmsg.js";
    //本地js测试
    private static String LOCAL_JS_URL = "file://weex/hello.js";
    private static String TEST_URL = "file://weex/postmsg.js";

    private WXSDKInstance mWXSDKInstanceA;
    private WXSDKInstance mWXSDKInstanceB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_instance);
        ButterKnife.bind(this);
        renderPageA();
        renderPageB();
    }

    @OnClick({R.id.tv_info})
    public void showSecondWeexPage() {
        //点击这个显示第二个weex实例
        int visibility = containerB.getVisibility();
        containerB.setVisibility(visibility == View.VISIBLE ? View.GONE : View.VISIBLE);
    }

    @OnClick(R.id.btn_change_view)
    public void changeView() {
        containerB.setVisibility(View.VISIBLE);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) containerB.getLayoutParams();
        layoutParams.width = layoutParams.width+50;
        layoutParams.height = layoutParams.height+50;
        containerB.setLayoutParams(layoutParams);
        renderPageB();
    }

    private void renderPageA() {
        if (mWXSDKInstanceA==null) {
            mWXSDKInstanceA = new WXSDKInstance(this);
        }
        mWXSDKInstanceA.registerRenderListener(new IWXRenderListener() {
            @Override
            public void onViewCreated(WXSDKInstance instance, View view) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                containerA.addView(view);
            }

            @Override
            public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

            }

            @Override
            public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

            }

            @Override
            public void onException(WXSDKInstance instance, String errCode, String msg) {

            }
        });

        Map<String, Object> options = new HashMap<>();
        options.put(WXSDKInstance.BUNDLE_URL, LOCAL_JS_URL);
        //测试本地网络js
        //mWXSDKInstanceA.renderByUrl("WXSampleA", LOCAL_JS_URL, options, null, WXRenderStrategy.APPEND_ONCE);

        //assets
        String fileName = LOCAL_JS_URL.replace(Constants.LOCAL_FILE_SCHEMA,"");
        mWXSDKInstanceA.render("WXSampleA", WXFileUtils.loadAsset(fileName, this), null, null, WXRenderStrategy.APPEND_ASYNC);
        Log.d("dq","mWXSDKInstanceA id="+mWXSDKInstanceA.getInstanceId()+",url="+mWXSDKInstanceA.getBundleUrl());
    }

    private void renderPageB() {
        if (mWXSDKInstanceB==null) {
            mWXSDKInstanceB = new WXSDKInstance(this);
        }
        mWXSDKInstanceB.registerRenderListener(new IWXRenderListener() {
            @Override
            public void onViewCreated(WXSDKInstance instance, View view) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                containerB.addView(view);
            }

            @Override
            public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

            }

            @Override
            public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

            }

            @Override
            public void onException(WXSDKInstance instance, String errCode, String msg) {

            }
        });
        /**
         * pageName:自定义，一个标示符号。
         * url:远程bundle JS的下载地址
         * options:初始化时传入WEEX的参数，比如 bundle JS地址
         * flag:渲染策略。WXRenderStrategy.APPEND_ASYNC:异步策略先返回外层View，其他View渲染完成后调用onRenderSuccess。WXRenderStrategy.APPEND_ONCE 所有控件渲染完后后一次性返回。
         */
        Map<String, Object> options = new HashMap<>();
        options.put(WXSDKInstance.BUNDLE_URL, TEST_URL);

        //测试本地网络js
        //mWXSDKInstanceB.renderByUrl("WXSampleB", TEST_URL, options, null, WXRenderStrategy.APPEND_ONCE);

        //local assets
        String fileName = TEST_URL.replace(Constants.LOCAL_FILE_SCHEMA,"");
        mWXSDKInstanceB.render("WXSampleB", WXFileUtils.loadAsset(fileName, this), null, null, WXRenderStrategy.APPEND_ASYNC);
        Log.d("dq","mWXSDKInstanceB id="+mWXSDKInstanceB.getInstanceId()+",url="+mWXSDKInstanceB.getBundleUrl());
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (mWXSDKInstanceA != null) {
            mWXSDKInstanceA.onActivityStart();
        }
        if (mWXSDKInstanceB != null) {
            mWXSDKInstanceB.onActivityStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mWXSDKInstanceA != null) {
            mWXSDKInstanceA.onActivityResume();
        }
        if (mWXSDKInstanceB != null) {
            mWXSDKInstanceB.onActivityResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mWXSDKInstanceA != null) {
            mWXSDKInstanceA.onActivityPause();
        }
        if (mWXSDKInstanceB != null) {
            mWXSDKInstanceB.onActivityPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mWXSDKInstanceA != null) {
            mWXSDKInstanceA.onActivityStop();
        }
        if (mWXSDKInstanceB != null) {
            mWXSDKInstanceB.onActivityStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            destoryWeexInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void destoryWeexInstance() {
        if (mWXSDKInstanceA != null) {
            mWXSDKInstanceA.onActivityDestroy();
            mWXSDKInstanceA.destroy();
            mWXSDKInstanceA = null;
        }
        destoryInstanceB();
    }

    private void destoryInstanceB() {
        if (mWXSDKInstanceB != null) {
            mWXSDKInstanceB.onActivityDestroy();
            mWXSDKInstanceB.destroy();
            mWXSDKInstanceB = null;
        }
    }
}
