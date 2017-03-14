package new_engine.unils;

import new_engine.figure.Point;
import new_engine.figure.Straight;

/**
 * author Vostryakov Alexander
 *
 * вспомогательный класс, для работы с векторами, точками,
 * прямыми, их пересечением и тд.
 */
public class VectorUntils {

    private VectorUntils() {
    }

    /**
     * Определяет пересеклись ли две прямые A и B
     * с координатами точек A1[a1x, a1y] A2[a2x, a2y]
     * и B1[b1x, b1y] B2[b2x, b2y]
     *
     * @param a1x коордианта X точки A1
     * @param a1y коордианта Y точки A1
     * @param a2x коордианта X точки A2
     * @param a2y коордианта Y точки A2
     * @param b1x коордианта X точки B1
     * @param b1y коордианта Y точки B1
     * @param b2x коордианта X точки B2
     * @param b2y коордианта Y точки B2
     * @return true если пересеклись
     */
    public static boolean isCrossed(float a1x, float a1y,
                                    float a2x, float a2y,
                                    float b1x, float b1y,
                                    float b2x, float b2y) {
        return (isLeftRotate(a1x, a1y, a2x, a2y, b1x, b1y) *
                isLeftRotate(a1x, a1y, a2x, a2y, b2x, b2y)) <= 0 &&
                (isLeftRotate(b1x, b1y, b2x, b2y, a1x, a1y) *
                isLeftRotate(b1x, b1y, b2x, b2y, a2x, a2y)) < 0;
    }

    public static boolean isCrossed(Straight a, Straight b) {
        return (isLeftRotate(a.getStart(), a.getEnd(), b.getStart()) *
                isLeftRotate(a.getStart(), a.getEnd(), b.getEnd())) <= 0 &&
                (isLeftRotate(b.getStart(), b.getEnd(), a.getStart()) *
                        isLeftRotate(b.getStart(), b.getEnd(), a.getStart())) < 0;
    }

    /**
     * Определяет направление поворота точки B1, относительно A1 и А2
     *
     * @param a1x коордианта X точки A1
     * @param a1y коордианта Y точки A1
     * @param a2x коордианта X точки A2
     * @param a2y коордианта Y точки A2
     * @param b1x коордианта X точки B1
     * @param b1y коордианта Y точки B1
     * @return >0 если поворот левый и <0 если правый
     */
    public static int isLeftRotate(float a1x, float a1y,
                                   float a2x, float a2y,
                                   float b1x, float b1y) {

        return (int)((a2x - a1x) * (b1y - a2y) - (a2y - a1y) * (b1x - a2x));

    }

    public static int isLeftRotate(Point a1, Point a2, Point b) {

        return (int)((a2.getX() - a1.getX()) * (b.getY() - a2.getY())
                - (a2.getY() - a1.getY()) * (b.getX() - a2.getX()));

    }

}
