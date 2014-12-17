package new_engine.entity;

import new_engine.image.Image;

/**
 * author Vostryakov Alexander
 */
public class SimpleGameObject extends AbstractGameObject {

    public SimpleGameObject(long id, float x, float y, int level, Image drawImg) {
        super(id, x, y, level, drawImg);
    }

    @Override
    public void draw() {
        super.draw();
    }
}
