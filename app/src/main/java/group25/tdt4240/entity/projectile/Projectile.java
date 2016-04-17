package group25.tdt4240.entity.projectile;

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
     * @param image The image the sprite is to be generated from
     * @param target The monster the projectile is targeting
     */
    public Projectile(Image image, Monster target, int damage) {
        super(image, 0); // TODO - Velocity is placeholder
       this.target = target;
        this.damage = damage;
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        if (target.collides(this)) {
            target.takeDamage(damage);
            die(); // Destroy the projectile
        }
        setTarget(target.getPosition());
    }
}
