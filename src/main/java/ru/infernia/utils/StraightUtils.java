package ru.infernia.utils;

import lombok.experimental.UtilityClass;
import ru.infernia.figure.Point;
import ru.infernia.figure.Straight;

import java.util.Optional;

/**
 * Util methods for Straight, Vectors, Dots etc
 */
@UtilityClass
public class StraightUtils {

    /**
     * Получить точку пересечения прямой А и Б
     *
     * @param a прямая А
     * @param b прямая Б
     *
     * @return Optional, содержащая точку перечения или Null
     */
    public static Optional<Point> getCrossedPoint(Straight a, Straight b) {
        final int ax1 = a.getStart().getX();
        final int ay1 = a.getStart().getY();
        final int ax2 = a.getEnd().getX();
        final int ay2 = a.getEnd().getY();

        final int bx1 = b.getStart().getX();
        final int by1 = b.getStart().getY();
        final int bx2 = b.getEnd().getX();
        final int by2 = b.getEnd().getY();

        int dx1 = ax2 - ax1;
        int dy1 = ay1 - ay2;
        int dx2 = bx2 - bx1;
        int dy2 = by1 - by2;

        float d = dy1 * dx2 - dy2 * dx1;

        if (d != 0) {
            int c1 = ay2 * ax1 - ax2 * ay1;
            int c2 = by2 * bx1 - bx2 * by1;

            float xi = (c2 * dx2 - c1 * dx1) / d;
            float yi = (dy2 * xi - c1) / dx2;

            return Optional.of(new Point(setNormalValue((int) xi), setNormalValue((int) yi)));
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
    private static int setNormalValue(int value) {
        if (value == -0) {
            return 0;
        }
        return value;
    }

}
