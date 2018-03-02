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
import com.taobao.weex.RenderContainer;
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
    private ViewGroup weexContainerParent;//weex实例最外层父布局

    public WeexInstanceManager(Context context, FrameLayout weexContainerParent) {
        this.context = context;
        this.weexContainerParent = weexContainerParent;
    }

    /*key 为weex页面url地址，value为窗口实例*/
    private Map<String, WXSDKInstance> instanceMap = new HashMap<>();
    private Map<String, ViewGroup> containerMap = new HashMap<>();

    private DQWeexListener listener;

    public void setListener(DQWeexListener listener) {
        this.listener = listener;
    }

    /**
     * 页面发送指令，动态创建weex dialog
     * @param container weex容器
     * @param params WeexDialogParams
     */
    public void generateWeexPage(final ViewGroup container, final WeexDialogParams params) {
        generateWeexPage(container, params.url, params.data, params.md5);
    }

    /**
     * 创建新的weex页面/窗口
     *
     * @param container  父容器
     * @param url        js bundle文件地址
     * @param jsonParams 携带的参数
     */
    public void generateWeexPage(final ViewGroup container, final String url, final String jsonParams, final String jsonInitData) {
        if (container == null || TextUtils.isEmpty(url) || context == null) {
            return;
        }

        removeInstance(url);
        //开始单文件本地缓存功能
        WXSDKInstance mWXSDKInstance = new DQWXSDKInstance(context,true);
        instanceMap.put(url, mWXSDKInstance);
        containerMap.put(url, container);

        boolean isRenderContainer = container instanceof RenderContainer;
        if (isRenderContainer) {
            RenderContainer renderContainer = (RenderContainer) container;
            mWXSDKInstance.setRenderContainer(renderContainer);
            renderContainer.setSDKInstance(mWXSDKInstance);
        }
        //渲染监听
        IWXRenderListener renderListener = getRenderListener(isRenderContainer, container);
        mWXSDKInstance.registerRenderListener(renderListener);

        //添加共参数
        Map<String, Object> options = createOptionsMap(jsonParams);

        mWXSDKInstance.renderByUrl(url, url, options, jsonInitData, WXRenderStrategy.APPEND_ASYNC);
    }

    private IWXRenderListener getRenderListener(final boolean isRenderContainer, final ViewGroup container) {
        return new IWXRenderListener() {
            @Override
            public void onViewCreated(WXSDKInstance instance, View view) {
                if (!isRenderContainer) {
                    container.removeAllViews();
                    container.addView(view);
                }
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
                    handlerRenderException(instance.getBundleUrl());
                }
                if (null != listener) {
                    listener.onException(instance, errCode, msg);
                }
            }

        };
    }

    /**
     * 创建请求的公共参数，map对象
     *
     * @param params 给weex页面传递的公参
     * @return map集合
     */
    @NonNull
    private Map<String, Object> createOptionsMap(String params) {
        Map<String, Object> options = null;
        if (!TextUtils.isEmpty(params)) {
            try {
                options = JSON.parseObject(params);
            } catch (Exception e) {
                e.printStackTrace();
                options=null;
            }
        }
        if (options == null) {
            options = new HashMap<String, Object>();
        }
        options.put("__la", "zh");
        options.put("__sp", "");
        options.put("ch_1", "duqian2010@gmail.com");
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
