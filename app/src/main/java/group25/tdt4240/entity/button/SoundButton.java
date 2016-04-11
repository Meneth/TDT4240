package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.state.TitleState;
import sheep.graphics.Image;
import group25.tdt4240.state.SettingsState;

/**
 * Created by DagErik on 11.04.2016.
 */
public class SoundButton extends Button {
    SettingsState state;

    public SoundButton(Image image, SettingsState state){
        super(image);
        this.state = state;
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        float clickY = event.getY();
        float clickX = event.getX();
        if (this.checkClick(clickX, clickY)) {
            //TODO: TOGGLE SOUND
            System.out.println("Sound clicked");
            return true;
        }
        return false;
    }

    @Override
    public int getPriority() {
        return 10;
    }
}
