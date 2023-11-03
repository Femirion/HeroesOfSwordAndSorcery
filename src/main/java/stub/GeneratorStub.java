package stub;

import lombok.experimental.UtilityClass;
import ru.infernia.core.engine.loader.AnimationLoader;
import ru.infernia.core.engine.loader.SpriteSheetLoader;
import ru.infernia.core.engine.storage.AnimationStorage;
import ru.infernia.core.engine.wrapper.AnimationInfo;
import ru.infernia.core.engine.loader.ImageLoader;
import ru.infernia.core.engine.loader.TextureLoader;
import ru.infernia.core.engine.storage.ImagesStorage;
import ru.infernia.core.engine.storage.TexturesStorage;
import ru.infernia.entity.object.AnimateEntity;
import ru.infernia.entity.object.GameObject;
import ru.infernia.entity.object.StaticEntity;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class GeneratorStub {
    private final TextureLoader textureLoader = new TextureLoader();
    private final TexturesStorage storage = new TexturesStorage(textureLoader);
    private final ImagesStorage imagesStorage = new ImagesStorage(new ImageLoader(storage));
    private final AnimationStorage animationsStorage = new AnimationStorage(new AnimationLoader(new SpriteSheetLoader(storage)));

    public static List<GameObject> createAnimations() {
        List<GameObject> animateEntities = new ArrayList<>();
        animateEntities.add(
                new AnimateEntity(
                        0,
                        100, 200,
                        animationsStorage.getByName("CAPITAN1")
                )
        );

        animateEntities.add(
                new AnimateEntity(
                        0,
                        500, 500,
                        animationsStorage.getByName("CAPITAN2")
                )
        );


        animateEntities.add(
                new StaticEntity(
                        1,
                        400, 400,
                        "Grass1",
                        imagesStorage.getByName("GRASS1")
                )
        );

        animateEntities.add(
                new StaticEntity(
                        2,
                        350, 350,
                        "Grass2",
                        imagesStorage.getByName("GRASS2")
                )
        );

        animateEntities.add(
                new StaticEntity(
                        3,
                        0, 0,
                        200, 200,
                        "Test1",
                        imagesStorage.getByName("BRICK1")
                )
        );

        animateEntities.add(
                new StaticEntity(
                        4,
                       115, 0,
                        "Test2",
                        imagesStorage.getByName("BRICK1")
                )
        );

        animateEntities.add(
                new StaticEntity(
                        5,
                        70, 0,
                        "Test3",
                        imagesStorage.getByName("BRICK2")
                )
        );


        return animateEntities;
    }
}
