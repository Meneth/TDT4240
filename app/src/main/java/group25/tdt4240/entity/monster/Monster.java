package group25.tdt4240.entity.monster;

import group25.tdt4240.Path;
import group25.tdt4240.entity.MovableEntity;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public abstract class Monster extends MovableEntity {
    private final Path path;
    private int position;

    @Override
    public void update(float dt) {
        if (!path.get(position).collides(this))
            position++;
        if (position == path.size()) {
            // TODO - Do damage
        } else {
            setTarget(path.get(position + 1).getPosition());
        }
    }

    /**
     * @param image The image the sprite is to be generated from
     */
    public Monster(Image image, Path path) {
        super(image);
        this.path = path;
        position = 0;
    }
}
