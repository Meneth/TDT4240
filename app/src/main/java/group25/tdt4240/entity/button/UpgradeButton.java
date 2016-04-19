package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.state.PlayState;
import sheep.graphics.Image;

/**
 * Created by Ole on 11/04/2016.
 */
public class UpgradeButton extends Button{
     public UpgradeButton(Image image){
        super(image);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (checkClick(event)){
            ((PlayState) getContainer()).setUpgrading(!((PlayState) getContainer()).isUpgrading());
            ((PlayState) getContainer()).setBuying(false);
            ((PlayState) getContainer()).setSelling(false);
            return true;
        }
        return false;
    }

    @Override
    public int getPriority() {
        return 10;
    }
}
