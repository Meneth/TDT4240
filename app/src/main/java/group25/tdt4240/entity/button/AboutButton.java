package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.R;
import group25.tdt4240.state.TitleState;
import group25.tdt4240.state.SettingsState;
import sheep.graphics.Image;

/**
 * Created by Ole on 11/04/2016.
 */
public class AboutButton extends Button {

    public static final Image image = new Image(R.drawable.about_button);
    private TitleState state;

    public AboutButton(TitleState state){
        super(AboutButton.image);
        this.state = state;
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        float clickY = event.getY();
        float clickX = event.getX();
        if (this.checkClick(clickX, clickY)) {
            state.getGame().popState();
            state.getGame().pushState(new SettingsState());
            System.out.println("About clicked");
            return true;
        }
        return false;
    }

    @Override
    public int getPriority() {
        return 10;
    }
}
