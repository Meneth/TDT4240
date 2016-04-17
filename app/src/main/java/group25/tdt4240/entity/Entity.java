package group25.tdt4240.entity;

import android.graphics.Canvas;

import group25.tdt4240.state.SuperState;
import sheep.game.Sprite;
import sheep.game.State;
import sheep.graphics.Image;
import sheep.math.Vector2;

/**
 * Created by Meneth on 2016-03-31.
 */


public abstract class Entity extends Sprite implements Drawable {
    private final Image image;
    private SuperState container;

    /**
     * @param image The image the sprite is to be generated from
     */
    public Entity(Image image) {
        super(image);
        this.image = image;
    }

    @Override
    public int compareTo(Drawable another) {
        return another.getPriority() - getPriority();
    }

    public boolean checkClick(float clickX, float clickY){
        if (clickX>=(this.getX()-image.getWidth()/2)
                && clickX<=(this.getX()+image.getWidth()/2)
                && clickY>=(this.getY()-image.getHeight()/2)
                && clickY<=(this.getY()+image.getHeight()/2)) {
            return true;
        }
        return false;
    }

    @Override
    public void die() {
        if (container != null)
            container.removeEntity(this);
    }

    public void setContainer(SuperState container) {
        this.container = container;
    }

    public SuperState getContainer() {
        return container;
    }
}
