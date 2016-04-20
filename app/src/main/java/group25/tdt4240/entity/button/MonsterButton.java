package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.entity.monster.Monster;
import group25.tdt4240.entity.tower.Tower;
import group25.tdt4240.factory.Factory;
import group25.tdt4240.state.PlayState;
import group25.tdt4240.utility.Constants;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-04-20.
 */
public class MonsterButton extends Button {
    private final Factory<Monster> factory;
    private final Monster monster;

    public MonsterButton(Image image, Factory<Monster> factory) {
        super(image);
        this.factory = factory;
        this.monster = factory.get();
        float scaleX = 1.25f * (float) Constants.TILE_WIDTH / image.getWidth();
        float scaleY = 1.25f * (float) Constants.TILE_HEIGHT / image.getHeight();
        setScale(scaleX, scaleY);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (checkClick(event)){
            // TODO
            return true;
        }
        return false;
    }

    public Monster getMonster() {
        return factory.get();
    }

    public int getCost() {
        return monster.getCost();
    }

    @Override
    public int getPriority(){
        return 21;
    }
}
