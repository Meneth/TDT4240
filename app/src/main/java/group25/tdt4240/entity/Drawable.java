package group25.tdt4240.entity;

import android.graphics.Canvas;

/**
 * Created by Meneth on 06.04.2016.
 */
public interface Drawable extends Comparable<Drawable> {
    void draw(Canvas canvas);
    void update(float dt);

    int getPriority();
}
