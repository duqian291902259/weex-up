package com.weex.sample.extend.module;

import android.os.Build;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lixinke on 2017/3/3.
 */

public class PhoneInfoModule extends WXModule {

  @JSMethod(uiThread = false)
  public void getPhoneInfo(JSCallback callback) {
    Map<String, String> infos = new HashMap<>();
    infos.put("board", Build.BOARD);
    infos.put("brand", Build.BRAND);
    infos.put("device", Build.DEVICE);
    infos.put("model", Build.MODEL);
    callback.invoke(infos);
  }
}
