package site.duqian.weex.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

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


    /**
     * 获取字节数组的MD5值
     *
     * @param arrays 字节数组
     */
    public static String getMd5(byte[] arrays) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(arrays);
            return bytesToHex(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取字符串的MD5值
     *
     * @param src 要获取的字符串
     */
    public static String getMd5(String src) {
        if (src != null) {
            return getMd5(src.getBytes());
        }
        return "";
    }

    /**
     * 获取文件的MD5值
     *
     * @param file 要获取的文件
     */
    public static String getMd5(File file) {
        String s = null;
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            FileChannel ch = in.getChannel();
            MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY,
                    0, file.length());

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(byteBuffer);
            s = bytesToHex(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return s;
    }

    /**
     * 将byte数组转换为16进制
     *
     * @param bytes
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }


    /**
     * 写入文件,如果文件已经存在,则覆盖之.
     *
     * @param path 文件保存路径
     * @param data 文件保存的数据
     * @return 是否写入成功
     */
    public static boolean writeData(String path, byte[] data) {
        return writeData(path, data, false);
    }

    public static boolean writeData(String path, byte[] data, boolean append) {
        try {
            File file = new File(path);
            makeParentDir(file);
            FileOutputStream fos = new FileOutputStream(file, append);
            fos.write(data);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static void makeParentDir(File file) {
        if (file == null || file.exists()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }


}
