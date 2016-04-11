package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.state.PlayState;
import sheep.graphics.Image;

/**
 * Created by Ole on 11/04/2016.
 */
public class UpgradeButton extends Button{
    private PlayState state;

    public UpgradeButton(Image image, PlayState state){
        super(image);
        this.state = state;

    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (checkClick(event.getX(),event.getY())){
            state.upgradeTower();
            return true;
        }
        return false;
    }

    @Override
    public int getPriority() {
        return 10;
    }
}
