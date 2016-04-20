package group25.tdt4240.entity.projectile;

import group25.tdt4240.R;
import group25.tdt4240.entity.monster.Monster;
import sheep.graphics.Image;

/**
 * Created by rh183_000 on 20/04/2016.
 */
public class SnowBall extends Projectile {
    private static final Image image = new Image(R.drawable.snowball);

    public SnowBall(Monster target) {
        super(image, target, 20, 200);
    }
}
