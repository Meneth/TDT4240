package group25.tdt4240.entity.monster;

import group25.tdt4240.map.Path;
import group25.tdt4240.entity.MovableEntity;
import group25.tdt4240.state.PlayState;
import sheep.graphics.Image;

/**
 * Created by Meneth on 2016-03-31.
 */
public abstract class Monster extends MovableEntity {
    private final Path path;
    private int position;
    private int health;
    private final int cost;
    private final Image image;

    public Image getImage(){
        return image;
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        if (!path.get(position).collides(this)) {
            position++;
            if (position == path.size() - 1) {
                die();
                ((PlayState) getContainer()).loseHealth(1);
                return;
            }
            setTarget(path.get(position + 1).getPosition());
        }
    }

    /**
     * @param image The image the sprite is to be generated from
     */
    public Monster(Image image, Path path, float standardVelocity, int health, int cost) {
        super(image, standardVelocity);
        this.image = image;
        this.path = path;
        position = 0;
        // Spawn monster at start
        setPosition(path.get(0).getX(), path.get(0).getY());
        setTarget(path.get(position + 1).getPosition());
        this.health = health;
        this.cost = cost;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0){
            die();

        }
    }

    @Override
    public void die() {
        ((PlayState)getContainer()).monsterDied(this);
        super.die();
    }

    public int getPriority() {
        return 10; // TODO - placeholder
    }

    public int getCost() {
        return cost;
    }
}
