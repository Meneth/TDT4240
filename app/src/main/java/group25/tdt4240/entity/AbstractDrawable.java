package group25.tdt4240.entity;

import android.graphics.Canvas;

import group25.tdt4240.state.SuperState;

/**
 * Created by Meneth on 17.04.2016.
 */
public abstract class AbstractDrawable implements Drawable {
    public SuperState container;

    public void setContainer(SuperState state) {
        container = state;
    }

    public SuperState getContainer() {
        return container;
    }
}
