package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.R;
import group25.tdt4240.state.PlayState;
import sheep.graphics.Image;

/**
 * Created by Ole on 11/04/2016.
 */
public class PlayButton extends Button {
    private static final Image image = new Image(R.drawable.play_button);

    public PlayButton() {
        super(PlayButton.image);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (this.checkClick(event)) {
            getContainer().getGame().pushState(new PlayState());
            System.out.println("Play clicked");
            return true;
        }
        return false;
    }

}
