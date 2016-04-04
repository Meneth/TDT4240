package group25.tdt4240.entity.tile;

import group25.tdt4240.entity.tower.Tower;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public class BuildTile extends Tile {
    private Tower tower;

    public BuildTile(Image image){
        super(image);
    }

    public Tower getTower() {
        return tower;
    }
    public void setTower(Tower tower) {
        this.tower = tower;
    }
    public boolean isBuilt(){
        return (tower != null);
    }



}
