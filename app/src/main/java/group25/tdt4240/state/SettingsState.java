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
    private Image returnButtonImage = new Image(R.drawable.play_button2);
    Button soundButton = new SoundButton(soundButtonImage, this);
    Button returnButton = new ReturnButton(returnButtonImage, this);

    public SettingsState() {
        soundButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8)*2);
        returnButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8)*4);
        addEntities(returnButton, soundButton);
    }


    // Add sound-functionality

}
