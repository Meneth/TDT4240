package group25.tdt4240.entity.button;

import android.view.MotionEvent;
import group25.tdt4240.R;
import group25.tdt4240.entity.factory.TowerFactory;
import group25.tdt4240.entity.tower.CrossTower;
import group25.tdt4240.entity.tower.Tower;
import group25.tdt4240.state.PlayState;
import sheep.graphics.Image;

/**
 * Created by matias on 18.04.16.
 */
public class TowerButton extends Button {
    public static Image towerButtonImage = new Image(R.drawable.cross_tower);
    private final TowerFactory factory;

    public TowerButton(Image image, TowerFactory factory) {
        super(image);
        this.factory = factory;
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (checkClick(event)){
            ((PlayState)getContainer()).selectTower(new CrossTower());
            System.out.println("buy_Tower_button_clicked");
            return true;
        }
        return false;
    }

    public Tower getTower() {
        return factory.getTower();
    }

    @Override
    public int getPriority(){
        return 21;
    }

}


