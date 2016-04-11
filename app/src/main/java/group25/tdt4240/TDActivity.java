package group25.tdt4240;


import android.app.ActionBar;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import group25.tdt4240.state.TitleState;
import sheep.game.*;

public class TDActivity extends Activity {
    private Game game;
    private MediaPlayer mp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the game.
        Game game = new Game(this, null);
        // Push the main state.
        game.pushState(new TitleState());
        // View the game.
        setContentView(game);
        mp = MediaPlayer.create(getApplicationContext(),R.raw.sound);
        mp.start();

        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.
            ActionBar actionBar = getActionBar();
            if (actionBar != null)
                actionBar.hide();
        }
    }

    public boolean setSound(){
        if(mp.isPlaying()){
            mp.pause();
        }
        else {
            mp.start();
        }
        return false;
    }

    @Override
    protected void onDestroy(){
        if(mp!=null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
