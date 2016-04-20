package group25.tdt4240.state;

import group25.tdt4240.utility.Constants;
import group25.tdt4240.entity.button.*;

/**
 * Created by Meneth on 2016-03-31.
 */
public class SettingsState extends SuperState {

    public SettingsState() {
        Button soundButton = new SoundButton();
        soundButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8) * 2);
        Button backButton = new BackButton();
        backButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8) * 4);
        addEntities(backButton, soundButton);
    }
}
