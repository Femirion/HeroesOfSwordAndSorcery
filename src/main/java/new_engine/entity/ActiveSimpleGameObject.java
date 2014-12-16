package new_engine.entity;

import new_engine.entity.mixin.Active;
import new_engine.image.Image;

import java.util.HashMap;
import java.util.Map;

/**
 * author Vostryakov Alexander
 */
public class ActiveSimpleGameObject extends SimpleGameObject implements Active {

    private Map<String, Image> action = new HashMap<>();

    public ActiveSimpleGameObject(long id, float x, float y, int level, Image drawImg) {
        this.setId(id);
        this.setX(x);
        this.setY(y);
        this.setLevel(level);
        this.setDrawImg(drawImg);
    }

    @Override
    public Image getImg(String name) {
        return action.get(name);
    }

    @Override
    public void draw() {
        super.draw();
    }
}
