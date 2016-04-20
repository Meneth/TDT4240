package group25.tdt4240.utility;

import android.content.res.Resources;

/**
 * Created by Ole on 04/04/2016.
 */
public class Constants {

    public static final float SCREEN_WIDTH = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static final float SCREEN_HEIGHT = Resources.getSystem().getDisplayMetrics().heightPixels;
    public static final float SCALE = SCREEN_WIDTH / 1080f; // What absolute distances should be scaled with

    public static float TILE_HEIGHT = SCREEN_WIDTH/10;
    public static float TILE_WIDTH = SCREEN_WIDTH/10;
}
