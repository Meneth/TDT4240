package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.R;
import group25.tdt4240.state.PlayState;
import sheep.graphics.Image;

/**
 * Created by Ole on 11/04/2016.
 */
public class BuyButton extends Button{
    private boolean active;

    public BuyButton(Image image){
        super(image);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (checkClick(event)) {
            System.out.println("buy_button clicked");
            active = !active;
            ((PlayState) getContainer()).setBuying(active);
            // TODO - Hide towers if inactive
            ((PlayState) getContainer()).displayTowersToBuy();
            return true;
        }
        return false;
    }


}
