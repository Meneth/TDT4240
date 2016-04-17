package group25.tdt4240.entity.tower;

import group25.tdt4240.R;
import sheep.graphics.Image;

/**
 * Created by Meneth on 17.04.2016.
 */
public class CrossTower extends Tower {
    public static final Image image = new Image(R.drawable.cross_tower);

    public float getCooldown() {
        return 1;
    }

    public CrossTower() {
        super(image, null, 10, 10);
        // TODO - Actual projectile
    }

    @Override
    public int getNextUpgradeCost() {
        return 0;
    }

    @Override
    public Priority getTargetPriority() {
        return null;
    }

    @Override
    public void upgrade() {

    }
}
