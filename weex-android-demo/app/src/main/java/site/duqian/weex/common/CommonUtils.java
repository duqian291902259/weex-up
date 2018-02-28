package site.duqian.weex.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Description:工具类
 *
 * @author 杜乾-Dusan,Created on 2018/2/28 - 15:45.
 *         E-mail:duqian2010@gmail.com
 */
public class CommonUtils {

    /**
     * 网络是否可用
     *
     * @param context 上下文
     * @return
     */
    public static boolean isNetworkConected(Context context) {
        if (context != null) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return (netInfo != null && netInfo.isAvailable());
        }
        return false;
    }


    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高(包括底部虚拟按键)
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (wm == null) {
            return 0;
        }
        Display display = wm.getDefaultDisplay();
        int screenHeight = 0;
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                display.getRealMetrics(displayMetrics);
            } else {
                display.getMetrics(displayMetrics);
            }
            screenHeight = displayMetrics.heightPixels;
        } catch (Exception e) {
            screenHeight = display.getHeight();
        }
        return screenHeight;
    }

}
