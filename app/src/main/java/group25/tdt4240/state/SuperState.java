package group25.tdt4240.state;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import group25.tdt4240.drawable.Clickable;
import group25.tdt4240.drawable.Drawable;
import group25.tdt4240.entity.monster.Monster;
import sheep.game.State;
import sheep.input.TouchListener;

/**
 * Created by Meneth on 2016-04-04.
 */
public class SuperState extends State {
    private final List<Clickable> clickableEntities = new ArrayList<>();
    private final List<Monster> shootableMonsters = new ArrayList<>();
    private final List<Drawable> entities = new ArrayList<>();

    private final Stack<Drawable> entitiesToRemove = new Stack<>();
    private final Stack<Drawable> entitiesToAdd = new Stack<>();

    public SuperState() {
        this.addTouchListener(new TouchListener() {
            @Override
            public boolean onTouchDown(MotionEvent motionEvent) {
                for (Clickable entity : new ArrayList<>(clickableEntities)) {
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
        updateEntityLists();
        for (Drawable entity : new ArrayList<>(entities))
            entity.update(dt);
    }

    public List<Monster> getMonsters() {
        return shootableMonsters;
    }

    public void addEntities(Drawable... entities) {
        for (Drawable entity : entities) {
            addEntity(entity);
        }
    }

    public void addEntity(Drawable entity) {
        if (entity == null)
            return;
        entity.setContainer(this);
        entitiesToAdd.push(entity);
    }

    private void updateEntityLists() {
        while (!entitiesToRemove.empty()) {
            Drawable e = entitiesToRemove.pop();
            entities.remove(e);
            clickableEntities.remove(e);
            shootableMonsters.remove(e);
        }
        while (!entitiesToAdd.empty()) {
            Drawable entity = entitiesToAdd.pop();
            entities.add(entity);
            if (entity instanceof Clickable)
                clickableEntities.add((Clickable) entity);
            else if (entity instanceof Monster)
                shootableMonsters.add((Monster) entity);
        }
        Collections.sort(entities, Collections.reverseOrder());
        Collections.sort(clickableEntities);
    }

    public void removeEntity(Drawable entity) {
        entitiesToRemove.push(entity);
    }

    public void removeEntities(Drawable... entities) {
        for (Drawable entity : entities) {
            removeEntity(entity);
        }
    }
}
