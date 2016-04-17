package group25.tdt4240.entity.projectile;

import group25.tdt4240.R;
import group25.tdt4240.entity.monster.Monster;
import sheep.graphics.Image;

/**
 * Created by Meneth on 17.04.2016.
 */
public class CanonBall extends Projectile {
    public static Image image = new Image(R.drawable.canonball);

    public CanonBall(Monster target) {
        super(image, target, 10, 50);
    }
}
