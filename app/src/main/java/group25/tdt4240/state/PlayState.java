package group25.tdt4240.state;

/**
 * Created by Meneth on 2016-03-31.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import group25.tdt4240.utility.Constants;
import group25.tdt4240.entity.Entity;
import group25.tdt4240.entity.button.*;
import group25.tdt4240.factory.Factory;
import group25.tdt4240.entity.monster.*;
import group25.tdt4240.entity.tower.*;
import group25.tdt4240.map.Map;
import group25.tdt4240.entity.tile.BuildTile;
import sheep.game.Sprite;
import sheep.graphics.Image;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlayState extends SuperState {
    private Map currentMap;
    private int attackerMoney = 500;
    private int defenderMoney= 500;
    private int defenderHealth = 20;

    private int roundCounter = 0;

    private float timer = 0.0f;
    private TowerButton selectedTower;
    private List<TowerButton> buyableTowers = new ArrayList<>();
    private List<MonsterButton> buyableMonsters = new ArrayList<>();
    private Queue<Monster> currentMonsterQueue = new LinkedList<>();
    private List<Sprite> monsterQueue = new ArrayList<>();

    public enum Action {
        BUY, SELL, UPGRADE, NONE;
    }
    private Action action = Action.NONE;

    private ToggleButton upgradeButton = new UpgradeButton();
    private ToggleButton sellButton = new SellButton();
    private ToggleButton buyButton = new BuyButton();

    private Button doneButton = new DoneButton();

    private Round round;

    private Paint p;

    public PlayState() {
        this.currentMap = new Map();
        addEntities((Entity[]) currentMap.tiles.toArray(new Entity[currentMap.tiles.size()]));

        System.out.println("created new playstate");
        buyButton.setPosition(Constants.SCREEN_WIDTH / 7, Constants.SCREEN_HEIGHT * 4 / 5);
        upgradeButton.setPosition(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT * 4 / 5);
        sellButton.setPosition(Constants.SCREEN_WIDTH * 6 / 7, Constants.SCREEN_HEIGHT * 4 / 5);
        doneButton.setPosition(Constants.SCREEN_WIDTH * 6 / 7, Constants.SCREEN_HEIGHT * 7 / 8);

        initializeBuyableTowers();
        initializeMonsters();
        p = new Paint();
        p.setColor(Color.WHITE);
        p.setTextSize(20);

        startRound(Round.MONSTER);
    }

    private enum Round {
        TOWER, MONSTER, PLAY;
    }

    public void advanceRound() {
        switch (round) {
            case TOWER:
                startRound(Round.PLAY);
                break;
            case MONSTER:
                startRound(Round.TOWER);
                break;
            case PLAY:
                startRound(Round.MONSTER);
                break;
        }
    }

    /**
     * Starts a given round
     * @param round The round to start
     */
    private void startRound(Round round) {
        this.round = round;
        switch (round) {
            case TOWER:

                addEntities(upgradeButton, sellButton, buyButton);
                hideMonstersToChoose();
                break;
            case MONSTER:
                // Both players get money when new round starts
                defenderMoney += roundCounter * 30;
                attackerMoney += roundCounter * 500;

                addEntities(doneButton);
                currentMonsterQueue.clear();
                monsterQueue.clear();
                displayMonstersToChoose();
                hideTowersToBuy();
                break;
            case PLAY:
                roundCounter += 1;
                hideTowersToBuy();
                setAction(action.NONE);
                removeEntities(upgradeButton, sellButton, buyButton, doneButton);
                break;
        }
    }

    private void initializeMonsters() {
        buyableMonsters.add(new MonsterButton(BasicMonster.image, new Factory() {
            @Override
            public Monster get() {
                return new BasicMonster(currentMap.path);
            }
        }));
        buyableMonsters.add(new MonsterButton(Monster2.image, new Factory() {
            @Override
            public Monster get() {
                return new Monster2(currentMap.path);
            }
        }));
        buyableMonsters.add(new MonsterButton(Monster3.image, new Factory() {
            @Override
            public Monster get() {
                return new Monster3(currentMap.path);
            }
        }));
        buyableMonsters.add(new MonsterButton(Monster4.image, new Factory() {
            @Override
            public Monster get() {
                return new Monster4(currentMap.path);
            }
        }));
        for (int i = 0; i < buyableMonsters.size(); i++) {
            MonsterButton button = buyableMonsters.get(i);
            button.setPosition(Constants.SCREEN_WIDTH * (i + 0.5f) / 7,
                    buyButton.getY() - button.getOffset().getY() * 2);
        }
    }

    private void initializeBuyableTowers() {
        buyableTowers.add(new TowerButton(CrossTower.image, new Factory() {
            @Override
            public Tower get() {
                return new CrossTower();
            }
        }));
        buyableTowers.add(new TowerButton(SquareTower.image, new Factory() {
            @Override
            public Tower get() {
                return new SquareTower();
            }
        }));
        buyableTowers.add(new TowerButton(StarTower.image, new Factory() {
            @Override
            public Tower get() {
                return new StarTower();
            }
        }));
        for (int i = 0; i < buyableTowers.size(); i++) {
            TowerButton button = buyableTowers.get(i);
            button.setPosition(Constants.SCREEN_WIDTH * (i + 0.5f) / 7,
                    buyButton.getY() - button.getOffset().getY() * 2);
        }
    }
    public void selectTower(TowerButton t){
        if (this.selectedTower != null){
            this.selectedTower.toggleButton();
        }
        t.toggleButton();
        this.selectedTower = t;
    }

    public void clickMonster(Monster m) {
        if (attackerMoney >= m.getCost()){
            attackerMoney -= m.getCost();
            currentMonsterQueue.offer(m);
            Sprite s = new Sprite(m.getImage());
            s.setPosition(((Constants.SCREEN_WIDTH / 20) * monsterQueue.size()) + 20, (Constants.SCREEN_HEIGHT / 7) * 4);
            s.update(0.01f);
            monsterQueue.add(s);
        }

    }

    public void monsterDied(Monster m) {
        defenderMoney += m.getCost();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (round == Round.MONSTER){
            for (int i = 0; i < monsterQueue.size(); i++){
                monsterQueue.get(i).draw(canvas);
            }
        }
        canvas.drawText("Attacker Cash: " + Integer.toString(attackerMoney), (Constants.SCREEN_WIDTH / 7), (Constants.SCREEN_HEIGHT / 7) * 6.1f, p);
        canvas.drawText("Defender Moneeeyh: " + Integer.toString(defenderMoney), (Constants.SCREEN_WIDTH / 7), (Constants.SCREEN_HEIGHT / 7) * 6.3f, p);
        canvas.drawText("HP: " + Integer.toString(defenderHealth), (Constants.SCREEN_WIDTH / 7), (Constants.SCREEN_HEIGHT / 7) * 6.5f, p);
    }

    @Override
    public void update(float dt)  {
        if (round == Round.PLAY) {
            if (getMonsters().isEmpty() && currentMonsterQueue.isEmpty()) {
                advanceRound();
            } else {
                timer += dt;
                if (timer > 2) {
                    addEntity(currentMonsterQueue.poll());
                    timer = 0.0f;
                }
            }
        }
        super.update(dt);
    }

    private void buyTower(BuildTile tile) {
        if (tile.getTower() != null)
            return;
        if (selectedTower == null)
            return;
        if (selectedTower.getCost() > defenderMoney)
            return;
        defenderMoney -= selectedTower.getCost();
        tile.setTower(selectedTower.getTower());
    }
    private void sellTower(BuildTile tile) {
        Tower t = tile.getTower();
        if (t != null)
            defenderMoney += t.getCost();
            tile.setTower(null);
        System.out.println("Sell selected tower");
    }

    private void displayTowersToBuy() {
        for (TowerButton button : buyableTowers) {
            addEntity(button);
        }
    }

    private void displayMonstersToChoose() {
        for (MonsterButton button : buyableMonsters) {
            addEntity(button);
        }
    }
    private void hideTowersToBuy() {
        for (TowerButton button : buyableTowers) {
            removeEntity(button);
        }
    }

    public void hideMonstersToChoose() {
        for (MonsterButton button : buyableMonsters) {
            removeEntity(button);
        }
    }

    private Tower upgradeTower(BuildTile tile) {
        Tower t = tile.getTower();
        if (t != null && defenderMoney >= t.getNextUpgradeCost()) {
            defenderMoney -= t.getNextUpgradeCost();
            tile.setTower(t.upgrade());
            System.out.println("Upgrading tower");
        }
        return t;
    }

    public boolean setAction(Action action) {
        switch (this.action) {
            case BUY:
                buyButton.toggleButton();
                hideTowersToBuy();
                break;
            case SELL:
                sellButton.toggleButton();
                break;
            case UPGRADE:
                upgradeButton.toggleButton();
                break;
        }
        if (action == this.action) {
            this.action = Action.NONE;
            return false;
        }


        switch (action) {
            case BUY:
                displayTowersToBuy();
                buyButton.toggleButton();
                break;
            case SELL:
                sellButton.toggleButton();
                break;
            case UPGRADE:
                upgradeButton.toggleButton();
                break;
            default:
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

    private void gameOver() {
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