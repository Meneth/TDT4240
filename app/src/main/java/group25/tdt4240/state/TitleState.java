package group25.tdt4240.state;

import android.graphics.Canvas;
import group25.tdt4240.entity.Button;
import sheep.graphics.Image;
import sheep.game.State;
import sheep.input.TouchListener;

/**
 * Created by Meneth on 2016-03-31.
 */
public class TitleState extends State implements TouchListener{
    private Image playButtonImage = new Image();
    private Image settingsButtonImage = new Image();
    private Image aboutButtonImage = new Image();
    Button playButton = new Button(playButtonImage);
    Button settingsButton = new Button(settingsButtonImage);
    Button aboutButton = new Button(aboutButtonImage);

    public TitleState(){
        playButton.setPosition(1,1);
        settingsButton.setPosition(1,1);
        aboutButton.setPosition(1,1);
    }

    public void draw(Canvas canvas){
        playButton.draw(canvas);
        settingsButton.draw(canvas);
        aboutButton.draw(canvas);
    }

    public void update(float dt){

    }
}