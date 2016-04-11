package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.state.PlayState;
import group25.tdt4240.state.TitleState;
import group25.tdt4240.state.SettingsState;
import sheep.graphics.Image;

/**
 * Created by Ole on 11/04/2016.
 */
public class SettingsButton extends Button {
    private TitleState state;

    public SettingsButton(Image image, TitleState titleState){
        super(image);
        this.state = titleState;
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        float clickY = event.getY();
        float clickX = event.getX();
        if (this.checkClick(clickX, clickY)) {
            state.getGame().popState();
            state.getGame().pushState(new SettingsState());
            System.out.println("Settings clicked");
            return true;
        }
        return false;
    }

    @Override
    public int getPriority() {
        return 10;
    }
}
