package stub;

import engine.image.GameImg;
import engine.image.ImageStorage;
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

    private static Map<String, ImageStorage> brick_1_Map = new HashMap<>();
    private static Map<String, ImageStorage> brick_2_Map = new HashMap<>();
    private static Map<String, ImageStorage> starMap = new HashMap<>();
    private static Random random = new Random();

    static {
        // pointing - наведение курсора мыши
        brick_1_Map.put("pointing", ImageStorage.ACTIVE_BRICK_1);
        brick_2_Map.put("pointing", ImageStorage.ACTIVE_BRICK_2);
        starMap.put("pointing", ImageStorage.ACTIVE_STAR);
    }

    /**
     * Возвращает случайный набор игровых объектов.
     */
    public static List<GameEntity> getRandomVisibleObjects() {

        int count = random.nextInt(150) + 1;

        List<GameEntity> visibleObjectsList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            GameEntity gameEntity = new GameEntity(
                    i,
                    random.nextInt(800),
                    random.nextInt(600),
                    random.nextInt(800),
                    random.nextInt(800),
                    randomGameImg(),
                    (byte) 1,
                    random.nextBoolean(),
                    random.nextBoolean()
            );
            visibleObjectsList.add(gameEntity);
        }

        return visibleObjectsList;
    }

    /**
     * Генерация случайных игровых объектов
     * @return случайны объект:
     * киприч_1
     * киприч_2
     * звезда
     *
     */
    private static GameImg randomGameImg() {
        int x = random.nextInt(3);
        switch (x) {
            case 0 : return new GameImg(ImageStorage.BRICK_1, brick_1_Map);
            case 1 : return new GameImg(ImageStorage.BRICK_2, brick_2_Map);
            case 2 : return new GameImg(ImageStorage.STAR, brick_1_Map);
            default: return new GameImg(ImageStorage.BRICK_1, brick_1_Map);
        }
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
                16F,
                200F,
                10F,
                10F,
                new GameImg(ImageStorage.STAR, starMap),
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
                new GameImg(ImageStorage.BRICK_1),
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
                new GameImg(ImageStorage.BRICK_1),
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
                new GameImg(ImageStorage.STAR, starMap),
                (byte) 0,
                false,
                true

        );
        visibleObjectsList.add(gameEntity4);

        // 5
        GameEntity gameEntity5 = new GameEntity(
                5,
                16F,
                240F,
                10F,
                10F,
                new GameImg(ImageStorage.BRICK_1),
                (byte) 0,
                false,
                true
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
        brickPointList.add(new Point(0F, 0F));
        brickPointList.add(new Point(32F, 0F));
        brickPointList.add(new Point(32F, 32F));
        brickPointList.add(new Point(0F, 32F));

        return brickPointList;
    }

    public static List<Point> getStarPointList() {
        List<Point> starPoints = new ArrayList<>();
        starPoints.add(new Point(26F, 0F));
        starPoints.add(new Point(32F, 18F));
        starPoints.add(new Point(50F, 19F));
        starPoints.add(new Point(37F, 33F));
        starPoints.add(new Point(41F, 50F));
        starPoints.add(new Point(26F, 41F));
        starPoints.add(new Point(8F, 50F));
        starPoints.add(new Point(13F, 33F));
        starPoints.add(new Point(0F, 19F));
        starPoints.add(new Point(19F, 18F));
        return starPoints;
    }


    private GeneratorStub() {
    }

}
