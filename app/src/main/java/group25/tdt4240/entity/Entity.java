package group25.tdt4240.entity;

import android.graphics.Canvas;

import sheep.game.Sprite;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */


public abstract class Entity extends Sprite implements Drawable {
    private final Image image;
    
    /**
     *
     * @param image The image the sprite is to be generated from
     */
    public Entity(Image image) {
        super(image);
        this.image = image;
    }

    /**
     *
     * @param canvas Current canvas
     */
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        // TODO - Possibly add something here
    }

    /**
     *
     * @param dt
     */
    @Override
    public void update(float dt) {
        super.update(dt);
        // TODO - Update logic?
    }
}
