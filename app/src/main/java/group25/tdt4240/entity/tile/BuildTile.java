package group25.tdt4240.entity.tile;

import group25.tdt4240.entity.tower.Tower;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public class BuildTile extends Tile {
    private Tower tower;

    /**
     *
     * @param image The image the sprite is to be generated from
     */
    public BuildTile(Image image){
        super(image);
    }

    /**
     *
     * @return The tower that is built
     */
    public Tower getTower() {
        return tower;
    }

    /**
     *
     * @param tower Set current tower
     */
    public void setTower(Tower tower) {
        this.tower = tower;
    }

    /**
     *
     * @return If the tile is vacant
     */
    public boolean isBuilt(){
        return (tower != null);
    }

}
