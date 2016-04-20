package group25.tdt4240.entity.tile;


import group25.tdt4240.R;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public class PathTile extends Tile {
    private static final Image image = new Image(R.drawable.dirttile);

    /**
     * @param x X position in map grid
     * @param y Y position in map grid
     */
    public PathTile(float x, float y) {
        super(image, x, y);
    }

    public String toString() {
        return "Path: " + getPosition().toString();
    }
}