package group25.tdt4240;


import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import group25.tdt4240.state.TitleState;
import sheep.game.*;

public class TDActivity extends Activity {
    private Game game;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create the game.
        Game game = new Game(this, null);
        // Push the main state.
        game.pushState(new TitleState());
        // View the game.
        setContentView(game);
    }
}
