package site.duqian.weex.weex;

import java.io.Serializable;

/**
 * Description:weex 窗体参数集
 * "x":0.1,     // 左上角x坐标，屏幕百分比
 * "y":0.1,     // 左上角y坐标，屏幕百分比
 * "w":0.8,     // 宽，屏幕百分比
 * "h":0.8,     // 高，屏幕百分比
 * "show":1     // 是否显示：1显示；0隐藏
 *  uiLevel	    // 显示的层级
 *
 * @author 杜乾-Dusan,Created on 2018/2/27 - 10:36.
 *         E-mail:duqian2010@gmail.com
 */
public class WeexDialogParams implements Serializable {
    public String url;//js页面地址
    public String data;//json
    public double x;
    public double y;
    public double width;
    public double height;
    public int uiLevel;
    public int show;

    public WeexDialogParams(String url, double x, double y, double width, double height) {
        this.url = url;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public WeexDialogParams(String url, String data, double x, double y, double width, double height, int uiLevel) {
        this.url = url;
        this.data = data;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.uiLevel = uiLevel;
        this.show = 1;
    }

    public WeexDialogParams(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "WeexDialogParams{" +
                "url='" + url + '\'' +
                ", data='" + data + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", uiLevel=" + uiLevel +
                ", show=" + show +
                '}';
    }
}
