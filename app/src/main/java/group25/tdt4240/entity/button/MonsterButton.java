package group25.tdt4240.entity.button;

import android.graphics.Canvas;
import android.view.MotionEvent;

import group25.tdt4240.entity.monster.Monster;
import group25.tdt4240.factory.Factory;
import group25.tdt4240.state.PlayState;
import group25.tdt4240.utility.Constants;
import group25.tdt4240.utility.TextDrawer;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-04-20.
 */
public class MonsterButton extends Button {
    private final Factory<Monster> factory;
    private final Monster monster;
    private TextDrawer costText;
    public MonsterButton(Image image, Factory<Monster> factory) {
        super(image);
        this.factory = factory;
        this.monster = factory.get();
        float scaleX = 1.25f * Constants.TILE_WIDTH / image.getWidth();
        float scaleY = 1.25f * Constants.TILE_HEIGHT / image.getHeight();
        setScale(scaleX, scaleY);
        costText = new TextDrawer(Integer.toString(monster.getCost()));
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (checkClick(event)){
            ((PlayState)getContainer()).clickMonster(this.factory.get());
            return true;
        }
        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        costText.draw(canvas, this.getX()-10, this.getY()-50);
    }

    public Monster getMonster() {
        return factory.get();
    }

    public int getCost() {
        return monster.getCost();
    }

    @Override
    public int getPriority(){
        return 21;
    }
}
