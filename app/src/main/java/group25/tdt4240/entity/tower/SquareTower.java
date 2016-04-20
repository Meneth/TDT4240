package group25.tdt4240.entity.tower;

import group25.tdt4240.R;
import group25.tdt4240.entity.monster.Monster;
import group25.tdt4240.entity.projectile.CanonBall;
import group25.tdt4240.entity.projectile.Projectile;
import group25.tdt4240.entity.projectile.SnowBall;
import group25.tdt4240.entity.projectile.StarBall;
import sheep.graphics.Image;

/**
 * Created by rh183_000 on 20/04/2016.
 */
public class SquareTower extends Tower {
    public static final Image image = new Image(R.drawable.square_tower);
    private int upgradeCost = 100;
    public SquareTower() {
        super(image, 3, 150, 250);
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
        die();
        return new RoundTower();
    }

    @Override
    protected Projectile getNewProjectile(Monster target) {
        return new SnowBall(target);
    }
}

