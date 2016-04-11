package group25.tdt4240;

import android.graphics.Canvas;

import java.util.ArrayList;

import android.graphics.Path;
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
public class Map extends Entity {

    /*for debugging purposes
    b = buildtile
    p = pathtile
    n = new line
    s = start(pathtile)
    g = goal(pathtile)
    */

    public String exampleMapString =
            "bbbbsbbbbb\n" +
            "bbbbpppbbb\n" +
            "bbbbbbpbbb\n" +
            "bbbbgppbbb\n";
    public ArrayList<Tile> tiles;
    public ArrayList<Entity> entities;
    private Image grassTile = new Image(R.drawable.grasstile);
    private Image dirtTile = new Image(R.drawable.dirttile);
    private PathTile goal;
    private PathTile start;

    public Map() {
        this.tiles = new ArrayList<Tile>();
        this.entities = new ArrayList<Entity>();
        int x = 1;
        //starts at 1 to not be under the "tdt42402" sign on top of the screen
        int y = 1;

        //iterates through string and generates map with coordinates accordingly
        // each tile is 20 pixels wide. *21 is just temporarily, to make it easier to see the grid.
        for (int i = 0; i < exampleMapString.length(); i++) {
            switch (exampleMapString.charAt(i)) {
                case 's':
                    PathTile s = new PathTile(dirtTile, x * 21, y * 21);
                    tiles.add(s);
                    this.start = s;
                    x++;
                    break;
                case 'g':
                    PathTile goal = new PathTile(dirtTile, x * 21, y * 21);
                    this.tiles.add(goal);
                    x++;
                    break;
                case 'p':
                    tiles.add(new PathTile(dirtTile, x * 21, y * 21));
                    x++;
                    break;
                case 'b':
                    tiles.add(new BuildTile(grassTile, x * 21, y * 21));
                    x++;
                    break;
                case '\n':
                    x = 1;
                    y++;
                    break;
            }
        }
    }

    public void draw(Canvas canvas) {
        for (Tile t : this.tiles) {
            t.draw(canvas);
        }
    }

    @Override
    public int getPriority() {
        return 0;
    }

}
