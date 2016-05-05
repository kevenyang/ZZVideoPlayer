package org.lynxz.zzvideoview.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

/**
 * Created by zxz on 2016/5/4.
 * 屏幕方向
 */
public class OrientationUtil {
    public static final int HORIZONTAL = 0x00;
    public static final int VERTICAL = 0x01;

    /**
     * 获取屏幕方向
     *
     * @param cxt
     * @return {@link #HORIZONTAL}  {@link #HORIZONTAL}
     */
    public static int getOrientation(Context cxt) {
        int orientation = VERTICAL;
        if (cxt.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            orientation = HORIZONTAL;
        }
        return orientation;
    }

    /***
     * 指定屏幕方向
     * P.S. 这样强制指定后,旋转手机时屏幕不会旋转...
     *
     * @param act
     * @param targetOrientation {@link #HORIZONTAL} {@link #VERTICAL}
     */
    public static void forceOrientation(Activity act, int targetOrientation) {
        int oriOrientation = act.getRequestedOrientation();
        if (targetOrientation == HORIZONTAL) {//竖屏 -> 横屏
            if (oriOrientation == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                    || oriOrientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
                act.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        } else {//横屏 -> 竖屏
            if (oriOrientation == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                    || oriOrientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                act.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        }
    }
}