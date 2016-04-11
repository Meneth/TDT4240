package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.state.PlayState;
import sheep.graphics.Image;

/**
 * Created by Ole on 11/04/2016.
 */
public class BuyButton extends Button{
    private PlayState state;

    public BuyButton(Image image, PlayState state){
        super(image);
        this.state = state;

    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        state.buyTower();
        return false;
    }

    @Override
    public int getPriority() {
        return 10;
    }
}
