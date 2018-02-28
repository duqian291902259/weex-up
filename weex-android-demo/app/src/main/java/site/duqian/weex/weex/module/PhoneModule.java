package site.duqian.weex.weex.module;

import android.os.Build;

import com.alibaba.fastjson.JSON;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import site.duqian.weex.common.CommonUtils;

/**
 * Description:通用module，获取系统信息，设备，网络，app信息等
 *
 * @author 杜乾-Dusan,Created on 2018/2/24 - 16:39.
 *         E-mail:duqian2010@gmail.com
 */
public class PhoneModule extends WXModule {

    @JSMethod(uiThread = false)
    public void getPhoneInfo(JSCallback callback) {
        Map<String, String> infos = new HashMap<>();
        infos.put("board", Build.BOARD);
        infos.put("brand", Build.BRAND);
        infos.put("device", Build.DEVICE);
        infos.put("model", Build.MODEL);
        String json = JSON.toJSONString(infos);
        callback.invoke(json);
    }

    /**
     * 获取当前系统语言 // 系统语言,如"id", "zh", "tr"
     *
     * @param callback
     */
    @JSMethod(uiThread = true)
    public void getLanguage(JSCallback callback) {
        if (callback == null) {
            return;
        }

        String language = "cn";
        try {
            language = Locale.getDefault().getLanguage();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("language", language);
        callback.invoke(map);
    }

    /**
     * 获取当前网络是否连接 // 1连接；0未连接
     *
     * @param callback
     */
    @JSMethod(uiThread = true)
    public void isNetworkConnected(JSCallback callback) {
        if (callback == null) {
            return;
        }
        boolean isConnected = CommonUtils.isNetworkConected(mWXSDKInstance.getContext());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isConnected", String.valueOf(isConnected ? "1" : "0"));
        String json = JSON.toJSONString(map);
        callback.invoke(json);
    }

}
