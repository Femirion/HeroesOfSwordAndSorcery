package new_engine.figure;



/**
 * Класс точки
 *
 * author Vostryakov Alexander
 */
public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /*

    *//**
     * Возвращает координату X точки,
     * с учетом расположения на экране
     * @param entity игровой объект
     * @return координата X точки с учетом расположения объекта
     *//*
    public float getX(GameEntity entity) {
        return x  + entity.getX();
    }

    *//**
     * Возвращает координату Y точки,
     * с учетом расположения на экране
     * @param entity игровой объект
     * @return координата Y точки с учетом расположения объекта
     *//*
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
    }*/
}
