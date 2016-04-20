package group25.tdt4240.entity.button;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import sheep.graphics.Image;

/**
 * Created by Ole on 20/04/2016.
 */
public abstract class ToggleButton extends Button {
    private final Image image;
    private float left, right, top, bot;
    private final Paint p;

    public ToggleButton(Image image){
        super(image);
        this.image = image;

        p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(7);
        p.setColor(Color.WHITE);
    }
    private boolean active = false;

    public void toggleButton() {
        float width = this.image.getWidth() * getScale().getX();
        float height = this.image.getHeight() * getScale().getY();
        left = this.getX()- width /2;
        right = this.getX()+ width /2;
        top = this.getY()- height /2;
        bot = this.getY()+ height /2;
        this.active = !this.active;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (active){
            canvas.drawRect(left,top,right,bot, p);
        }
    }
}
