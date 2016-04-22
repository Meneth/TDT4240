package group25.tdt4240.entity.monster;

import group25.tdt4240.R;
import group25.tdt4240.map.Path;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-04-13.
 */
public class Monster1 extends Monster {
    private static final float standardVelocity = 75;
    public static final Image image = new Image(R.drawable.micon1);

    /**
     * @param path The path the monster is to walk
     */
    public Monster1(Path path) {
        super(image, path, standardVelocity, 25, 100);
    }
}
