package group25.tdt4240.entity.button;

import android.view.MotionEvent;


import group25.tdt4240.entity.Clickable;
import group25.tdt4240.entity.Entity;
import group25.tdt4240.state.PlayState;
import group25.tdt4240.state.SuperState;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public abstract class Button extends Entity implements Clickable {
    public Button(Image image) {
        super(image);
    }

    public boolean checkClick(Button btn, Image image, float clickX, float clickY){
        if (clickX>=(btn.getX()-image.getWidth()/2) && clickX<=(btn.getX()+image.getWidth()/2)
                && clickY>=(btn.getY()-image.getHeight()/2) && clickY<=(btn.getY()+image.getHeight()/2)) {
            return true;
        }
        return false;
    }
}
