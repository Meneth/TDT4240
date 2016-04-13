package group25.tdt4240.entity.tile;



import java.util.ArrayList;

import group25.tdt4240.Constants;
import group25.tdt4240.entity.monster.Monster;
import sheep.graphics.Image;
import sheep.math.BoundingBox;

/**
 * Created by Meneth on 2016-03-31.
 */
public class PathTile extends Tile {

    //Different tiles with different speed? e.g. river is slow, road is fast
    private int speed;
    //Some paths exclusive to certain monsters?
    private String pathType;

    private ArrayList<PathTile> entryTiles;
    private PathTile exitTile;

    /**
     *
     * @param image   The image the sprite is to be generated from
     * @param x       X position in map grid
     * @param y       Y position in map grid
     * @param entries All the path tiles that lead to this one
     * @param exit    The path tile this one leads to
     */
    public PathTile(Image image, float x, float y ){
        super(image);
        //this.setScale(2.0f,2.0f);
        this.setPosition(x,y);
        //this.setShape(Constants.TILE_WIDTH, Constants.TILE_HEIGHT);
        //this.entryTiles = entries;
        //this.exitTile = exit;
    }


    /**
     *
     * @param monsters Collection of the monsters on the map
     * @return The monsters on this tile
     */
    public ArrayList<Monster> getContainedMonsters(ArrayList<Monster> monsters){
        ArrayList<Monster> _m = new ArrayList<Monster>();
        for (Monster m: monsters){
            if (this.collides(m)){
                _m.add(m);
            }
        }
        return _m;
    }
}