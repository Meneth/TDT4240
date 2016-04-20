package group25.tdt4240.entity.tile;

import group25.tdt4240.utility.Constants;
import group25.tdt4240.entity.Entity;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public class Tile extends Entity {

    /**
     * @param image The image the sprite is to be generated from
     */
    public Tile(Image image, float x, float y) {
        super(image);
        float scaleX = (float) Constants.TILE_WIDTH / image.getWidth();
        float scaleY = (float) Constants.TILE_HEIGHT / image.getHeight();
        setScale(scaleX, scaleY);
        setPosition((x + 0.5f) * (Constants.TILE_WIDTH + 1), (y + 0.5f) * (Constants.TILE_HEIGHT + 1));
    }

    public int getPriority() {
        return 0;
    }
}
