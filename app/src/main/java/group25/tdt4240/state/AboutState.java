package group25.tdt4240.state;

import group25.tdt4240.Constants;
import group25.tdt4240.TextDrawer;
import group25.tdt4240.entity.button.BackButton;
import group25.tdt4240.entity.button.Button;

/**
 * Created by mariusbang on 15/04/16.
 */
public class AboutState extends SuperState {

    Button backButton = new BackButton(this);
    TextDrawer textDrawer = new TextDrawer("Music by www.bensound.com", Constants.SCREEN_WIDTH/2, (Constants.SCREEN_HEIGHT / 8)*4);

    public AboutState() {
        backButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8) * 6);
        addEntities(backButton, textDrawer);
    }

}
