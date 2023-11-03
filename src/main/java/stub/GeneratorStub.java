package stub;

import lombok.experimental.UtilityClass;
import ru.infernia.core.engine.loader.ImageLoader;
import ru.infernia.core.engine.loader.TextureLoader;
import ru.infernia.core.engine.storage.ImagesStorage;
import ru.infernia.core.engine.storage.TexturesStorage;
import ru.infernia.core.engine.image.GameImage;
import ru.infernia.entity.object.AnimateEntity;
import ru.infernia.entity.object.GameObject;
import ru.infernia.entity.object.StaticEntity;
import ru.infernia.figure.Point;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class GeneratorStub {

    private final TextureLoader textureLoader = new TextureLoader();
    private final TexturesStorage storage = new TexturesStorage(textureLoader);
    private final ImagesStorage imagesStorage = new ImagesStorage(new ImageLoader(storage));

    public static List<GameObject> createAnimations() {
        List<GameObject> animateEntities = new ArrayList<>();
        animateEntities.add(
                new AnimateEntity(
                        0,
                        new Point(100, 200),
                        100,
                        110,
                        100,
                        "Captain",
                        storage.getInfo("CAPITAN2").getUrl()
                )
        );


        animateEntities.add(
                new StaticEntity(
                        1,
                        new Point(500, 500),
                        150, 150,
                        "Grass1",
                        imagesStorage.getByName("GRASS1")
                )
        );

        animateEntities.add(
                new StaticEntity(
                        2,
                        new Point(600, 600),
                        150, 150,
                        "Grass2",
                        imagesStorage.getByName("GRASS2")
                )
        );

        animateEntities.add(
                new StaticEntity(
                        3,
                        new Point(0, 0),
                        110, 130,
                        "Test1",
                        imagesStorage.getByName("BRICK1")
                )
        );

        animateEntities.add(
                new StaticEntity(
                        4,
                        new Point(115, 0),
                        90, 90,
                        "Test2",
                        imagesStorage.getByName("BRICK1")
                )
        );

        animateEntities.add(
                new StaticEntity(
                        5,
                        new Point(70, 0),
                        90, 65,
                        "Test3",
                        imagesStorage.getByName("BRICK2")
                )
        );


        return animateEntities;
    }
}
