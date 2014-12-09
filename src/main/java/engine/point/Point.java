package engine.point;

import model.entities.GameEntity;

/**
 * author Vostryakov Alexander
 */
public class Point {

    private float x;
    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }


    /**
     * Возвращает координату X точки,
     * с учетом расположения на экране
     * @param entity игровой объект
     * @return координата X точки с учетом расположения объекта
     */
    public float getX(GameEntity entity) {
        return x  + entity.getX();
    }

    /**
     * Возвращает координату Y точки,
     * с учетом расположения на экране
     * @param entity игровой объект
     * @return координата Y точки с учетом расположения объекта
     */
    public float getY(GameEntity entity) {
        return y + entity.getY();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (Float.compare(point.x, x) != 0) return false;
        if (Float.compare(point.y, y) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        return result;
    }
}
