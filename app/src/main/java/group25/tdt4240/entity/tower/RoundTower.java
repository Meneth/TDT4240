package group25.tdt4240.entity.tower;

import group25.tdt4240.R;
import group25.tdt4240.entity.monster.Monster;
import group25.tdt4240.entity.projectile.FireBall;
import group25.tdt4240.entity.projectile.Projectile;
import sheep.graphics.Image;

/**
 * Created by rh183_000 on 20/04/2016.
 */
public class RoundTower extends Tower {
    public static final Image image = new Image(R.drawable.round_tower);

    public RoundTower() {
        super(image, 1, 215, 350);
    }

    @Override
    public int getNextUpgradeCost() {
        return 100;
    }

    @Override
    public Tower upgrade() {
        die();
        return new CrosserTower();
    }

    @Override
    protected Projectile getNewProjectile(Monster target) {
        return new FireBall(target);
    }
}
