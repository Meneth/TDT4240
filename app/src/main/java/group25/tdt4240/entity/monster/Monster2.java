package group25.tdt4240.entity.monster;

import group25.tdt4240.R;
import group25.tdt4240.entity.MovableEntity;
import group25.tdt4240.map.Path;
import sheep.graphics.Image;

/**
 * Created by rh183_000 on 20/04/2016.
 */
public class Monster2 extends Monster {

private static final float standardVelocity = 25;
private static final Image image = new Image(R.drawable.monster2);

    /**
     * @param path The path the monster is to walk
     */
    public Monster2(Path path) {
        super(image, path, standardVelocity, 50, 150);
    }
}
