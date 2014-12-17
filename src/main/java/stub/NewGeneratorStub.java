package stub;

import new_engine.entity.AbstractGameObject;
import new_engine.entity.AnimationGameObject;
import new_engine.entity.SimpleGameObject;
import new_engine.image.Image;
import new_engine.texture.TextureStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * author Vostryakov Alexander
 */
public class NewGeneratorStub {

    public static List<AbstractGameObject> getStendedObjectList() {
        List<AbstractGameObject> list = new ArrayList<>();
        AbstractGameObject brick1 = new SimpleGameObject(
                1, 250, 250, 1, new Image(1, 31, 1,30, TextureStorage.BRICK));
        list.add(brick1);

        AbstractGameObject brick2 = new SimpleGameObject(
                1, 280, 250, 1, new Image(1, 31, 1,30, TextureStorage.BRICK));
        list.add(brick2);

        AbstractGameObject brick3 = new SimpleGameObject(
                1, 310, 250, 1, new Image(1, 31, 1,30, TextureStorage.BRICK));
        list.add(brick3);

        AbstractGameObject brick4 = new SimpleGameObject(
                1, 340, 250, 1, new Image(1, 31, 1,30, TextureStorage.BRICK));
        list.add(brick4);

        AbstractGameObject brick5 = new SimpleGameObject(
                1, 370, 250, 1, new Image(1, 31, 1,30, TextureStorage.BRICK));
        list.add(brick5);


        return list;
    }

    public static List<AbstractGameObject> getAnimationObjectList() {
        List<AbstractGameObject> list = new ArrayList<>();
        AbstractGameObject brick1 = new AnimationGameObject(
                1, 250, 250, 1,
                new Image(1, 31, 1,30, 1, 1, TextureStorage.BRICK),
                0, 1, 1000, 0, 30, 0);
        list.add(brick1);

        return list;
    }



    // запретим инстанцирование
    NewGeneratorStub() {}

}
