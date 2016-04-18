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
    SettingsState state;
    public static final Image soundButtonImageOn = new Image(R.drawable.sound_button_on);
    public static final Image soundButtonImageOff = new Image(R.drawable.sound_button_off);
    public static Boolean soundOn;
    public static Image soundButtonImage;

    public SoundButton(SettingsState state){
        super(SoundButton.soundButtonImageOn);
        if (SoundButton.soundOn == null) {
            SoundButton.soundOn = true;
        }
        this.updateImage();
        this.state = state;
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (this.checkClick(event)) {
            System.out.println("Sound clicked");
            Context c = state.getGame().getContext();
            TDActivity a = (TDActivity) c;
            a.setSound();
            SoundButton.soundOn = !SoundButton.soundOn;
            updateImage();
            return true;
        }
        return false;
    }

    public void updateImage() {
        SoundButton.soundButtonImage = SoundButton.soundOn ? soundButtonImageOn : soundButtonImageOff;
        this.setView(SoundButton.soundButtonImage);
    }

    @Override
    public int getPriority() {
        return 10;
    }
}
