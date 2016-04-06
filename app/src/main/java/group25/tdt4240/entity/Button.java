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

    @Override
    public boolean onTouchDown(MotionEvent event) {
        // TODO
        return false;
    }
}
