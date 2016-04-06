package group25.tdt4240.entity.monster;

import group25.tdt4240.entity.MovableEntity;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public abstract class Monster extends MovableEntity {

    /**
     * @param image The image the sprite is to be generated from
     */
    public Monster(Image image) {
        super(image);
    }
}
