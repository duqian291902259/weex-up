package site.duqian.weex.weex.module;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;

import org.json.JSONObject;

import java.io.Serializable;

import site.duqian.weex.weex.Constants;
import site.duqian.weex.weex.WeexDialogParams;

/**
 * Description:打开新的weex窗口，和调整weex窗口的大小位置
 *
 * @author 杜乾-Dusan,Created on 2018/2/26 - 17:45.
 *         E-mail:duqian2010@gmail.com
 */
public class WeexDialogModule extends WXModule {
    /**
     * 打开Weex窗口
     *
     * @param params 参数
     */
    @JSMethod(uiThread = true)
    public void newWeexDialog(String params) {
        if (TextUtils.isEmpty(params)) {
            return;
        }
        try {
            JSONObject jsonObject = new JSONObject(params);
            String url = jsonObject.optString("url");
            String data = jsonObject.optString("data");
            double x = jsonObject.optDouble("x");
            double y = jsonObject.optDouble("y");
            double width = jsonObject.optDouble("width");
            double height = jsonObject.optDouble("height");
            int uiLevel = jsonObject.optInt("uiLevel");
            WeexDialogParams dialogParams = new WeexDialogParams(url, data, x, y, width, height, uiLevel);

            sendBroadcast2Delegate((Serializable) dialogParams, Constants.CMD_WEEX_NEW_DIALOG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 重置Weex窗口
     * //"{\"data\":\"\",\"height\":0.4,\"show\":1,\"uiLevel\":1,\"url\":\"http://192.168.0.112:8081/dist/index.js\",\"width\":0.4,\"x\":0.1,\"y\":0.1}"
     *
     * @param params 参数
     */
    @JSMethod(uiThread = true)
    public void resize(String params) {
        if (TextUtils.isEmpty(params)) {
            return;
        }
        try {
            JSONObject jsonObject = new JSONObject(params);
            double x = jsonObject.optDouble("x");
            double y = jsonObject.optDouble("y");
            double width = jsonObject.optDouble("width");
            double height = jsonObject.optDouble("height");
            String url = jsonObject.optString("url");
            if (TextUtils.isEmpty(url)) {
                url = mWXSDKInstance.getBundleUrl();
            }
            WeexDialogParams dialogParams = new WeexDialogParams(url, x, y, width, height);

            sendBroadcast2Delegate(dialogParams, Constants.CMD_WEEX_RESIZE_DIALOG);
            Log.d("dq", "send resize bc " + params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendBroadcast2Delegate(Serializable dialogParams, String cmdWeexResizeDialog) {
        Context context = mWXSDKInstance.getContext();
        if (context != null) {
            Intent intent = new Intent();
            intent.setAction(Constants.BC_ACTION_WEEX_DIALOG);
            intent.putExtra(Constants.KEY_CMD, cmdWeexResizeDialog);
            intent.putExtra(Constants.KEY_PARAM, dialogParams);
            context.sendBroadcast(intent);
        }
    }

    /**
     * 关闭Weex窗口
     */
    @JSMethod(uiThread = true)
    public void close() {
        Toast.makeText(mWXSDKInstance.getContext(),"close dialog ",Toast.LENGTH_LONG).show();
        String url = mWXSDKInstance.getBundleUrl();
        WeexDialogParams params = new WeexDialogParams(url);
        sendBroadcast2Delegate(params, Constants.CMD_WEEX_CLOSE_DIALOG);
    }

    /**
     * 显示Weex窗口
     */
    @JSMethod(uiThread = true)
    public void show() {
        Toast.makeText(mWXSDKInstance.getContext(),"show dialog ",Toast.LENGTH_LONG).show();
        String url = mWXSDKInstance.getBundleUrl();
        WeexDialogParams params = new WeexDialogParams(url);
        sendBroadcast2Delegate(params, Constants.CMD_WEEX_SHOW_DIALOG);
    }

    /**
     * 隐藏Weex窗口
     */
    @JSMethod(uiThread = true)
    public void hide() {
        Toast.makeText(mWXSDKInstance.getContext(),"hide dialog ",Toast.LENGTH_LONG).show();

        String url = mWXSDKInstance.getBundleUrl();
        WeexDialogParams params = new WeexDialogParams(url);
        sendBroadcast2Delegate(params, Constants.CMD_WEEX_HIDE_DIALOG);
    }

}
