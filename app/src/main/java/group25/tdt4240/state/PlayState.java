package group25.tdt4240.state;

/**
 * Created by Meneth on 2016-03-31.
 */

import group25.tdt4240.Constants;
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
import sheep.input.TouchListener;

public class PlayState extends SuperState {
    private Map currentMap;
    private Image grassTile = new Image(R.drawable.grasstile);
    private int defenderMoney= 0;

    private BuildTile selectedTile;
    public TowerButton selectedTower;

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
        upgradeButton.setPosition(Constants.SCREEN_WIDTH/2,Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT/5);
        sellButton.setPosition(Constants.SCREEN_WIDTH*6/7,Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT/5);
        addEntities(upgradeButton,sellButton,buyButton);
    }

    public void selectTower(TowerButton t){
        this.selectedTower = t;
        this.selectedTile = null;
    }

    public void selectTile(BuildTile t){
        this.selectedTile = t;
        this.selectedTower = null;
    }

    public void buyTower(BuildTile tile) {
        if (selectedTower != null) {
            // TODO - Check if enough money
            tile.setTower(selectedTower.getTower());
        }
    }
    public void sellTower(){
        if (selectedTower != null){
            defenderMoney += selectedTower.getCost();
            currentMap.tiles.remove(selectedTower);
        }
        System.out.println("Sell selected tower");
    }
    public void displayTowersToBuy(){
        TowerButton buyableTower = new TowerButton(CrossTower.image, new TowerFactory() {
            @Override
            public Tower getTower() {
                return new CrossTower();
            }
        });
        buyableTower.setPosition(Constants.SCREEN_WIDTH/6, Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT/4);
        buyableTower.setScale(0.5f,0.5f);
        addEntity(buyableTower);
    }
    public void upgradeTower() {
        // TODO - Can't base itself on selecting a tower
        /*if (selectedTower != null){
            if (defenderMoney >= selectedTower.getNextUpgradeCost()) {
                defenderMoney -= selectedTower.getCost();
                selectedTower.upgrade();
            }
        }*/
    }

    public void gameOver() {
        getGame().popState();
        getGame().pushState(new GameOverState());
    }
}