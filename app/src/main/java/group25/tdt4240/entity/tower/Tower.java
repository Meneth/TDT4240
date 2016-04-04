package group25.tdt4240.entity.tower;

import android.view.MotionEvent;

import group25.tdt4240.entity.Clickable;
import group25.tdt4240.entity.Entity;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */

public abstract class Tower extends Entity implements Clickable {
    /**
     *
     * @param image The image the sprite is to be generated from
     */
    public Tower(Image image) {
        super(image);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        // TODO
        return false;
    }
}
