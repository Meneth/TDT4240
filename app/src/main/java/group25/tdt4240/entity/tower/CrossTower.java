package group25.tdt4240.entity.tower;

import group25.tdt4240.R;
import group25.tdt4240.entity.monster.Monster;
import group25.tdt4240.entity.projectile.CanonBall;
import group25.tdt4240.entity.projectile.Projectile;
import sheep.graphics.Image;

/**
 * Created by Meneth on 17.04.2016.
 */
public class CrossTower extends Tower {
    public static final Image image = new Image(R.drawable.cross_tower);

    public CrossTower() {
        super(image, 1, 10);
    }

    @Override
    public int getNextUpgradeCost() {
        return 0; // TODO
    }

    @Override
    public Priority getTargetPriority() {
        return null; // TODO
    }

    @Override
    public void upgrade() {
        // TODO
    }

    @Override
    protected Projectile getNewProjectile(Monster target) {
        return new CanonBall(target);
    }
}
