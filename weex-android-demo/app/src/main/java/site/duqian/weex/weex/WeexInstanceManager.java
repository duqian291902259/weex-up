package site.duqian.weex.weex;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:Weex 窗体实例管理
 *
 * @author 杜乾-Dusan,Created on 2018/2/26 - 20:29.
 *         E-mail:duqian2010@gmail.com
 */
public class WeexInstanceManager {

    private Context context;

    public WeexInstanceManager(Context context) {
        this.context = context;
    }

    /*key 为weex页面url地址，value为窗口实例*/
    private Map<String, WXSDKInstance> instanceMap = new HashMap<>();

    public WXSDKInstance generateWeexPage(final ViewGroup container, final String url, String data) {
        /*WXSDKInstance mWXSDKInstance = instanceMap.get(url);
        if (mWXSDKInstance == null) {
            mWXSDKInstance = new WXSDKInstance(context);
            instanceMap.put(url, mWXSDKInstance);
        }*/
        removeInstance(url);
        WXSDKInstance mWXSDKInstance = new WXSDKInstance(context);
        instanceMap.put(url, mWXSDKInstance);

        mWXSDKInstance.registerRenderListener(new IWXRenderListener() {
            @Override
            public void onViewCreated(WXSDKInstance instance, View view) {
                container.removeView(view);
                container.addView(view);
            }

            @Override
            public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

            }

            @Override
            public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

            }

            @Override
            public void onException(WXSDKInstance instance, String errCode, String msg) {
                instanceMap.remove(url);
                Log.e("generateWeexPage", "dq exception:" + errCode + ",msg=" + msg);
                String text = url + " render error " + msg;
                TextView textView = new TextView(context);
                textView.setText(text);
                Toast.makeText(context, text, Toast.LENGTH_LONG).show();
                container.removeAllViews();
                container.addView(textView);
            }
        });
        //添加共参数
        Map<String, Object> options = null;
        if (!TextUtils.isEmpty(data)) {
            options = JSON.parseObject(data);
        }

        if (options == null) {
            options = new HashMap<String, Object>();
        }
        options.put("__la", "cn");
        options.put("ch_1", "duqian");

        mWXSDKInstance.renderByUrl(url, url, options, null, WXRenderStrategy.APPEND_ASYNC);
        return mWXSDKInstance;
    }

    public Map<String, WXSDKInstance> getInstanceMap() {
        return instanceMap;
    }

    public void removeInstance(String url) {
        WXSDKInstance wxsdkInstance = instanceMap.get(url);
        if (wxsdkInstance != null) {
            wxsdkInstance.destroy();
            instanceMap.remove(url);
        }
    }

    public void onResume() {
        for (WXSDKInstance mWXSDKInstance : instanceMap.values()) {
            if (mWXSDKInstance != null) {
                mWXSDKInstance.onActivityResume();
            }
        }
    }

    public void onPause() {
        for (WXSDKInstance mWXSDKInstance : instanceMap.values()) {
            if (mWXSDKInstance != null) {
                mWXSDKInstance.onActivityPause();
            }
        }
    }

    public void onStop() {
        for (WXSDKInstance mWXSDKInstance : instanceMap.values()) {
            if (mWXSDKInstance != null) {
                mWXSDKInstance.onActivityStop();
            }
        }
    }

    public void onDestroy() {
        try {
            destoryWeex();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void destoryWeex() {
        for (WXSDKInstance mWXSDKInstance : instanceMap.values()) {
            if (mWXSDKInstance != null) {
                mWXSDKInstance.onActivityDestroy();
                mWXSDKInstance.destroy();
            }
        }
        instanceMap.clear();
    }
}
