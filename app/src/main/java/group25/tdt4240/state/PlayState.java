package group25.tdt4240.state;

/**
 * Created by Meneth on 2016-03-31.
 */

import android.graphics.Canvas;

import android.graphics.Color;

import group25.tdt4240.entity.monster.BasicMonster;
import group25.tdt4240.entity.tower.CrossTower;
import group25.tdt4240.map.Map;
import group25.tdt4240.R;
import group25.tdt4240.entity.button.Button;
import group25.tdt4240.entity.button.SellButton;
import group25.tdt4240.entity.button.UpgradeButton;
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
    Button upgradeButton = new UpgradeButton(upgradeButtonImage, this);

    private Image sellButtonImage = new Image(R.drawable.play_button);
    Button sellButton = new SellButton(sellButtonImage, this);

    public PlayState() {
        this.currentMap = new Map();
        // TODO - This way of adding a monster is placeholder
        addEntity(new BasicMonster(currentMap.path));
        addEntity(currentMap);
        Tower t = new CrossTower();
        addEntity(t);
        ((BuildTile) currentMap.tiles.get(2)).setTower(t);

        System.out.println("created new playstate");
    }

    public void selectTower(Tower t){
        this.selectedTower = t;
        this.selectedTile = null;
    }

    public void selectTile(BuildTile t){
        this.selectedTile = t;
        this.selectedTower = null;
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
}