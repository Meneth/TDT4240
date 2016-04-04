package group25.tdt4240.entity;

import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public abstract class MovableEntity extends Entity {
    /**
     *
     * @param image The image the sprite is to be generated from
     */
    public MovableEntity(Image image) {
        super(image);
    }
}
