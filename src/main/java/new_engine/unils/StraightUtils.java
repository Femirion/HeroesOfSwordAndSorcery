package new_engine.unils;

import new_engine.figure.Point;
import new_engine.figure.Straight;

import java.util.Optional;

/**
 * author Vostryakov Alexander
 *
 * вспомогательный класс, для работы с векторами, точками,
 * прямыми, их пересечением и тд.
 */
public class StraightUtils {

    private StraightUtils() {
    }

    /**
     * Получить точку пересечения прямой А и Б
     *
     * @param a прямая А
     * @param b прямая Б
     *
     * @return Optional, содержащая точку перечения или Null
     */
    public static Optional<Point> getCrossedPoint(Straight a, Straight b) {
        final float ax1 = a.getStart().getX();
        final float ay1 = a.getStart().getY();
        final float ax2 = a.getEnd().getX();
        final float ay2 = a.getEnd().getY();

        final float bx1 = b.getStart().getX();
        final float by1 = b.getStart().getY();
        final float bx2 = b.getEnd().getX();
        final float by2 = b.getEnd().getY();

        float dx1 = ax2 - ax1;
        float dy1 = ay1 - ay2;
        float dx2 = bx2 - bx1;
        float dy2 = by1 - by2;

        float d = dy1 * dx2 - dy2 * dx1;

        if (d != 0) {
            float c1 = ay2 * ax1 - ax2 * ay1;
            float c2 = by2 * bx1 - bx2 * by1;

            float xi = (c2 * dx2 - c1 * dx1) / d;
            float yi = (dy2 * xi - c1) / dx2;

            return Optional.of(new Point(setNormalValue(xi), setNormalValue(yi)));
        }

        return Optional.empty();
    }

    /**
     * Установить нормальное значение.
     * Ненормальное знаение это -0.0f, его нужно заменить на 0.0f
     *
     * @param value значение
     * @return нормальное значение
     */
    private static float setNormalValue(float value) {
        if (value == -0f) {
            return 0f;
        }
        return value;
    }

}
