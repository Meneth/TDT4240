package group25.tdt4240.state;

/**
 * Created by Meneth on 2016-03-31.
 */

import android.graphics.Canvas;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.Window;
import group25.tdt4240.Map;
import group25.tdt4240.R;
import group25.tdt4240.entity.tile.PathTile;
import group25.tdt4240.entity.tile.Tile;
import sheep.game.State;
import sheep.graphics.Image;

public class PlayState extends SuperState {
    private Map currentMap;
    private Image grassTile = new Image(R.drawable.grasstile);
    private PathTile t;


    public PlayState() {
        this.currentMap = new Map();
        System.out.println("created new playstate");
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        currentMap.draw(canvas);
    }


    // needs to update all images that shall be shown.
    // Problem with only one green tile top corner solved by this for loop.
    @Override
    public void update(float dt) {
        for (Tile t : currentMap.tiles) {
            t.update(dt);
        }

    }
}