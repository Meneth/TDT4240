package group25.tdt4240.state;

/**
 * Created by Meneth on 2016-03-31.
 */

import android.graphics.Canvas;

import group25.tdt4240.Map;
import sheep.game.State;

public class PlayState extends SuperState {
    private Map currentMap;

    public PlayState(){
        this.currentMap = new Map();
        System.out.println("created new playstate   ");
    }

    public void draw(Canvas canvas) {
        currentMap.draw(canvas);
    }

}