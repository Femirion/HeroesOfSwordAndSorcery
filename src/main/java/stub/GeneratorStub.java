package stub;

import engine.ImageStorage;
import model.entities.GameEntity;

import java.util.*;

/**
 * Класс, генерирующий различные объекты игрового мира.
 * Заглушка на время разработки.
 *
 * author Vostryakov Alexander
 */
public class GeneratorStub {

    private static Map<String, ImageStorage> map = new HashMap<>();

    static {
        // pointing - наведение курсора мыши
        map.put("pointing", ImageStorage.ACTIVE_BRICK);
    }

    /**
     * Возвращает случайный набор игровых объектов.
     */
    public static List<GameEntity> getRandomVisibleObjects() {
        Random random = new Random();
        int count = random.nextInt(150) + 1;

        List<GameEntity> visibleObjectsList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            GameEntity gameEntity = new GameEntity(
                    i,
                    random.nextInt(800),
                    random.nextInt(600),
                    random.nextInt(800),
                    random.nextInt(800),
                    ImageStorage.BRICK,
                    map,
                    (byte) 1,
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
                map,
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
                (byte) 0
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
                (byte) 0
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
                map,
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
                (byte) 0
        );
        visibleObjectsList.add(gameEntity5);
        return visibleObjectsList;
    }

    private GeneratorStub() {
    }

}
