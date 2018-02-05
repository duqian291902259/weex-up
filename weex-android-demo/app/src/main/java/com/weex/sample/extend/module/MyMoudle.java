package com.weex.sample.extend.module;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;
import com.weex.sample.Constants;

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
        Toast.makeText(mWXSDKInstance.getContext(), "native recevied " + msg, Toast.LENGTH_SHORT).show();
        Log.d("dq", "msg=" + msg);
    }

    @JSMethod(uiThread = true)
    public void openPageByUrl(String url) {
        Log.d("dq", "page url =" + url);
        Context context = mWXSDKInstance.getContext();
        Intent intent = new Intent();
        intent.setAction(Constants.BC_ACTION_RENDER_NET_JS);
        intent.putExtra("url", url);
        context.sendBroadcast(intent);
        //Toast.makeText(mWXSDKInstance.getContext(), "native send broadcast " + url, Toast.LENGTH_SHORT).show();
        mWXSDKInstance.render(url);
    }

    //run ui thread
    @JSMethod(uiThread = true)
    public void printLog(String msg) {
        Toast.makeText(mWXSDKInstance.getContext(), msg, Toast.LENGTH_SHORT).show();
        Log.d("dq", "msg=" + msg);
    }

    //run JS thread
    @JSMethod(uiThread = false)
    public void fireEventSyncCall() {
        //implement your module logic here
    }
}
