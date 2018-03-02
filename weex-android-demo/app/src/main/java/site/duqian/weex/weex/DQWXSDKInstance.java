package site.duqian.weex.weex;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;

import java.io.File;
import java.util.Map;

import site.duqian.weex.common.CommonUtils;
import site.duqian.weex.common.ThreadManager;

/**
 * Description:自定义带有本地缓存功能的WXSDKInstance
 *
 * @author 杜乾-Dusan,Created on 2018/3/2 - 10:07.
 *         E-mail:duqian2010@gmail.com
 */
public class DQWXSDKInstance extends WXSDKInstance {
    private boolean isEnableJSCache = true;//是否开启单js文件本地缓存功能

    public void setEnableJSCache(boolean isEnableJSCache) {
        this.isEnableJSCache = isEnableJSCache;
    }

    public DQWXSDKInstance(Context context) {
        super(context);
    }

    public DQWXSDKInstance(Context context, boolean isEnableJSCache) {
        super(context);
        this.isEnableJSCache = isEnableJSCache;
    }

    @Override
    public void render(String pageName, String template, Map<String, Object> options, String jsonInitData, WXRenderStrategy flag) {
        if (isEnableJSCache) {
            //开启了缓存功能，则异步缓存JS
            saveWeexFile(template);
        }
        super.render(pageName, template, options, jsonInitData, flag);
    }

    @Override
    public void renderByUrl(String pageName, String url, Map<String, Object> options, String jsonInitData, WXRenderStrategy flag) {
        //没有开启缓存则直接渲染
        if (!isEnableJSCache) {
            super.renderByUrl(pageName, url, options, jsonInitData, flag);//net
            return;
        }

        //获取本地JS bundle的路径,命中缓存则渲染本地，否则直接渲染服务端js;
        String local = getLocalJsBundle(url, jsonInitData);
        if (!TextUtils.isEmpty(local)) {
            local = "file://" + local;
            super.renderByUrl(pageName, local, options, jsonInitData, flag);//local
        } else {
            super.renderByUrl(pageName, url, options, jsonInitData, flag);//net
        }
    }

    /**
     * 获取本地js，和服务端对比md5
     *
     * @param url
     * @param jsonInitData 没有传则返回空，直接渲染网络js
     * @return
     */
    private String getLocalJsBundle(String url, String jsonInitData) {
        String path = getSavedPathByBundleUrl(url);
        File jsFile = new File(path);
        String md5 = CommonUtils.getMd5(jsFile);
        Log.d("dq weex", "local js md5=" + md5);
        String netMd5 = jsonInitData;
        if (!TextUtils.isEmpty(md5) && md5.equals(netMd5)) {
            return path;
        }
        return null;
    }

    /**
     * 缓存js文件
     *
     * @param template
     */
    private void saveWeexFile(final String template) {
        final String url = getBundleUrl();
        if (isLocalFile(url) || TextUtils.isEmpty(template)) {//本身是本地js,或者为空则不缓存
            return;
        }
        ThreadManager.getBackgroundPool().execute(new Runnable() {
            @Override
            public void run() {
                String path = getSavedPathByBundleUrl(url);
                try {
                    byte[] bytes = template.getBytes("UTF-8");
                    CommonUtils.writeData(path, bytes);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 获取js存储路径，安全起见放在似有目录
     *
     * @param url js服务端地址
     * @return
     */
    private String getSavedPathByBundleUrl(String url) {
        String path = null;
        try {
            String fileName = CommonUtils.getMd5(url);
            Context context = getContext();
            if (context == null) return null;
            File filesDir = context.getFilesDir();
            if (filesDir == null) return null;
            String rootDir = filesDir.getAbsolutePath() + File.separator + "weex" + File.separator;
            path = rootDir + fileName + ".js";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 判断是本地文件还是网络url
     */
    private boolean isLocalFile(String url) {
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        Uri uri = Uri.parse(url);
        if (uri != null && TextUtils.equals(uri.getScheme(), "file")) {
            return true;
        }
        return false;
    }
}
