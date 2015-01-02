package stub;

import new_engine.entity.AbstractGameObject;
import new_engine.entity.AnimationGameObject;
import new_engine.entity.SimpleGameObject;
import new_engine.image.AnimateImage;
import new_engine.image.Image;
import new_engine.texture.TextureStorage;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.List;

/**
 * Генератор различных игровых объектов
 *
 * author Vostryakov Alexander
 */
public class GeneratorStub {

    /**
     * Метод для генерации нескольких кирпичей
     *
     * @return список из кирпичей
     */
    public static List<AbstractGameObject> getSevereBrick() {
        List<AbstractGameObject> list = new ArrayList<>();
        AbstractGameObject brick1 = new SimpleGameObject(
                1, 250, 250, 1, new Image(1, 31, 1,30, TextureStorage.BRICK));
        list.add(brick1);

        AbstractGameObject brick2 = new SimpleGameObject(
                1, 279, 250, 1, new Image(1, 31, 1,30, TextureStorage.BRICK));
        list.add(brick2);

        AbstractGameObject brick3 = new SimpleGameObject(
                1, 308, 250, 1, new Image(1, 31, 1,30, TextureStorage.BRICK));
        list.add(brick3);

        AbstractGameObject brick4 = new SimpleGameObject(
                1, 337, 250, 1, new Image(1, 31, 1,30, TextureStorage.BRICK));
        list.add(brick4);

        AbstractGameObject brick5 = new SimpleGameObject(
                1, 366, 250, 1, new Image(1, 31, 1,30, TextureStorage.BRICK));
        list.add(brick5);


        return list;
    }

    /**
     * Метод для генерации списка анимированных объектов
     *
     * @return список из 2х катящихся звезд
     */
    public static List<AbstractGameObject> getTwoRollingStars() {
        List<AbstractGameObject> list = new ArrayList<>();
        AbstractGameObject star1 = new AnimationGameObject(
                1, 250, 250, 1,
                new AnimateImage(1, 50, 1, 49, 49, TextureStorage.ROLLING_STAR),
                1, 6, 35L, System.currentTimeMillis());
        list.add(star1);

        AbstractGameObject star2 = new AnimationGameObject(
                1, 250, 180, 1,
                new AnimateImage(1, 50, 1, 49, 49, TextureStorage.ROLLING_STAR),
                1, 6, 85L, System.currentTimeMillis());
        list.add(star2);

        return list;
    }



    // запретим инстанцирование
    GeneratorStub() {}

}
