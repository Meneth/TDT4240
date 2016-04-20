package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.utility.Constants;
import group25.tdt4240.factory.Factory;
import group25.tdt4240.entity.tower.Tower;
import group25.tdt4240.state.PlayState;
import sheep.graphics.Image;

/**
 * Created by matias on 18.04.16.
 */
public class TowerButton extends ToggleButton {
    private final Factory<Tower> factory;
    private final Tower tower;

    public TowerButton(Image image, Factory<Tower> factory) {
        super(image);
        this.factory = factory;
        this.tower = factory.get();
        float scaleX = 1.25f * Constants.TILE_WIDTH / image.getWidth();
        float scaleY = 1.25f * Constants.TILE_HEIGHT / image.getHeight();
        setScale(scaleX, scaleY);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (checkClick(event)){
            ((PlayState)getContainer()).selectTower(this);
            System.out.println("buy_Tower_button_clicked");
            return true;
        }
        return false;
    }

    public Tower getTower() {
        return factory.get();
    }

    public int getCost() {
        return tower.getCost();
    }

    @Override
    public int getPriority(){
        return 21;
    }

}


