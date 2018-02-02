package com.weex.sample.extend.module;

import android.util.Log;
import android.widget.Toast;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;

/**
 * Description:
 *
 * @author 杜乾-Dusan,Created on 2018/2/2 - 12:27.
 *         E-mail:duqian2010@gmail.com
 */
public class MyMoudle extends WXModule {
    //run ui thread
    @JSMethod(uiThread = true)
    public void printLog(String msg) {
        Toast.makeText(mWXSDKInstance.getContext(), msg, Toast.LENGTH_SHORT).show();
        Log.d("dq","msg="+msg);
    }

    //run JS thread
    @JSMethod(uiThread = false)
    public void fireEventSyncCall() {
        //implement your module logic here
    }
}
