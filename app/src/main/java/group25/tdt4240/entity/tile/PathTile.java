package group25.tdt4240.entity.tile;



import java.util.ArrayList;

import group25.tdt4240.Constants;
import group25.tdt4240.R;
import group25.tdt4240.entity.monster.Monster;
import sheep.graphics.Image;
import sheep.math.BoundingBox;

/**
 * Created by Meneth on 2016-03-31.
 */
public class PathTile extends Tile {
    private static Image image = new Image(R.drawable.dirttile);

    //Different tiles with different speed? e.g. river is slow, road is fast
    private int speed;
    //Some paths exclusive to certain monsters?
    private String pathType;

    private ArrayList<PathTile> entryTiles;
    private PathTile exitTile;

    /**
     * @param x       X position in map grid
     * @param y       Y position in map grid
     */
    public PathTile(float x, float y ){
        super(image, x, y);
    }


    /**
     *
     * @param monsters Collection of the monsters on the map
     * @return The monsters on this tile
     */
    public ArrayList<Monster> getContainedMonsters(ArrayList<Monster> monsters){
        ArrayList<Monster> _m = new ArrayList<Monster>();
        for (Monster m : monsters){
            if (this.collides(m)){
                _m.add(m);
            }
        }
        return _m;
    }

    public String toString() {
        return "Path: " + getPosition().toString();
    }
}