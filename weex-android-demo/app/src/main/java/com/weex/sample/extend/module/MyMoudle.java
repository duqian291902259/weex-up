package com.weex.sample.extend.module;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.weex.sample.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author 杜乾-Dusan,Created on 2018/2/2 - 12:27.
 *         E-mail:duqian2010@gmail.com
 */
public class MyMoudle extends WXModule {

    //run ui thread
    @JSMethod(uiThread = true)
    public void sendMessage(String msg) {
        toastMsg(msg);
        Log.d("dq", "getMessage msg=" + msg);
    }

    @JSMethod(uiThread = true)
    public void fireNativeGlobalEvent(String event, JSCallback callback) {
        Toast.makeText(mWXSDKInstance.getContext(), "Native called!"+event + ",id=" + mWXSDKInstance.getInstanceId(), Toast.LENGTH_SHORT).show();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("data", "value-杜乾");
        mWXSDKInstance.fireGlobalEventCallback(event, params);
        if (null != callback) {
            Map<String, String> result = new HashMap<String, String>();
            result.put("result", "callback ok");
            callback.invoke(result);
        }
    }

    @JSMethod(uiThread = true)
    public void openPageByUrl(String url) {
        Log.d("dq", "page url =" + url);
        Context context = mWXSDKInstance.getContext();
        Intent intent = new Intent();
        intent.setAction(Constants.BC_ACTION_RENDER_NET_JS);
        intent.putExtra("url", url);
        context.sendBroadcast(intent);

        /*if (!TextUtils.isEmpty(url)) {//这里无法渲染？
            String pageName = mWXSDKInstance.getBundleUrl();
            mWXSDKInstance.renderByUrl(pageName, url, null, null, WXRenderStrategy.APPEND_ONCE);
        }*/
    }

    //run ui thread
    @JSMethod(uiThread = true)
    public void printLog(String msg) {
        toastMsg(msg);
    }

    private void toastMsg(String msg) {
        String instanceId = mWXSDKInstance.getInstanceId();
        Toast.makeText(mWXSDKInstance.getContext(), msg + ",id=" + instanceId, Toast.LENGTH_SHORT).show();
        Log.d("dq", "printLog msg=" + msg + ",id=" + instanceId + ",url=" + mWXSDKInstance.getBundleUrl());
    }

    //run JS thread
    @JSMethod(uiThread = false)
    public void fireEventSyncCall() {

    }
}
