package stub;

import engine.image.GameImg;
import engine.image.TextureStorage;
import engine.point.Point;
import model.entities.GameEntity;

import java.util.*;

/**
 * Класс, генерирующий различные объекты игрового мира.
 * Заглушка на время разработки.
 *
 * author Vostryakov Alexander
 */
public class GeneratorStub {

    private static Map<String, TextureStorage> brickMap = new HashMap<>();
    private static Map<String, TextureStorage> starMap = new HashMap<>();

    static {
        // pointing - наведение курсора мыши
        brickMap.put("pointing", TextureStorage.ACTIVE_BRICK);
        starMap.put("pointing", TextureStorage.ACTIVE_STAR);
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
                    random.nextBoolean() ?
                    new GameImg(TextureStorage.BRICK, brickMap, new Point(16F,16F)) :
                    new GameImg(TextureStorage.STAR, starMap, new Point(25F,25F)),
                    (byte) 1,
                    random.nextBoolean(),
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
                new GameImg(TextureStorage.BRICK, brickMap, new Point(16F,16F)),
                (byte) 0,
                true,
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
                new GameImg(TextureStorage.BRICK),
                (byte) 0,
                false,
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
                new GameImg(TextureStorage.BRICK),
                (byte) 0,
                false,
                false
        );
        visibleObjectsList.add(gameEntity3);


        // 4
        GameEntity gameEntity4 = new GameEntity(
                4,
                200F,
                10F,
                10F,
                10F,
                new GameImg(TextureStorage.BRICK, brickMap, new Point(16F,16F)),
                (byte) 0,
                true,
                false

        );
        visibleObjectsList.add(gameEntity4);

        // 5
        GameEntity gameEntity5 = new GameEntity(
                5,
                10F,
                200F,
                10F,
                10F,
                new GameImg(TextureStorage.BRICK),
                (byte) 0,
                false,
                false
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

    public static List<Point> generateBrickPoints() {
        List<Point> brickPointList = new ArrayList<>();
        brickPointList = new ArrayList<>();
        brickPointList.add(new Point(0F, 0F));
        brickPointList.add(new Point(32F, 0F));
        brickPointList.add(new Point(32F, 32F));
        brickPointList.add(new Point(0F, 32F));

        return brickPointList;
    }

    public static List<Point> getStarPointList() {
        List<Point> starPoints = new ArrayList<>();
        starPoints.add(new Point(24F, 4F));
        starPoints.add(new Point(31F, 17F));
        starPoints.add(new Point(45F, 17F));
        starPoints.add(new Point(33F, 28F));
        starPoints.add(new Point(37F, 43F));
        starPoints.add(new Point(24F, 35F));
        starPoints.add(new Point(11F, 43F));
        starPoints.add(new Point(16F, 28F));
        starPoints.add(new Point(3F, 17F));
        starPoints.add(new Point(19F, 17F));
        return starPoints;
    }


    private GeneratorStub() {
    }

}
