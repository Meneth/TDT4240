package group25.tdt4240.entity;

import android.support.annotation.NonNull;
import android.view.MotionEvent;
import group25.tdt4240.state.SuperState;
import sheep.game.Sprite;
import sheep.graphics.Image;
import sheep.math.Vector2;

/**
 * Created by Meneth on 2016-03-31.
 */


public abstract class Entity extends Sprite implements Drawable {
    private final Image image;
    private SuperState container;
    private boolean destroyed = false;

    /**
     * @param image The image the sprite is to be generated from
     */
    public Entity(Image image) {
        super(image);
        this.image = image;
    }

    @Override
    public int compareTo(@NonNull Drawable another) {
        return another.getPriority() - getPriority();
    }

    public boolean checkClick(MotionEvent event){
        float clickX = event.getX();
        float clickY = event.getY();
        float width = image.getWidth() * getScale().getX();
        float height = image.getHeight() * getScale().getY();
        return clickX >= (this.getX() - width / 2)
                && clickX <= (this.getX() + width / 2)
                && clickY >= (this.getY() - height / 2)
                && clickY <= (this.getY() + height / 2);
    }

    @Override
    public void die() {
        destroyed = true;
        if (container != null)
            container.removeEntity(this);
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setContainer(SuperState container) {
        this.container = container;
        destroyed = false;
    }

    public SuperState getContainer() {
        return container;
    }

    public float getDistance(Entity other) {
        return getPosition().getSubtracted(other.getPosition()).getLength();
    }

    @Override
    public void setScale(Vector2 scale) {
        super.setScale(scale);
        setOffset(scale.getX() * image.getWidth() / 2, scale.getY() * image.getHeight() / 2);
    }

    @Override
    public void setScale(float sx, float sy) {
        setScale(new Vector2(sx, sy));
    }
}
