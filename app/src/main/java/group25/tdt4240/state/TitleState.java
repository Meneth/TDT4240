package group25.tdt4240.state;

import group25.tdt4240.R;
import group25.tdt4240.entity.Entity;
import group25.tdt4240.utility.Constants;
import group25.tdt4240.entity.button.*;
import sheep.graphics.Image;
import sheep.input.TouchListener;

/**
 * Created by Meneth on 2016-03-31.
 */
public class TitleState extends SuperState implements TouchListener {
    public TitleState() {
        Entity title = new Entity(new Image(R.drawable.title)) {
            @Override
            public int getPriority() {
                return 0;
            }
        };
        title.setScale(0.5f, 0.5f);
        title.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8) * 1);
        Button playButton = new PlayButton();
        playButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8) * 2.5f);
        Button settingsButton = new SettingsButton();
        settingsButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8) * 4.5f);
        Button aboutButton = new AboutButton();
        aboutButton.setPosition(Constants.SCREEN_WIDTH / 2, (Constants.SCREEN_HEIGHT / 8) * 6.5f);
        addEntities(title, playButton, settingsButton, aboutButton);

    }
}