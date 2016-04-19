package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.state.PlayState;
import sheep.graphics.Image;

/**
 * Created by Ole on 11/04/2016.
 */
public class SellButton extends Button {
    private boolean active;

    public SellButton(Image image){
        super(image);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (checkClick(event)){
            active = !active;
            ((PlayState) getContainer()).setSelling(active);
            System.out.println("sell_button clicked");
            return true;
        }
        return false;
    }


}
