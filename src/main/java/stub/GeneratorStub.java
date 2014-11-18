package stub;

import model.GameEntity;
import org.newdawn.slick.opengl.Texture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static engine.Engine.*;
/**
 * Класс, генерирующий различные объекты игрового мира.
 * Заглушка на время разработки.
 *
 * author Vostryakov Alexander
 */
public class GeneratorStub {

    private GeneratorStub(){}

    /**
     * Возвращает случайный набор игровых объектов.
     */
    public static List<GameEntity> getVisibleObjects() {
        Random random = new Random();
        int count = random.nextInt(800) + 1;

        List<GameEntity> visibleObjectsList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            GameEntity gameEntity = new GameEntity(
                    i,
                    random.nextInt(800),
                    random.nextInt(600),
                    random.nextInt(800),
                    random.nextInt(800),
                    random.nextInt(800),
                    random.nextInt(800),
                    (byte)random.nextInt(120),
                    loadTexture("brick.png")
            );
            visibleObjectsList.add(gameEntity);
        }

        return visibleObjectsList;
    }

}
