package group25.tdt4240.entity.button;


import group25.tdt4240.drawable.Clickable;
import group25.tdt4240.entity.Entity;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public abstract class Button extends Entity implements Clickable {
    public Button(Image image) {
        super(image);
    }

    public int getPriority() {
        return 20;
    }
}
