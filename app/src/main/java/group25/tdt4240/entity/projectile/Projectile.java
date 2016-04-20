package group25.tdt4240.entity.projectile;

import group25.tdt4240.utility.Constants;
import group25.tdt4240.entity.MovableEntity;
import group25.tdt4240.entity.monster.Monster;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public abstract class Projectile extends MovableEntity {
    private final Monster target;
    private final int damage;

    /**
     * @param image  The image the sprite is to be generated from
     * @param target The monster the projectile is targeting
     */
    public Projectile(Image image, Monster target, int damage, float velocity) {
        super(image, velocity); // TODO - Velocity is placeholder
        this.target = target;
        this.damage = damage;

        float scaleX = 0.5f * Constants.TILE_WIDTH / image.getWidth();
        float scaleY = 0.5f * Constants.TILE_HEIGHT / image.getHeight();
        setScale(scaleX, scaleY);
        update(0);
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        if (target == null)
            die();
        else if (target.isDestroyed()) {
            if (this.getSpeed().getX() == 0 && this.getSpeed().getY() == 0)
                die();
            if (this.getX() > Constants.SCREEN_WIDTH || this.getX() < 0) {
                die();
            }
            if (this.getY() > Constants.SCREEN_HEIGHT || this.getY() < 0) {
                die();
            }
        } else if (target.collides(this)) {
            target.takeDamage(damage);
            die(); // Destroy the projectile
        } else {
            setTarget(target.getPosition());
        }
    }

    public int getPriority() {
        return 5; // TODO - placeholder
    }
}
