package group25.tdt4240.state;

/**
 * Created by Meneth on 2016-03-31.
 */

import android.graphics.Canvas;

import android.graphics.Color;
import android.view.MotionEvent;

import group25.tdt4240.entity.map.Map;
import group25.tdt4240.R;
import group25.tdt4240.entity.button.Button;
import group25.tdt4240.entity.tile.BuildTile;
import group25.tdt4240.entity.tile.Tile;
import group25.tdt4240.entity.tower.Tower;
import sheep.graphics.Image;

public class PlayState extends SuperState {
    private Map currentMap;
    private Image grassTile = new Image(R.drawable.grasstile);
    private int defenderMoney= 0;

    private BuildTile selectedTile;
    private Tower selectedTower;

    private Image upgradeButtonImage = new Image(R.drawable.play_button);
   // Button upgradeButton = new Button(upgradeButtonImage);

    private Image sellButtonImage = new Image(R.drawable.play_button);
    Button sellButton = new Button(sellButtonImage,"SELL", this);

    public PlayState() {
        this.currentMap = new Map();
        System.out.println("created new playstate");
    }
    public void buyTower(){
        this.currentMap.entities.add(selectedTower);
    }
    public void sellTower(){
        if (selectedTower != null){
            defenderMoney += selectedTower.getCost();
            currentMap.tiles.remove(selectedTower);
        }
        System.out.println("Sell selected tower");
    }
    public void upgradeTower(){
        if (selectedTower != null){
            if (defenderMoney >= selectedTower.getNextUpgradeCost()) {
                defenderMoney -= selectedTower.getCost();
                selectedTower.upgrade();
            }
        }
    }
    public boolean onTouchUp(MotionEvent event) {
        float clickY = event.getY();
        float clickX = event.getX();
        /*for (Entity e: currentMap.entities + (ArrayList<Entity>) currentMap.tiles){
            if (e instanceof Tower){
                if (e.getBoundingBox().contains(clickX, clickY)){
                    selectedTower = (Tower) e;
                    return true;
                }
            }
            if (e instanceof BuildTile){
                if (e.getBoundingBox().contains(clickX, clickY)){
                    selectedTower = (Tower) e;
                    return true;
                }
            }
        }

        */

        return false;
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