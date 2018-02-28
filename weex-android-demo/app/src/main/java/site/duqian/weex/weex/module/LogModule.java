package site.duqian.weex.weex.module;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import java.util.HashMap;
import java.util.Map;

import site.duqian.weex.BuildConfig;

/**
 * Description:用于Weex输出日志到工作台
 *
 * @author 杜乾-Dusan,Created on 2018/2/24 - 16:17.
 *         E-mail:duqian2010@gmail.com
 */
public class LogModule extends WXModule {

    /**
     * 是否开启日志：1开启；0关闭
     */
    @JSMethod(uiThread = true)
    public void isLogEnable(JSCallback callback) {
        if (callback == null) {
            return;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("logEnable", String.valueOf(BuildConfig.DEBUG ? "1" : "0"));
        String json = JSON.toJSONString(map);
        callback.invoke(json);
    }

    /**
     * 输出日志到控制台
     *
     * @param tag
     * @param msg
     */
    @JSMethod(uiThread = true)
    public void log(String tag, String msg) {
        Log.d(tag, msg);
    }

    /**
     * 输出日志到控制台
     *
     * @param msg
     */
    @JSMethod(uiThread = true)
    public void log(String msg) {
        Log.d("weex-log", msg);
    }

}
