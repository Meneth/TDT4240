package group25.tdt4240.state;

import android.graphics.Canvas;
import android.view.MotionEvent;
import group25.tdt4240.entity.Button;
import sheep.graphics.Image;
import sheep.game.State;
import sheep.input.TouchListener;

/**
 * Created by Meneth on 2016-03-31.
 */
public class TitleState extends SuperState implements TouchListener{
    private Image playButtonImage = new Image();
    private Image settingsButtonImage = new Image();
    private Image aboutButtonImage = new Image();
    Button playButton = new Button(playButtonImage);
    Button settingsButton = new Button(settingsButtonImage);
    Button aboutButton = new Button(aboutButtonImage);


    public TitleState(){
        playButton.setPosition(1, 1);
        settingsButton.setPosition(1, 1);
        aboutButton.setPosition(1, 1);
    }

    public void draw(Canvas canvas){
        playButton.draw(canvas);
        settingsButton.draw(canvas);
        aboutButton.draw(canvas);
    }

    public boolean onTouchUp(MotionEvent event){
        float clickY = event.getY();
        float clickX = event.getX();
        if (playButton.getBoundingBox().contains(clickX, clickY)){
            getGame().popState();
            getGame().pushState(new PlayState());
            return true;
        }
        if (settingsButton.getBoundingBox().contains(clickX, clickY)){
            getGame().popState();
            getGame().pushState(new SettingsState());
            return true;
        }
        if (aboutButton.getBoundingBox().contains(clickX, clickY)){
            getGame().popState();
            getGame().pushState(new TitleState());
            return true;
        }
        return false;
    }

    public void update(float dt){
    }
}