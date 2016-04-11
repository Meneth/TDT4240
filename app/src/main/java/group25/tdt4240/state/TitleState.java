package group25.tdt4240.state;

import android.view.MotionEvent;

import group25.tdt4240.Constants;
import group25.tdt4240.R;
import group25.tdt4240.entity.button.Button;
import sheep.graphics.Image;
import sheep.input.TouchListener;

/**
 * Created by Meneth on 2016-03-31.
 */
public class TitleState extends SuperState implements TouchListener {
    private Image playButtonImage = new Image(R.drawable.play_button);
    private Image settingsButtonImage = new Image(R.drawable.play_button);
    private Image aboutButtonImage = new Image(R.drawable.play_button);
    Button playButton = new Button(playButtonImage);
    Button settingsButton = new Button(settingsButtonImage);
    Button aboutButton = new Button(aboutButtonImage);


    public TitleState() {
        //settingsButton.setScale(0.3f, 0.4f);
        playButton.setPosition(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT / 2);
        playButton.setScale(0.3f, 0.3f);
        //settingsButton.setPosition(500, 1);
        //aboutButton.setPosition(1, 1);
        addEntities(playButton, settingsButton, aboutButton);
    }

    public boolean onTouchUp(MotionEvent event) {
        float clickY = event.getY();
        float clickX = event.getX();
        if (playButton.getBoundingBox().contains(clickX, clickY)) {
            getGame().popState();
            getGame().pushState(new PlayState());
            System.out.println("Play clicked");
            return true;
        }
        if (settingsButton.getBoundingBox().contains(clickX, clickY)) {
            getGame().popState();
            getGame().pushState(new SettingsState());
            System.out.println("Settings clicked");
            return true;
        }
        /*if (aboutButton.getBoundingBox().contains(clickX, clickY)){
            getGame().popState();
            getGame().pushState(new TitleState());
            return true;
        }*/
        return false;
    }
}