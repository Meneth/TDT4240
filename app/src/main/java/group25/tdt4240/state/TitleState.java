package group25.tdt4240.state;

import group25.tdt4240.entity.Button;
import sheep.game.State;

/**
 * Created by Meneth on 2016-03-31.
 */
public class TitleState extends State {

    public TitleState(){
        Button playButton = new Button();
        Button settingsButton = new Button();
        Button aboutButton = new Button();
    }

}
