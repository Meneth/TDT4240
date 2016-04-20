package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.state.PlayState;
import sheep.graphics.Image;

/**
 * Created by Ole on 11/04/2016.
 */
public class UpgradeButton extends ToggleButton {
     public UpgradeButton(Image image){
        super(image);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (checkClick(event)){
            ((PlayState) getContainer()).setAction(PlayState.Action.UPGRADE);
            System.out.println("upgrade_button clicked");
            return true;
        }
        return false;
    }
}