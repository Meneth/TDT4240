package group25.tdt4240.state;

import group25.tdt4240.Constants;
import group25.tdt4240.R;
import group25.tdt4240.entity.button.*;
import sheep.graphics.Image;
import sheep.input.TouchListener;

/**
 * Created by Meneth on 2016-03-31.
 */
public class TitleState extends SuperState implements TouchListener {
    private Image playButtonImage = new Image(R.drawable.play_button);
    private Image settingsButtonImage = new Image(R.drawable.settings_button);
    private Image aboutButtonImage = new Image(R.drawable.about_button2);
    Button playButton = new PlayButton(playButtonImage, this);
    Button settingsButton = new SettingsButton(settingsButtonImage, this);
    Button aboutButton = new AboutButton(aboutButtonImage, this);
    //SCREEN_HEIGHT 1776 & SCREEN_WIDTH 1080


    public TitleState() {
        playButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8) * 2);
        settingsButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8) * 4);
        aboutButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8) * 6);
        addEntities(playButton, settingsButton, aboutButton);
    }

    /*
    public boolean onTouchUp(MotionEvent event) {
        return false;
    }
    */
}