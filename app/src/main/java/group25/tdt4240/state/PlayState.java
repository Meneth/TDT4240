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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlayState extends SuperState {
    private final Map map;
    private int attackerMoney = 500;
    private int defenderMoney= 500;
    private int defenderHealth = 20;

    private int roundCounter = 0;

    private float timer = 0.0f;
    private TowerButton selectedTower;
    private final List<TowerButton> towers = new ArrayList<>();
    private final List<MonsterButton> monsters = new ArrayList<>();
    private final Queue<Monster> monsterQueue = new LinkedList<>();
    private final List<MonsterImageButton> monsterImageQueue = new ArrayList<>();

    public enum Action {
        BUY, SELL, UPGRADE, NONE
    }
    private Action action = Action.NONE;

    private final ToggleButton upgradeButton = new UpgradeButton();
    private final ToggleButton sellButton = new SellButton();
    private final ToggleButton buyButton = new BuyButton();

    private final Button doneButton = new DoneButton();

    private Round round;

    private final Paint p;

    public PlayState() {
        this.map = new Map();
        addEntities((Entity[]) map.tiles.toArray(new Entity[map.tiles.size()]));

        System.out.println("created new playstate");
        buyButton.setPosition(Constants.SCREEN_WIDTH / 7, Constants.SCREEN_HEIGHT * 4 / 5);
        upgradeButton.setPosition(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT * 4 / 5);
        sellButton.setPosition(Constants.SCREEN_WIDTH * 6 / 7, Constants.SCREEN_HEIGHT * 4 / 5);
        doneButton.setPosition(Constants.SCREEN_WIDTH * 6 / 7, Constants.SCREEN_HEIGHT * 7 / 8);

        initializeTowers();
        initializeMonsters();
        p = new Paint();
        p.setColor(Color.WHITE);
        p.setTextSize(20);

        startRound(Round.MONSTER);
    }

    private enum Round {
        TOWER, MONSTER, PLAY
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
                for (MonsterImageButton mb: monsterImageQueue){
                    mb.die();
                }
                monsterImageQueue.clear();
                break;
            case MONSTER:
                // Both players get money when new round starts
                defenderMoney += roundCounter * 30;
                attackerMoney = roundCounter * 500; // No saving between rounds. Easy to exploit
                addEntities(doneButton);
                monsterQueue.clear();
                displayMonstersToChoose();
                hideTowersToBuy();
                break;
            case PLAY:
                roundCounter += 1;
                hideTowersToBuy();
                setAction(Action.NONE);
                removeEntities(upgradeButton, sellButton, buyButton, doneButton);
                break;
        }
    }

    private void initializeMonsters() {
        monsters.add(new MonsterButton(BasicMonster.image, new Factory<Monster>() {
            @Override
            public Monster get() {
                return new BasicMonster(map.path);
            }
        }));
        monsters.add(new MonsterButton(Monster2.image, new Factory<Monster>() {
            @Override
            public Monster get() {
                return new Monster2(map.path);
            }
        }));
        monsters.add(new MonsterButton(Monster3.image, new Factory<Monster>() {
            @Override
            public Monster get() {
                return new Monster3(map.path);
            }
        }));
        monsters.add(new MonsterButton(Monster4.image, new Factory<Monster>() {
            @Override
            public Monster get() {
                return new Monster4(map.path);
            }
        }));
        for (int i = 0; i < monsters.size(); i++) {
            MonsterButton button = monsters.get(i);
            button.setPosition(Constants.SCREEN_WIDTH * (i + 0.5f) / 7,
                    buyButton.getY() - button.getOffset().getY() * 2);
        }
    }

    private void initializeTowers() {
        towers.add(new TowerButton(CrossTower.image, new Factory<Tower>() {
            @Override
            public Tower get() {
                return new CrossTower();
            }
        }));
        towers.add(new TowerButton(SquareTower.image, new Factory<Tower>() {
            @Override
            public Tower get() {
                return new SquareTower();
            }
        }));
        towers.add(new TowerButton(StarTower.image, new Factory<Tower>() {
            @Override
            public Tower get() {
                return new StarTower();
            }
        }));
        for (int i = 0; i < towers.size(); i++) {
            TowerButton button = towers.get(i);
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
            monsterQueue.offer(m);
            MonsterImageButton mb = new MonsterImageButton(m.getImage(), m);
            mb.setPosition(((Constants.SCREEN_WIDTH / 18) * (monsterImageQueue.size() + 0.5f)), (Constants.SCREEN_HEIGHT / 7) * 4);
            addEntity(mb);
            monsterImageQueue.add(mb);
        }
    }

    public void clickMonsterImage(MonsterImageButton mb) {
        System.out.println("clicked monster image");
        attackerMoney += mb.getMonster().getCost();
        // Maybe only need one list...
        monsterQueue.remove(mb.getMonster());
        mb.die();
        monsterImageQueue.remove(mb);
        for (int i = 0; i < monsterImageQueue.size(); i++){
            monsterImageQueue.get(i).setPosition(((Constants.SCREEN_WIDTH / 18) * (i + 0.5f)), (Constants.SCREEN_HEIGHT / 7) * 4);
        }
    }

    public void monsterDied(Monster m) {
        defenderMoney += m.getCost();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        /*if (round == Round.MONSTER){
            for (int i = 0; i < monsterImageQueue.size(); i++){
                monsterImageQueue.get(i).draw(canvas);
            }
        }*/
        canvas.drawText("Attacker Cash: " + Integer.toString(attackerMoney), (Constants.SCREEN_WIDTH / 7), (Constants.SCREEN_HEIGHT / 7) * 6.1f, p);
        canvas.drawText("Defender Moneeeyh: " + Integer.toString(defenderMoney), (Constants.SCREEN_WIDTH / 7), (Constants.SCREEN_HEIGHT / 7) * 6.3f, p);
        canvas.drawText("HP: " + Integer.toString(defenderHealth), (Constants.SCREEN_WIDTH / 7), (Constants.SCREEN_HEIGHT / 7) * 6.5f, p);
    }

    @Override
    public void update(float dt)  {
        if (round == Round.PLAY) {
            if (getMonsters().isEmpty() && monsterQueue.isEmpty()) {
                advanceRound();
            } else {
                timer += dt;
                if (timer > 0.5f) {
                    addEntity(monsterQueue.poll());
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
        for (TowerButton button : towers) {
            addEntity(button);
        }
    }

    private void displayMonstersToChoose() {
        for (MonsterButton button : monsters) {
            addEntity(button);
        }
    }
    private void hideTowersToBuy() {
        for (TowerButton button : towers) {
            removeEntity(button);
        }
    }

    private void hideMonstersToChoose() {
        for (MonsterButton button : monsters) {
            removeEntity(button);
        }
    }

    private void upgradeTower(BuildTile tile) {
        Tower t = tile.getTower();
        if (t != null && defenderMoney >= t.getNextUpgradeCost()) {
            defenderMoney -= t.getNextUpgradeCost();
            tile.setTower(t.upgrade());
            System.out.println("Upgrading tower");
        }
    }

    public void setAction(Action action) {
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
            return;
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
    }

    public void loseHealth(int h) {
        System.out.println("losing health");
        this.defenderHealth -= h;
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