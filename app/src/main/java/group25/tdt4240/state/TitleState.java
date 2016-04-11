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
    private Image playButtonImage = new Image(R.drawable.play_button2);
    private Image settingsButtonImage = new Image(R.drawable.play_button2);
    private Image aboutButtonImage = new Image(R.drawable.play_button2);
    Button playButton = new Button(playButtonImage);
    Button settingsButton = new Button(settingsButtonImage);
    Button aboutButton = new Button(aboutButtonImage);
    //SCREEN_HEIGHT 1776 & SCREEN_WIDTH 1080


    public TitleState() {
        playButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8)*2);
        settingsButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8)*4);
        aboutButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8)*6);
        addEntities(playButton, settingsButton, aboutButton);
    }

    private boolean checkClick(Button btn, Image image, float clickX, float clickY){
        if (clickX>=(btn.getX()-image.getWidth()/2) && clickX<=(btn.getX()+image.getWidth()/2)
                && clickY>=(btn.getY()-image.getHeight()/2) && clickY<=(btn.getY()+image.getHeight()/2)) {
            return true;
        }
        return false;
        }

    public boolean onTouchUp(MotionEvent event) {
        float clickY = event.getY();
        float clickX = event.getX();
        if (checkClick(playButton, playButtonImage, clickX, clickY)) {
            getGame().popState();
            getGame().pushState(new PlayState());
            System.out.println("Play clicked");
            return true;
        }
        if (checkClick(settingsButton, settingsButtonImage, clickX, clickY)) {
            getGame().popState();
            getGame().pushState(new SettingsState());
            System.out.println("Settings clicked");
            return true;
        }
        if (checkClick(aboutButton, aboutButtonImage, clickX, clickY)) {
            getGame().popState();
            getGame().pushState(new SettingsState());
            System.out.println("About clicked");
            return true;
        }
        return false;
    }
}