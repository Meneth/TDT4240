package group25.tdt4240;

import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;

import java.util.ArrayList;

import group25.tdt4240.entity.Drawable;
import group25.tdt4240.entity.Entity;
import group25.tdt4240.entity.tile.Tile;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public class Map implements Drawable {
	public ArrayList<Tile> tiles;
	public ArrayList<Entity> entities;

	public Map(){
		this.tiles = new ArrayList<Tile>();
		for (int i=0;i<9;i++){
			Tile t = new Tile(new Image(new ColorDrawable(0xEEEEEE)));
			t.setPosition(100*(i/3),100*(i%3));
			t.setScale(100,100);
			tiles.add(t);
		}
	}

	public void draw(Canvas canvas){
		for (Tile t: tiles){
			t.draw(canvas);
		}
	}

	public void update(float dt){
		for (Tile t: tiles){
			t.update(dt);
		}
	}
}
