package group25.tdt4240.map;

import java.util.ArrayList;

import group25.tdt4240.R;
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
public class Map {
    private static final Image waterTile = new Image(R.drawable.watertile);

    /*for debugging purposes
    b = buildtile
    p = pathtile
    w = water tile (non-buildable)
    n = new line
    s = start(pathtile)
    g = goal(pathtile)
    */

    public final ArrayList<Tile> tiles;
    private PathTile goal;
    private int width;
    public Path path;

    public Map() {
        this.tiles = new ArrayList<>();

        String exampleMapString = "10 10\n" +
                "bsbbbbbbbb\n" +
                "bpbbbppppp\n" +
                "bpbbbpbbbp\n" +
                "bpppppbbbp\n" +
                "bwwwwwbbbp\n" +
                "bwwwwwbbbp\n" +
                "bbbbbbbbbp\n" +
                "bbbppppppp\n" +
                "bbbpbbbbbb\n" +
                "bbbgbbbbbb\n";
        readMap(exampleMapString);
        String examplePath =
                "1 0\n1 1\n1 2\n" +
                        "1 3\n2 3\n3 3\n" +
                        "4 3\n5 3\n5 2\n" +
                        "5 1\n6 1\n7 1\n" +
                        "8 1\n9 1\n9 2\n" +
                        "9 3\n9 4\n9 5\n" +
                        "9 6\n9 7\n8 7\n" +
                        "7 7\n6 7\n5 7\n" +
                        "4 7\n3 7\n3 8\n" +
                        "3 9";
        readPath(examplePath);
    }

    /**
     * Iterates through string and generates map with coordinates accordingly
     *
     * @param map The string describing the map
     */
    private void readMap(String map) {
        String[] rows = map.split("\n");
        String[] dimensions = rows[0].split(" ");
        width = Integer.parseInt(dimensions[0]);
        int height = Integer.parseInt(dimensions[1]);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // Offset by one since the 0th row is the dimensions
                switch (rows[i + 1].charAt(j)) {
                    case 's':
                        PathTile s = new PathTile(j, i);
                        tiles.add(s);
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
                    case 'w':
                        tiles.add(new Tile(waterTile, j, i));
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
        for (String s : path.split("\n")) {
            String[] tile = s.split(" ");
            int i = Integer.parseInt(tile[1]) * width + Integer.parseInt(tile[0]);
            if (tiles.get(i) instanceof PathTile) {
                p.add((PathTile) tiles.get(i));
            }
        }
        this.path = p;
    }
}
