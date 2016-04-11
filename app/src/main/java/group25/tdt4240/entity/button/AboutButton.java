package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import sheep.graphics.Image;

/**
 * Created by Ole on 11/04/2016.
 */
public class AboutButton extends Button {

    public AboutButton(Image image){
        super(image);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        return false;
    }

    @Override
    public int getPriority() {
        return 10;
    }
}
