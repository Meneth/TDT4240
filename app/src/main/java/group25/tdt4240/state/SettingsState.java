package group25.tdt4240.state;

import android.graphics.Canvas;
import android.view.MotionEvent;

import group25.tdt4240.Constants;
import group25.tdt4240.R;
import group25.tdt4240.entity.Button;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public class SettingsState extends SuperState {
    private Image soundButtonImage = new Image(R.drawable.play_button2);
    private Image returnButtonImage = new Image(R.drawable.play_button2);
    Button soundButton = new Button(soundButtonImage);
    Button returnButton = new Button(returnButtonImage);

    public SettingsState() {
        soundButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8)*2);
        returnButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8)*4);
        addEntities(returnButton, soundButton);
    }

    // Add sound-functionality

    public boolean onTouchUp(MotionEvent event) {
        float clickY = event.getY();
        float clickX = event.getX();
        if (returnButton.getBoundingBox().contains(clickX, clickY)) {
            getGame().popState();
            getGame().pushState(new TitleState());
            return true;
        }
        return false;
    }
}
