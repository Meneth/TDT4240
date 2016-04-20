package group25.tdt4240.state;

/**
 * Created by Meneth on 2016-03-31.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import group25.tdt4240.Constants;
import group25.tdt4240.entity.Drawable;
import group25.tdt4240.entity.Entity;
import group25.tdt4240.entity.button.*;
import group25.tdt4240.entity.factory.TowerFactory;
import group25.tdt4240.entity.monster.BasicMonster;
import group25.tdt4240.entity.tower.CrossTower;
import group25.tdt4240.map.Map;
import group25.tdt4240.R;
import group25.tdt4240.entity.tile.BuildTile;
import group25.tdt4240.entity.tower.Tower;
import sheep.graphics.Image;

import java.util.ArrayList;

public class PlayState extends SuperState {
    private Map currentMap;
    private int defenderMoney= 2100;
    private int defenderHealth = 150;
    private float timer = 0.0f;
    public TowerButton selectedTower;

    public enum Action {
        BUY, SELL, UPGRADE, NONE;
    }
    Action action = Action.NONE;

    private Image upgradeButtonImage = new Image(R.drawable.upgrade_button);
    Button upgradeButton = new UpgradeButton(upgradeButtonImage);

    private Image sellButtonImage = new Image(R.drawable.sell_button);
    Button sellButton = new SellButton(sellButtonImage);

    private Image buyButtonImage = new Image((R.drawable.buy_button));
    Button buyButton = new BuyButton(buyButtonImage);

    public PlayState() {
        this.currentMap = new Map();
        // TODO - This way of adding a monster is placeholder
        addEntity(new BasicMonster(currentMap.path));
        addEntities((Entity[]) currentMap.tiles.toArray(new Entity[currentMap.tiles.size()]));
        Tower t = new CrossTower();
        ((BuildTile) currentMap.tiles.get(2)).setTower(t);

        System.out.println("created new playstate");
        buyButton.setPosition(Constants.SCREEN_WIDTH / 7, Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT / 5);
        upgradeButton.setPosition(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT / 5);
        sellButton.setPosition(Constants.SCREEN_WIDTH * 6 / 7, Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT / 5);


        addEntities(upgradeButton, sellButton, buyButton);
        buyButton.setPosition(Constants.SCREEN_WIDTH/7, Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT/5);
        upgradeButton.setPosition(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT / 5);
        sellButton.setPosition(Constants.SCREEN_WIDTH * 6 / 7, Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT / 5);
        addEntities(upgradeButton,sellButton,buyButton);

    }

    public void selectTower(TowerButton t){
        this.selectedTower = t;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        p.setTextSize(20);
        canvas.drawText("Gs: " + Integer.toString(defenderMoney), (Constants.SCREEN_WIDTH / 7) * 6, (Constants.SCREEN_HEIGHT / 7) * 6, p);
        canvas.drawText("HP: " + Integer.toString(defenderHealth), (Constants.SCREEN_WIDTH / 7), (Constants.SCREEN_HEIGHT / 7) * 6, p);
        for (Drawable entity : entities)
            entity.draw(canvas);
    }

    @Override
    public void update(float dt) {
        timer += dt;
        if (timer > 2) {
            addEntity(new BasicMonster(currentMap.path));
            timer = 0.0f;
        }
        updateEntityLists();
        for (Drawable entity : new ArrayList<>(entities))
            entity.update(dt);
    }

    public void buyTower(BuildTile tile) {
        if (tile.getTower() != null)
            return;
        if (selectedTower == null)
            return;
        if (selectedTower.getCost() > defenderMoney)
            return;
        defenderMoney -= selectedTower.getCost();
        tile.setTower(selectedTower.getTower());
    }
    public void sellTower(BuildTile tile) {
        Tower t = tile.getTower();
        if (t != null)
            defenderMoney += t.getCost();
            tile.setTower(null);
        System.out.println("Sell selected tower");
    }

    public void displayTowersToBuy() {
        TowerButton buyableTower = new TowerButton(CrossTower.image, new TowerFactory() {
            @Override
            public Tower getTower() {
                return new CrossTower();
            }
        });
        buyableTower.setPosition(Constants.SCREEN_WIDTH / 6, Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT / 4);
        buyableTower.setScale(0.5f, 0.5f);
        addEntity(buyableTower);
    }


    public Tower upgradeTower(BuildTile tile) {
        Tower t = tile.getTower();
        if (t != null && defenderMoney >= t.getNextUpgradeCost()) {
            defenderMoney -= t.getNextUpgradeCost();
            tile.setTower(t.upgrade());
            System.out.println("Upgrading tower");
        }
        return t;
    }

    public boolean setAction(Action action) {
        if (action == this.action) {
            this.action = Action.NONE;
            return false;
        }
        switch (action) {
            case BUY:
                displayTowersToBuy();
                break;
            default:
                // TODO - Hide buy towers
                break;
        }
        this.action = action;
        return true;
    }

    public void loseHealth(int h) {
        System.out.println("losing health");
        this.defenderHealth -= h;
        addEntity(new BasicMonster(currentMap.path));
        if (defenderHealth <= 0) {
            gameOver();
        }
    }

    public void gameOver() {
        getGame().popState();
        getGame().pushState(new GameOverState());
    }

    public void clickTile(BuildTile tile) {
        switch (action) {
            case BUY:
                buyTower(tile);
                break;
            case SELL:
                sellTower(tile);
                break;
            case UPGRADE:
                upgradeTower(tile);
                break;
        }
    }
}