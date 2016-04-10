package group25.tdt4240;

import android.graphics.Canvas;

import java.util.ArrayList;

import group25.tdt4240.entity.Entity;
import group25.tdt4240.entity.tile.PathTile;
import group25.tdt4240.entity.tile.Tile;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 * This class takes inn a text file, and generates a map, using the tile-classes.
 * The map is used in the playstate class, where it is displayed, and used for the player
 * to play on.
 */
public class Map {

    //for debugging purposes
    public String exampleMapString = "bbbbpbbbbn" +
            "bbbbpppbbn" +
            "bbbbbbpbbn" +
            "bbbbpppbbn";
    public ArrayList<Tile> tiles;
    public ArrayList<Entity> entities;
    private Image grassTile = new Image(R.drawable.grasstile);
    private Image dirtTile = new Image(R.drawable.dirttile);

    public Map() {
        this.tiles = new ArrayList<Tile>();
        this.entities = new ArrayList<Entity>();
        int x = 0;
        //starts at 2 to not be under the "tdt42402" sign on top of the screen
        int y = 1;

        //iterates through string and generates map with coordinates accordingly
        // each tile is 20 pixels wide. *21 is just temporarily, to make it easier to see the grid.
        for (int i = 0; i < exampleMapString.length(); i++) {
            if (exampleMapString.charAt(i) == 'b') {
                tiles.add(new PathTile(grassTile, x * 21, y * 21));
                x++;
            } else if (exampleMapString.charAt(i) == 'p') {
                tiles.add(new PathTile(dirtTile, x * 21, y * 21));
                x++;
            } else if (exampleMapString.charAt(i) == 'n') {
                x = 0;
                y++;
            }
        }
    }

    public void draw(Canvas canvas) {
        for (Tile t : this.tiles) {
            System.out.println(t.getX());
            t.draw(canvas);
        }
    }

}
