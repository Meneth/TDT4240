package group25.tdt4240.state;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import group25.tdt4240.entity.Clickable;
import group25.tdt4240.entity.Entity;
import sheep.game.State;
import sheep.input.TouchListener;

/**
 * Created by Meneth on 2016-04-04.
 */
public class SuperState extends State {
    private List<Clickable> clickableEntities = new ArrayList<>();
    private List<Entity> entities = new ArrayList<>();

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
    public void draw(Canvas canvas){
        for (Entity entity : entities)
            entity.draw(canvas);
    }

    @Override
    public void update(float dt){
        for (Entity entity : entities)
            entity.update(dt);
    }

    public void addEntities(Entity...entities) {
        for (Entity entity: entities) {
            addEntity(entity);
        }
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
        if (entity instanceof Clickable)
            clickableEntities.add((Clickable) entity);
    }
}
