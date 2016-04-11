package group25.tdt4240.state;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import group25.tdt4240.entity.Clickable;
import group25.tdt4240.entity.Drawable;
import sheep.game.State;
import sheep.input.TouchListener;

/**
 * Created by Meneth on 2016-04-04.
 */
public class SuperState extends State {
    private PriorityQueue<Clickable> clickableEntities = new PriorityQueue<>();
    private PriorityQueue<Drawable> entities = new PriorityQueue<>();

    public SuperState() {
        this.addTouchListener(new TouchListener() {
            @Override
            public boolean onTouchDown(MotionEvent motionEvent) {
                for (Clickable entity : clickableEntities) {
                    if (entity.onTouchDown(motionEvent))
                        return true; // Event consumed
                }
                return false;
            }

            @Override
            public boolean onTouchUp(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onTouchMove(MotionEvent motionEvent) {
                return false;
            }
        });
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        for (Drawable entity : entities)
            entity.draw(canvas);
    }

    @Override
    public void update(float dt) {
        for (Drawable entity : entities)
            entity.update(dt);
    }

    public void addEntities(Drawable... entities) {
        for (Drawable entity : entities) {
            addEntity(entity);
        }
    }

    public void addEntity(Drawable entity) {
        entities.add(entity);
        if (entity instanceof Clickable)
            clickableEntities.add((Clickable) entity);
    }
}
