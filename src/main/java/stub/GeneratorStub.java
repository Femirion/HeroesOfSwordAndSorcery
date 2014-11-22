package stub;

import engine.ImageStorage;
import engine.Point;
import model.entities.GameEntity;

import java.util.*;

/**
 * Класс, генерирующий различные объекты игрового мира.
 * Заглушка на время разработки.
 *
 * author Vostryakov Alexander
 */
public class GeneratorStub {

    private static Map<String, ImageStorage> imageMap = new HashMap<>();
    private static Map<String, List<Point>> pointMap = new HashMap<>();

    static {
        List<Point> points = new ArrayList<>();
        Random random = new Random();
        points.add(new Point(random.nextFloat(), random.nextFloat()));
        points.add(new Point(random.nextFloat(), random.nextFloat()));
        points.add(new Point(random.nextFloat(), random.nextFloat()));
        points.add(new Point(random.nextFloat(), random.nextFloat()));
        points.add(new Point(random.nextFloat(), random.nextFloat()));
        points.add(new Point(random.nextFloat(), random.nextFloat()));

        // pointing - наведение курсора мыши
        imageMap.put("pointing", ImageStorage.ACTIVE_BRICK);
        pointMap.put("pointing", points);
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
                    imageMap,
                    pointMap,
                    (byte) 1,
                    random.nextBoolean()
            );
            visibleObjectsList.add(gameEntity);
        }

        return visibleObjectsList;
    }

    /**
     * Метод для генерации активных точек для квадратного имейджа.
     * В качестве активных точек устанавливает вершины прямоугольнинка,
     * в котороый заключен имейдж
     *
     * @param name имя для списка активных точек
     * @param x координата X имейджа
     * @param y координата Y имейджа
     * @param width ширина имейджа
     * @param height высота имейджа
     * @return справочник активных точек
     */
    private static Map<String, List<Point>> getQuardMap(
            String name, float x, float y, float width, float height) {

        Map<String, List<Point>> quardMap = new HashMap<>();
        List<Point> points = new ArrayList<>();
        points.add(new Point(x, y));
        points.add(new Point(x, y + height));
        points.add(new Point(x + width, y));
        points.add(new Point(x +width, y + height));
        quardMap.put(name, points);

        return quardMap;
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
                imageMap,
                getQuardMap("pointing", 15F,15F,10F,10F),
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
                imageMap,
                getQuardMap("pointing", 200F,10F,10F,10F),
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

    public static List<Point> generatePoints(int count) {
        Random random = new Random();
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Point point = new Point(random.nextFloat(), random.nextFloat());
            pointList.add(point);
        }
        return pointList;
    }


    private GeneratorStub() {
    }

}
