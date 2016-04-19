package group25.tdt4240.entity.tower;

import android.view.MotionEvent;

import group25.tdt4240.Constants;
import group25.tdt4240.entity.Clickable;
import group25.tdt4240.entity.Drawable;
import group25.tdt4240.entity.Entity;
import group25.tdt4240.entity.monster.Monster;
import group25.tdt4240.entity.projectile.Projectile;
import group25.tdt4240.state.PlayState;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */

public abstract class Tower extends Entity {
    private final int cost, range;
    private float timePassed = 0;
    private final float cooldown;

    /**
     * @param image The image the sprite is to be generated from
     */
    public Tower(Image image, float cooldown, int cost, int range) {
        super(image);
        this.cooldown = cooldown;
        this.cost = cost;
        this.range = range;
        float scaleX = 0.9f * (float) Constants.TILE_WIDTH / image.getWidth();
        float scaleY = 0.9f * (float) Constants.TILE_HEIGHT / image.getHeight();
        setScale(scaleX, scaleY);
    }

    public float getRange() {
        return range * Constants.SCALE;
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

    public abstract Tower upgrade();

    public void fire(Monster target) {
        if (target == null)
            return;
        Projectile p = getNewProjectile(target);
        p.setPosition(getX(), getY()); // Set getX/Y as that copies rather than references
        getContainer().addEntity(p);
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        timePassed += dt;
        if (timePassed > cooldown) {
            timePassed -= cooldown;
            fire(findTarget());
        }
    }

    private Monster findTarget() {
        for (Monster monster : getContainer().getMonsters()){
            if (getDistance(monster) < getRange())
                return monster;
        }
        return null; // No target found
    }

    protected abstract Projectile getNewProjectile(Monster target);


    public int getPriority() {
        return 10; // TODO - Placeholder
    }
}
