package group25.tdt4240.entity.projectile;

import group25.tdt4240.entity.MovableEntity;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public abstract class Projectile extends MovableEntity {

    /**
     * @param image The image the sprite is to be generated from
     */
    public Projectile(Image image) {
        super(image);
    }
}
