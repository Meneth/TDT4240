package group25.tdt4240.entity.button;

/**
 * Created by DagErik on 11.04.2016.
 */

import android.view.MotionEvent;

import group25.tdt4240.R;
import sheep.graphics.Image;

public class BackButton extends Button {
    private static final Image image = new Image(R.drawable.back_button);

    public BackButton() {
        super(BackButton.image);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (this.checkClick(event)) {
            getContainer().getGame().popState();
            System.out.println("Return clicked");
            return true;
        }
        return false;
    }
}
