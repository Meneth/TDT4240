package group25.tdt4240.map;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

import group25.tdt4240.Constants;
import group25.tdt4240.R;
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
public class Map implements Drawable {

    /*for debugging purposes
    b = buildtile
    p = pathtile
    n = new line
    s = start(pathtile)
    g = goal(pathtile)
    */

    private String exampleMapString =
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
        int tilesize = (int) (Constants.SCREEN_WIDTH/10);
        int x = 0;
        //starts at 1 to not be under the "tdt42402" sign on top of the screen
        int y = 0;
        //
        // each tile is 20 pixels wide. *21 is just temporarily, to make it easier to see the grid.
        for (int i = 0; i < map.length(); i++) {
            switch (map.charAt(i)) {
                case 's':
                    PathTile s = new PathTile(dirtTile, x * tilesize, y * tilesize);
                    tiles.add(s);
                    this.start = s;
                    x++;
                    break;
                case 'g':
                    PathTile goal = new PathTile(dirtTile, x * tilesize, y * tilesize);
                    this.tiles.add(goal);
                    x++;
                    break;
                case 'p':
                    tiles.add(new PathTile(dirtTile, x * tilesize, y * tilesize));
                    x++;
                    break;
                case 'b':
                    tiles.add(new BuildTile(grassTile, x * tilesize, y * tilesize));
                    x++;
                    break;
                case '\n':
                    x = 1;
                    y++;
                    break;
            }
        }
        width = x - 1; // Due to 0 vs. 1 indexing
        height = y;
    }

    /**
     * Currently only tries to find a single path; can't handle branching
     */
    private void readPath(String path) {
        Path p = new Path();
        for (String s: path.split("\n")) {
            String[] tile = s.split(" ");
            int i = Integer.parseInt(tile[1]) * width + Integer.parseInt(tile[0]);
            p.add((PathTile) tiles.get(i));
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
