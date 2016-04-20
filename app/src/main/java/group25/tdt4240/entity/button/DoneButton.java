package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.R;
import group25.tdt4240.state.PlayState;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-04-20.
 */
public class DoneButton extends Button {
    public static Image image = new Image(R.drawable.back_button); // TODO - Actual image

    public DoneButton() {
        super(image);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (this.checkClick(event)) {
            ((PlayState) getContainer()).advanceRound();
            System.out.println("Done clicked");
            return true;
        }
        return false;
    }
}
