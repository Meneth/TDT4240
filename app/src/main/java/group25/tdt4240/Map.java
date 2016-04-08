package group25.tdt4240;

import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;

import java.util.ArrayList;

import group25.tdt4240.entity.Entity;
import group25.tdt4240.entity.tile.PathTile;
import group25.tdt4240.entity.tile.Tile;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public class Map {
    public ArrayList<Tile> tiles;
    public ArrayList<Entity> entities;
    private Image grassTile = new Image(R.drawable.grasstile);
    private Image dirtTile = new Image(R.drawable.dirttile);

    public Map(){
        this.tiles = new ArrayList<Tile>();
        this.entities = new ArrayList<Entity>();
        for(int x = 0; x<10; x++){
            for(int y = 0; y<10; y++){
                tiles.add(new PathTile(grassTile,x*21,y*21));
            }
        }
    }

    public void draw(Canvas canvas){
        for (Tile t: this.tiles){
            System.out.println(t.getX());
            t.draw(canvas);
        }
    }

}
