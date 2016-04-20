package group25.tdt4240.state;

import group25.tdt4240.utility.Constants;
import group25.tdt4240.entity.button.*;
import sheep.input.TouchListener;

/**
 * Created by Meneth on 2016-03-31.
 */
public class TitleState extends SuperState implements TouchListener {


    public TitleState() {
        Button playButton = new PlayButton();
        playButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8) * 2);
        Button settingsButton = new SettingsButton();
        settingsButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8) * 4);
        Button aboutButton = new AboutButton();
        aboutButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8) * 6);
        addEntities(playButton, settingsButton, aboutButton);
    }

    /*
    public boolean onTouchUp(MotionEvent event) {
        return false;
    }
    */
}