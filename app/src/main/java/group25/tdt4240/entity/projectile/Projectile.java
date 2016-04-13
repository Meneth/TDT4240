package group25.tdt4240.entity.projectile;

import group25.tdt4240.entity.MovableEntity;
import group25.tdt4240.entity.tower.Tower;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public abstract class Projectile extends MovableEntity {

    /**
     * @param image The image the sprite is to be generated from
     * @param tower The tower which fired the projectile
     */
    public Projectile(Image image, Tower tower) {
        super(image, 0); // TODO - Velocity is placeholder
        setOrigin(tower);
    }

    public abstract void setOrigin(Tower t);
    public abstract Tower getOrigin();



}
