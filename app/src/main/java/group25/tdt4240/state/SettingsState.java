package group25.tdt4240.state;

import group25.tdt4240.Constants;
import group25.tdt4240.R;
import group25.tdt4240.entity.button.*;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public class SettingsState extends SuperState {
    private Image soundButtonImage = new Image(R.drawable.play_button2);
    private Image backButtonImage = new Image(R.drawable.back_button2);
    Button soundButton = new SoundButton(soundButtonImage, this);
    Button backButton = new ReturnButton(backButtonImage, this);

    public SettingsState() {
        soundButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8)*2);
        backButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8)*4);
        addEntities(backButton, soundButton);
    }


    // Add sound-functionality

}
