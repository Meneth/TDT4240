package group25.tdt4240.state;

import group25.tdt4240.utility.Constants;
import group25.tdt4240.utility.TextDrawer;
import group25.tdt4240.entity.button.BackButton;
import group25.tdt4240.entity.button.Button;

/**
 * Created by Meneth on 2016-04-18.
 */
public class GameOverState extends SuperState {

    public GameOverState() {
        Button backButton = new BackButton();
        backButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8) * 6);
        addEntity(backButton);
        addEntity(new TextDrawer("Game over!\n The tower player did not build a wall tall enough!",
                Constants.SCREEN_WIDTH/2, (Constants.SCREEN_HEIGHT / 8)*2));
    }
}
