package site.duqian.weex.weex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

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
    private ViewGroup weexContainerParent;

    public WeexInstanceManager(Context context, FrameLayout weexContainer) {
        this.context = context;
        this.weexContainerParent = weexContainer;
    }

    /*key 为weex页面url地址，value为窗口实例*/
    private Map<String, WXSDKInstance> instanceMap = new HashMap<>();
    private Map<String, ViewGroup> containerMap = new HashMap<>();

    /**
     * 创建新的weex页面/窗口
     *
     * @param container 父容器
     * @param params    传递的参数
     * @return
     */
    public void generateWeexPage(final ViewGroup container, final WeexDialogParams params) {
        if (container == null || params == null || context == null) {
            return;
        }
        final String url = params.url;
        if (TextUtils.isEmpty(url)) {
            return;
        }
        removeInstance(url);
        WXSDKInstance mWXSDKInstance = new WXSDKInstance(context);
        instanceMap.put(url, mWXSDKInstance);
        containerMap.put(url, container);

        mWXSDKInstance.registerRenderListener(new IWXRenderListener() {
            @Override
            public void onViewCreated(WXSDKInstance instance, View view) {
                container.removeAllViews();
                container.addView(view);
            }

            @Override
            public void onRenderSuccess(WXSDKInstance instance, int width, int height) {
                Log.d("dq generateWeexPage", "onRenderSuccess,w=" + width + ",h=" + height);
            }

            @Override
            public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {
                Log.d("dq generateWeexPage", "onRefreshSuccess,w=" + width + ",h=" + height);
            }

            @Override
            public void onException(WXSDKInstance instance, String errCode, String msg) {
                Log.d("dq generateWeexPage", "exception:" + errCode + ",msg=" + msg);
                if (("wx_network_error").equals(errCode)) {//网络错误
                    handlerRenderException(url);
                }
               
            }
        });
        //添加共参数
        Map<String, Object> options = createOptionsMap(params);

        mWXSDKInstance.renderByUrl(url, url, options, null, WXRenderStrategy.APPEND_ASYNC);
    }

    @NonNull
    private Map<String, Object> createOptionsMap(WeexDialogParams params) {
        Map<String, Object> options = null;
        if (!TextUtils.isEmpty(params.data)) {
            options = JSON.parseObject(params.data);
        }

        if (options == null) {
            options = new HashMap<String, Object>();
        }
        options.put("__la", "zh");
        options.put("__sp", "");
        options.put("ch_1", "duqian");
        return options;
    }

    private void handlerRenderException(String url) {
        removeInstance(url);
        removeContainer(url);
    }

    public Map<String, ViewGroup> getContainerMap() {
        return containerMap;
    }

    public void removeInstance(String url) {
        WXSDKInstance mWXSDKInstance = instanceMap.get(url);
        if (mWXSDKInstance != null) {
            mWXSDKInstance.destroy();
            instanceMap.remove(url);
        }
    }

    public void removeContainer(String url) {
        ViewGroup viewGroup = containerMap.get(url);
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            containerMap.remove(url);
        }
        removeFromParent(viewGroup);
    }

    private void removeFromParent(ViewGroup viewGroup) {
        if (weexContainerParent != null && viewGroup != null) {
            weexContainerParent.removeView(viewGroup);
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
        containerMap.clear();
    }
}
