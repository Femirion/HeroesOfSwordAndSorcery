package engine.unils;

import engine.Point;

import java.util.List;
import java.util.Random;

/**
 * author Vostryakov Alexander
 * <p/>
 * хелпер для облегчения работы с точками
 */
public class PointUntils {

    private PointUntils() {
    }

    /**
     * метод для получения рандомной внутреней точки определенной области,
     * заданной списком вершин
     *
     * @param points список вершин
     * @return точка внутри области
     */
    public static Point getInsidePoint(int width, int height, List<Point> points) {
        Random random = new Random();
        int inside = 0;
        // идея такова:
        // мы генерируем внутри прямоугольника точку
        // если точка лежит внутри
        while (inside == points.size()) {
            int randomX = random.nextInt(width) + 1;
            int randomY = random.nextInt(height) + 1;
            for (int i = 0; i <= points.size(); i++) {
                if (i == points.size()) {
                    inside = inside + VectorUntils.isLeftRotate(
                            points.get(i).getX(), points.get(i).getY(),
                            points.get(0).getX(), points.get(0).getY(),
                            randomX, randomY);
                } else {
                    inside = inside + VectorUntils.isLeftRotate(
                            points.get(i).getX(), points.get(i).getY(),
                            points.get(i + 1).getX(), points.get(i + 1).getY(),
                            randomX, randomY);
                }
            }
        }
        // TODO Метод не работает
        return new Point();
    }

}
