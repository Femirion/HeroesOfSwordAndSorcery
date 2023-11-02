package stub;

import lombok.experimental.UtilityClass;
import org.newdawn.slick.Image;
import ru.infernia.core.engine.TextureLoader;
import ru.infernia.core.engine.image.GameImage;
import ru.infernia.entity.AnimateEntity;
import ru.infernia.entity.GameObject;
import ru.infernia.entity.StaticEntity;
import ru.infernia.figure.Point;
import ru.infernia.texture.TextureStorage;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class GeneratorStub {

    private final TextureLoader textureLoader = new TextureLoader();

    public static List<GameObject> createAnimations() {
        List<GameObject> animateEntities = new ArrayList<>();
        animateEntities.add(
                new AnimateEntity(
                        new Point(100, 200),
                        100,
                        110,
                        100,
                        "Captain",
                        TextureStorage.CAPITAN2.getUrl()
                )
        );


        animateEntities.add(
                new StaticEntity(
                        new Point(0, 0),
                        110, 130,
                        "Test",
                        new GameImage(textureLoader.loadTexture(TextureStorage.BRICK))
                )
        );

        animateEntities.add(
                new StaticEntity(
                        new Point(115, 0),
                        90, 90,
                        "Test",
                        new GameImage(textureLoader.loadTexture(TextureStorage.BRICK))
                )
        );

        animateEntities.add(
                new StaticEntity(
                        new Point(70, 0),
                        90, 65,
                        "Test",
                        new GameImage(textureLoader.loadTexture(TextureStorage.BRICK))
                )
        );


        return animateEntities;
    }
}
