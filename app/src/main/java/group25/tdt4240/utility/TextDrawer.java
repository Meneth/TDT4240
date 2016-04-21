package group25.tdt4240.utility;

import android.graphics.Canvas;
import android.graphics.Paint;

import group25.tdt4240.entity.AbstractDrawable;
import group25.tdt4240.entity.Drawable;

/**
 * Created by mariusbang on 15/04/16.
 */
public class TextDrawer extends AbstractDrawable {
    //private Canvas canvas;
    private final Paint paint = new Paint();
    private final String string;
    private final float xPos;
    private final float yPos;

    public TextDrawer(String string, float xPos, float yPos) {
        //this.canvas = new Canvas();
        this.string = string;
        this.xPos = xPos;
        this.yPos = yPos;
        paint.setARGB(255, 255, 255, 255);
        paint.setTextSize(30.0f);
        paint.setTextAlign(Paint.Align.CENTER);
    }


    /*public void draw(String string, float xPos, float yPos) {
        canvas.drawText(string, xPos, yPos, paint);
    }*/


    @Override
    public void draw(Canvas canvas) {
        canvas.drawText(string, xPos, yPos, paint);
    }

    @Override
    public void update(float dt) {
    }

    @Override
    public int getPriority() {
        return 10;
    }

    @Override
    public int compareTo(Drawable another) {
        return another.getPriority() - getPriority();
    }
}
