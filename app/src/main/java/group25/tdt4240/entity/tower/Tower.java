package group25.tdt4240.entity.tower;

import android.view.MotionEvent;

import group25.tdt4240.Constants;
import group25.tdt4240.entity.Clickable;
import group25.tdt4240.entity.Entity;
import group25.tdt4240.entity.projectile.Projectile;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */

public abstract class Tower extends Entity implements Clickable {
    private final Projectile projectile;
    private final int cooldown, cost;

    /**
     * @param image The image the sprite is to be generated from
     */
    public Tower(Image image, Projectile projectile, int cooldown, int cost) {
        super(image);
        this.projectile = projectile;
        this.cooldown = cooldown;
        this.cost = cost;
        float scaleX = 0.9f * (float) Constants.TILE_WIDTH / image.getWidth();
        float scaleY = 0.9f * (float) Constants.TILE_HEIGHT / image.getHeight();
        setScale(scaleX, scaleY);
        setOffset(0.9f * Constants.TILE_WIDTH / 2, 0.9f * Constants.TILE_HEIGHT / 2);
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

    public int getCost() {
        return cost;
    }

    public abstract int getNextUpgradeCost();

    public abstract Priority getTargetPriority();

    public abstract void upgrade();

    public void Fire() {
        // TODO
    }


    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (this.getBoundingBox().contains(event.getX(), event.getY())) {
            // TODO
            return true;
        } else return false;
    }

    public int getPriority() {
        return 10; // TODO - Placeholder
    }
}
