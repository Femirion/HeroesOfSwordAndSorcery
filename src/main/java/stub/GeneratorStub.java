package stub;

import lombok.experimental.UtilityClass;
import ru.infernia.core.map.WorldMap;
import ru.infernia.entity.AnimateEntity;
import ru.infernia.entity.GameObject;
import ru.infernia.entity.StaticEntity;
import ru.infernia.figure.Point;
import ru.infernia.texture.TextureStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Генератор различных игровых объектов
 *
 * author Vostryakov Alexander
 */
@UtilityClass
public class GeneratorStub {

    public static List<GameObject> createAnimateStub() {
        List<GameObject> animateEntities = new ArrayList<>();
//        animateEntities.add(
//                new AnimateEntity(
//                        new Point(100, 200),
//                        100,
//                        110,
//                        100,
//                        "Captain",
//                        TextureStorage.CAPITAN2.getUrl()
//                )
//        );
//
//
//        animateEntities.add(
//                new StaticEntity(
//                        new Point(0, 0),
//                        110, 130,
//                        "Test"
//                        new Image(TextureStorage.BRICK_1.getTexture())
//                )
//        );
//
//        animateEntities.add(
//                new StaticEntity(
//                        new Point(115, 0),
//                        90, 90,
//                        "Test",
//                        new Image(TextureStorage.BRICK.getTexture())
//                )
//        );
//
//        animateEntities.add(
//                new StaticEntity(
//                        new Point(70, 0),
//                        90, 65,
//                        "Test",
//                        new Image(TextureStorage.BRICK_1.getTexture())
//                )
//        );


        return animateEntities;
    }

    public static WorldMap createWorld() {

        WorldMap map = new WorldMap();

        List<GameObject> entities = new ArrayList<>();


        return map;
    }
}
