package group25.tdt4240.entity.monster;

import group25.tdt4240.R;
import group25.tdt4240.map.Path;
import sheep.graphics.Image;

/**
 * Created by rh183_000 on 20/04/2016.
 */
public class Monster4 extends Monster {
    private static final float standardVelocity = 40;
    public static final Image image = new Image(R.drawable.micon4);

    /**
     * @param path The path the monster is to walk
     */
    public Monster4(Path path) {
        super(image, path, standardVelocity, 150, 200);
    }
}
