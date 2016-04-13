package group25.tdt4240.entity.button;

/**
 * Created by DagErik on 11.04.2016.
 */
import android.view.MotionEvent;

import group25.tdt4240.R;
import group25.tdt4240.state.TitleState;
import group25.tdt4240.state.SettingsState;
import sheep.graphics.Image;

public class BackButton extends Button {

    public static final Image image = new Image(R.drawable.back_button);
    private SettingsState state;

    public BackButton(SettingsState state){
        super(BackButton.image);
        this.state = state;
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        float clickY = event.getY();
        float clickX = event.getX();
        if (this.checkClick(clickX, clickY)) {
            state.getGame().popState();
            state.getGame().pushState(new TitleState());
            System.out.println("Return clicked");
            return true;
        }
        return false;
    }

    @Override
    public int getPriority() {
        return 10;
    }
}
