package stub;

import engine.ImageStorage;
import model.entities.GameEntity;

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

    private GeneratorStub() {
    }

    /**
     * Возвращает случайный набор игровых объектов.
     */
    public static List<GameEntity> getRandomVisibleObjects() {
        Random random = new Random();
        int count = random.nextInt(80) + 1;

        List<GameEntity> visibleObjectsList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            GameEntity gameEntity = new GameEntity(
                    i,
                    random.nextInt(800),
                    random.nextInt(600),
                    random.nextInt(800),
                    random.nextInt(800),
                    ImageStorage.BRICK,
                    (byte) random.nextInt(120),
                    random.nextBoolean()
            );
            visibleObjectsList.add(gameEntity);
        }

        return visibleObjectsList;
    }

    /**
     * Возвращает заранее заданный набор игровых объектов.
     */
    public static List<GameEntity> getStableVisibleObjects() {
        List<GameEntity> visibleObjectsList = new ArrayList<>();

        // 1
        GameEntity gameEntity1 = new GameEntity(
                1,
                15F,
                15F,
                10F,
                10F,
                ImageStorage.BRICK,
                (byte) 0,
                true

        );
        visibleObjectsList.add(gameEntity1);

        // 2
        GameEntity gameEntity2 = new GameEntity(
                2,
                10F,
                10F,
                10F,
                10F,
                ImageStorage.BRICK,
                (byte) 0,
                false

        );
        visibleObjectsList.add(gameEntity2);


        // 3
        GameEntity gameEntity3 = new GameEntity(
                3,
                20F,
                20F,
                10F,
                10F,
                ImageStorage.BRICK,
                (byte) 0,
                true

        );
        visibleObjectsList.add(gameEntity3);


        // 4
        GameEntity gameEntity4 = new GameEntity(
                4,
                200F,
                10F,
                10F,
                10F,
                ImageStorage.BRICK,
                (byte) 0,
                true

        );
        visibleObjectsList.add(gameEntity4);

        // 5
        GameEntity gameEntity5 = new GameEntity(
                5,
                10F,
                200F,
                10F,
                10F,
                ImageStorage.BRICK,
                (byte) 0,
                false

        );
        visibleObjectsList.add(gameEntity5);
        return visibleObjectsList;
    }

}
