package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.R;
import group25.tdt4240.state.PlayState;
import sheep.graphics.Image;

/**
 * Created by Ole on 11/04/2016.
 */
public class BuyButton extends Button{

    public BuyButton(Image image){
        super(image);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (checkClick(event)) {
            System.out.println("buy_button clicked");
            ((PlayState)getContainer()).displayTowersToBuy();
            return true;
        }
        return false;
    }


}
