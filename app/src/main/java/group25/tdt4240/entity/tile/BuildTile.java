package group25.tdt4240.entity.tile;


import android.view.MotionEvent;

import group25.tdt4240.R;
import group25.tdt4240.entity.Clickable;
import group25.tdt4240.entity.tower.CrossTower;
import group25.tdt4240.entity.tower.Tower;
import group25.tdt4240.state.PlayState;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */

public class BuildTile extends Tile implements Clickable {
    private Tower tower;
    private static Image image = new Image(R.drawable.grasstile);

    /**
     * @param x The x index of the tile
     * @param y The y index of the tile
     */
    public BuildTile(float x, float y) {
        super(image, x, y);
    }

    /**
     * @return The tower that is built
     */
    public Tower getTower() {
        return tower;
    }

    /**
     * @param tower Set current tower
     */
    public void setTower(Tower tower) {
        if (tower != null)
            tower.die();
        this.tower = tower;
        tower.setPosition(getPosition());
        getContainer().addEntity(tower);
    }

    /**
     * @return If the tile is vacant
     */
    public boolean isBuilt() {
        return (tower != null);
    }


    @Override
    public PlayState getContainer() {
        return (PlayState) super.getContainer();
    }


    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (checkClick(event)){
            getContainer().clickTile(this);
        }
        return false;
    }

    public String toString() {
        return "Build: " + getPosition().toString();
    }
}
