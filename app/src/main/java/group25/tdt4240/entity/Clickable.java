package group25.tdt4240.entity;

import android.view.MotionEvent;

/**
 * Created by Meneth on 2016-04-04.
 */
public interface Clickable extends Drawable {
    boolean onTouchDown(MotionEvent event);


}
