package group25.tdt4240.entity;

import android.view.MotionEvent;

import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public class Button extends Entity implements Clickable {
    public Button(Image image) {
        super(image);
    }

    /**
     * @param canvas Current canvas
     * @Override public void draw(Canvas canvas) {
     * // TODO - Write draw
     * }
     */

    @Override
    public boolean onTouchDown(MotionEvent event) {
        // TODO
        return false;
    }
}
