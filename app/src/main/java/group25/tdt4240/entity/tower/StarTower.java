package group25.tdt4240.entity.tower;

import group25.tdt4240.R;
import group25.tdt4240.entity.monster.Monster;
import group25.tdt4240.entity.projectile.Projectile;
import group25.tdt4240.entity.projectile.StarBall;
import sheep.graphics.Image;

/**
 * Created by rh183_000 on 20/04/2016.
 */
public class StarTower extends Tower {
    public static final Image image = new Image(R.drawable.square_tower);
    private int upgradeCost = 0;
    public StarTower() {
        super(image, 0.5f, 310, 750);
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
        return new StarTower();
    }

    @Override
    protected Projectile getNewProjectile(Monster target) {
        return new StarBall(target);
    }
}