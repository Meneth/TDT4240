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
     * @param image The image the sprite is to be generated from
     */
    public Tower(Image image) {
        super(image);
    }


    public enum Priority {
        CLOSEST,
        FURTHEST,
        FIRST,
        LAST,
        HIGHEST_HP,
        LOWEST_HP,
        STRONGEST,
        WEAKEST
    }

    public abstract int getCost();

    public abstract int getNextUpgradeCost();


    public abstract Priority getTargetPriority();

    public abstract void upgrade();

    //Time between each shot
    public abstract float getCooldown();

    public abstract float setCooldown(float c);

    public abstract float getDamage();

    public abstract float setDamage(float d);


    public abstract void Fire();


    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (this.getBoundingBox().contains(event.getX(), event.getY())) {
            // TODO
            return true;
        } else return false;
    }
}
