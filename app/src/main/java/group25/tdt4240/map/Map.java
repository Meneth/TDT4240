package group25.tdt4240.map;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

import group25.tdt4240.Constants;
import group25.tdt4240.R;
import group25.tdt4240.entity.AbstractDrawable;
import group25.tdt4240.entity.Drawable;
import group25.tdt4240.entity.Entity;
import group25.tdt4240.entity.tile.BuildTile;
import group25.tdt4240.entity.tile.PathTile;
import group25.tdt4240.entity.tile.Tile;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 * This class takes inn a text file, and generates a map, using the tile-classes.
 * The map is used in the playstate class, where it is displayed, and used for the player
 * to play on.
 */
public class Map extends AbstractDrawable {

    /*for debugging purposes
    b = buildtile
    p = pathtile
    n = new line
    s = start(pathtile)
    g = goal(pathtile)
    */

    private String exampleMapString =
            "10 4\n" +
            "bbbbsbbbbb\n" +
            "bbbbpppbbb\n" +
            "bbbbbbpbbb\n" +
            "bbbbgppbbb";
    private String examplePath =
            "4 0\n4 1\n5 1\n" +
            "6 1\n6 2\n6 3\n" +
            "5 3\n4 3";
    public ArrayList<Tile> tiles;
    public ArrayList<Entity> entities;
    private Image grassTile = new Image(R.drawable.grasstile);
    private Image dirtTile = new Image(R.drawable.dirttile);
    private PathTile goal;
    private PathTile start;
    private int width, height;
    public Path path;

    public Map() {
        this.tiles = new ArrayList<Tile>();
        this.entities = new ArrayList<Entity>();

        readMap(exampleMapString);
        readPath(examplePath);
    }

    /**
     * Iterates through string and generates map with coordinates accordingly
     * @param map The string describing the map
     */
    private void readMap(String map) {
        String[] rows = map.split("\n");
        String[] dimensions = rows[0].split(" ");
        width = Integer.parseInt(dimensions[0]);
        height = Integer.parseInt(dimensions[1]);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // Offset by one since the 0th row is the dimensions
                switch (rows[i+1].charAt(j)) {
                    case 's':
                        PathTile s = new PathTile(j, i);
                        tiles.add(s);
                        this.start = s;
                        break;
                    case 'g':
                        PathTile goal = new PathTile(j, i);
                        this.tiles.add(goal);
                        break;
                    case 'p':
                        tiles.add(new PathTile(j, i));
                        break;
                    case 'b':
                        tiles.add(new BuildTile(j, i));
                        break;
                }
            }
        }
    }

    /**
     * Currently only tries to find a single path; can't handle branching
     */
    private void readPath(String path) {
        Path p = new Path();
        for (String s: path.split("\n")) {
            String[] tile = s.split(" ");
            int i = Integer.parseInt(tile[1]) * width + Integer.parseInt(tile[0]);
                if (tiles.get(i) instanceof PathTile){
                p.add((PathTile) tiles.get(i));
            }
        }
        this.path = p;
    }

    public void draw(Canvas canvas) {
        for (Tile t : this.tiles) {
            t.draw(canvas);
        }
    }

    @Override
    public void update(float dt) {
        for (Tile t : this.tiles) {
            t.update(dt);
        }
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public int compareTo(Drawable another) {
        return another.getPriority() - getPriority();
    }
}
