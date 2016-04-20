package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.R;
import group25.tdt4240.state.PlayState;
import sheep.graphics.Image;

/**
 * Created by Ole on 11/04/2016.
 */
public class UpgradeButton extends ToggleButton {
    private static final Image image = new Image(R.drawable.upgrade_button);

    public UpgradeButton(){
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