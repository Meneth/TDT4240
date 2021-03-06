package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.R;
import group25.tdt4240.state.AboutState;
import sheep.graphics.Image;

/**
 * Created by Ole on 11/04/2016.
 */
public class AboutButton extends Button {
    private static final Image image = new Image(R.drawable.about_button);

    public AboutButton() {
        super(AboutButton.image);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (this.checkClick(event)) {
            getContainer().getGame().pushState(new AboutState());
            System.out.println("About clicked");
            return true;
        }
        return false;
    }
}
