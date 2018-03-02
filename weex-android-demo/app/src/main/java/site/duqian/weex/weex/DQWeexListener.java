package site.duqian.weex.weex;

import com.taobao.weex.WXSDKInstance;

/**
 * Description:weex渲染监听
 *
 * @author 杜乾-Dusan,Created on 2018/3/1 - 12:08.
 *         E-mail:duqian2010@gmail.com
 */
public interface DQWeexListener {
    public void onException(WXSDKInstance instance, String errCode, String msg);
}
