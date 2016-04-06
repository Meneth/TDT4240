package group25.tdt4240.state;

import android.graphics.Canvas;
import android.view.MotionEvent;

import group25.tdt4240.R;
import group25.tdt4240.entity.Button;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public class SettingsState extends SuperState {
    private Image returnButtonImage = new Image(R.drawable.play_button);
    Button returnButton = new Button(returnButtonImage);

    public SettingsState() {
        returnButton.setPosition(1, 1);
        addEntities(returnButton);
    }

    // Add toggle sound-functionality

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

    public void update(float dt) {
        super.update(dt);
    }

    public void draw(Canvas canvas) {
        //Draw buttons
        returnButton.draw(canvas);
    }
}
