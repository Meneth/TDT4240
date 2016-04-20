package group25.tdt4240.state;

import group25.tdt4240.utility.Constants;
import group25.tdt4240.utility.TextDrawer;
import group25.tdt4240.entity.button.BackButton;
import group25.tdt4240.entity.button.Button;

/**
 * Created by mariusbang on 15/04/16.
 */
public class AboutState extends SuperState {
    private Button backButton = new BackButton();

    public AboutState() {
        backButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8) * 6);
        addEntity(backButton);
        addEntity(new TextDrawer("A game by Group 25", Constants.SCREEN_WIDTH/2, (Constants.SCREEN_HEIGHT / 8)*2));
        addEntity(new TextDrawer("Music by www.bensound.com", Constants.SCREEN_WIDTH/2, (Constants.SCREEN_HEIGHT / 8)*4));
    }

}
