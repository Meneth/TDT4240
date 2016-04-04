package group25.tdt4240.state;

import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import group25.tdt4240.entity.Clickable;
import group25.tdt4240.entity.Entity;
import sheep.game.Layer;
import sheep.game.State;
import sheep.game.World;
import sheep.input.TouchListener;

/**
 * Created by Meneth on 2016-04-04.
 */
public class SuperState extends State {
    private List<Clickable> clickableEntities = new ArrayList<>();

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

    public void addClickable(Clickable entity) {
        clickableEntities.add(entity);
    }
}
