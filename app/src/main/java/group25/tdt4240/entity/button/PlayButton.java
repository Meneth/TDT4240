package group25.tdt4240.entity.button;

import android.view.MotionEvent;
import group25.tdt4240.state.PlayState;
import group25.tdt4240.state.TitleState;
import sheep.graphics.Image;

/**
 * Created by Ole on 11/04/2016.
 */
public class PlayButton extends Button {
    TitleState state;

    public PlayButton(Image image, TitleState state){
        super(image);
        this.state = state;
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        float clickY = event.getY();
        float clickX = event.getX();
        if (this.checkClick(clickX, clickY)) {
            state.getGame().popState();
            state.getGame().pushState(new PlayState());
            System.out.println("Play clicked");
            return true;
        }
        return false;
    }

    @Override
    public int getPriority() {
        return 10;
    }
}