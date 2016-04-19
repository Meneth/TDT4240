package group25.tdt4240.entity.tower;

import group25.tdt4240.R;
import group25.tdt4240.entity.monster.Monster;
import group25.tdt4240.entity.projectile.CanonBall;
import group25.tdt4240.entity.projectile.Projectile;
import sheep.graphics.Image;

/**
 * Created by Meneth on 17.04.2016.
 */
public class CrosserTower extends Tower {
    public static final Image image = new Image(R.drawable.monster1);
    private int upgradeCost = 9999;
    public CrosserTower() {
        super(image, 0.5f, 0, 600);
    }

    @Override
    public int getNextUpgradeCost() {
        return upgradeCost;
    }

    @Override
    public Priority getTargetPriority() {
        return Priority.CLOSEST; // TODO
    }

    @Override
    public Tower upgrade() {
        return this;
    }

    @Override
    protected Projectile getNewProjectile(Monster target) {
        return new CanonBall(target);
    }
}
