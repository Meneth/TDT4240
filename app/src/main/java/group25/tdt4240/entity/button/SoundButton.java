package group25.tdt4240.entity.button;

import android.content.Context;
import android.view.MotionEvent;

import group25.tdt4240.R;
import group25.tdt4240.TDActivity;
import sheep.graphics.Image;
import group25.tdt4240.state.SettingsState;

/**
 * Created by DagErik on 11.04.2016.
 */
public class SoundButton extends Button {
    private static final Image soundButtonImageOn = new Image(R.drawable.sound_button_on);
    private static final Image soundButtonImageOff = new Image(R.drawable.sound_button_off);
    private static Boolean soundOn;

    public SoundButton(){
        super(SoundButton.soundButtonImageOn);
        if (SoundButton.soundOn == null) {
            SoundButton.soundOn = true;
        }
        this.updateImage();
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (this.checkClick(event)) {
            System.out.println("Sound clicked");
            Context c = getContainer().getGame().getContext();
            TDActivity a = (TDActivity) c;
            a.setSound();
            SoundButton.soundOn = !SoundButton.soundOn;
            updateImage();
            return true;
        }
        return false;
    }

    public void updateImage() {
        this.setView(SoundButton.soundOn ? soundButtonImageOn : soundButtonImageOff);
    }
}
