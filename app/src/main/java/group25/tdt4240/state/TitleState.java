package group25.tdt4240.state;

import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import group25.tdt4240.R;
import group25.tdt4240.entity.Button;
import sheep.graphics.Image;
import sheep.game.State;
import sheep.input.TouchListener;

/**
 * Created by Meneth on 2016-03-31.
 */
public class TitleState extends SuperState implements TouchListener{
    private Image playButtonImage = new Image(R.drawable.playbutton);
    private Image settingsButtonImage = new Image(R.drawable.playbutton);
    private Image aboutButtonImage = new Image(R.drawable.playbutton);
    Button playButton = new Button(playButtonImage);
    Button settingsButton = new Button(settingsButtonImage);
    Button aboutButton = new Button(aboutButtonImage);


    public TitleState(){
        playButton.setScale(0.3f, 0.4f);
        //settingsButton.setScale(0.3f, 0.4f);
        playButton.setPosition(1000, 1000);
        //settingsButton.setPosition(500, 1);
        //aboutButton.setPosition(1, 1);
        addEntities(playButton, settingsButton, aboutButton);
    }

    public boolean onTouchUp(MotionEvent event){
        float clickY = event.getY();
        float clickX = event.getX();
        if (playButton.getBoundingBox().contains(clickX, clickY)){
            getGame().popState();
            getGame().pushState(new PlayState());
            System.out.println("Play clicked");
            return true;
        }
        if (settingsButton.getBoundingBox().contains(clickX, clickY)){
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

    public void update(float dt){
        super.update(dt);
        // TODO - Title updating
    }

    public void draw(Canvas canvas) {
        playButton.draw(canvas);
        //settingsButton.draw(canvas);
    }
}