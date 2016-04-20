package group25.tdt4240.entity.button;

import android.view.MotionEvent;

import group25.tdt4240.entity.monster.Monster;
import group25.tdt4240.state.PlayState;
import group25.tdt4240.utility.Constants;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-04-20.
 */
public class MonsterImageButton extends Button {
    private final Monster monster;

    public MonsterImageButton(Image image, Monster monster) {
        super(image);
        this.monster = monster;
        float scaleX = 0.5f * Constants.TILE_WIDTH / image.getWidth();
        float scaleY = 0.5f * Constants.TILE_HEIGHT / image.getHeight();
        setScale(scaleX, scaleY);
    }

    public Monster getMonster(){
        return monster;
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        if (checkClick(event)){
            ((PlayState)getContainer()).clickMonsterImage(this);
            return true;
        }
        return false;
    }

    @Override
    public int getPriority(){
        return 21;
    }
}
