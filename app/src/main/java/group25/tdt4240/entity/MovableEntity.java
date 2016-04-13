package group25.tdt4240.entity;

import sheep.graphics.Image;
import sheep.math.Vector2;

/**
 * Created by Meneth on 2016-03-31.
 */
public abstract class MovableEntity extends Entity {
    private final float standardVelocity;

    /**
     * @param image The image the sprite is to be generated from
     */
    public MovableEntity(Image image, float standardVelocity) {
        super(image);
        this.standardVelocity = standardVelocity;
    }

    public float getVelocity() {
        float velocity = getSpeed().getLength();
        if (velocity == 0)
            velocity = standardVelocity;
        return velocity;
    }

    public void setTarget(Vector2 target) {
        float speed = getVelocity();
        float dx = getX() - target.getX();
        float dy = getY() - target.getY();

        Vector2 v = getPosition().getSubtracted(target);
        float speedScale = speed / v.getLength();
        v.multiply(speedScale);
        setSpeed(v);
    }
}
