package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.R;
import group25.tdt4240.state.PlayState;
import group25.tdt4240.state.TitleState;
import group25.tdt4240.state.SettingsState;
import sheep.graphics.Image;

/**
 * Created by Ole on 11/04/2016.
 */
public class SettingsButton extends Button {
    public static final Image image = new Image(R.drawable.settings_button);

    public SettingsButton(){
        super(SettingsButton.image);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (this.checkClick(event)) {
            getContainer().getGame().pushState(new SettingsState());
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
