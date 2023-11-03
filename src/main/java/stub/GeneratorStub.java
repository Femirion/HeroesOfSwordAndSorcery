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
                        new Point(500, 500),
                        150, 150,
                        "Grass1",
                        new GameImage(imagesStorage.getInfo("GRASS1"), storage.getByName("GRASS"))
                )
        );

        animateEntities.add(
                new StaticEntity(
                        new Point(600, 600),
                        150, 150,
                        "Grass1",
                        new GameImage(imagesStorage.getInfo("GRASS2"), storage.getByName("GRASS"))
                )
        );

        animateEntities.add(
                new StaticEntity(
                        new Point(0, 0),
                        110, 130,
                        "Test1",
                        new GameImage(imagesStorage.getInfo("BRICK1"), storage.getByName("BRICK"))
                )
        );

        animateEntities.add(
                new StaticEntity(
                        new Point(115, 0),
                        90, 90,
                        "Test2",
                        new GameImage(imagesStorage.getInfo("BRICK1"), storage.getByName("BRICK"))
                )
        );

        animateEntities.add(
                new StaticEntity(
                        new Point(70, 0),
                        90, 65,
                        "Test3",
                        new GameImage(imagesStorage.getInfo("BRICK2"), storage.getByName("BRICK"))
                )
        );


        return animateEntities;
    }
}
