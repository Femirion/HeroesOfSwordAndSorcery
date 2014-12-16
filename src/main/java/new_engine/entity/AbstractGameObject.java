package new_engine.entity;

import new_engine.core.Engine;
import new_engine.image.Image;

/**
 * author Vostryakov Alexander
 */
public abstract class AbstractGameObject implements GameObject, Comparable {

    private long id;

    // координата X на экране
    private float x;

    // координата Y на экране
    private float y;

    // слой для определения порядка отрисовки объектов
    private int level;

    // отрисовываемое изображение
    private Image drawImg;

    public void draw() {
        Engine.draw(this);
        System.out.println("Отрисовка объекта");
    }

    @Override
    public int compareTo(Object obj) {
        GameObject entry = (GameObject) obj;
        if (level == entry.getLevel()) {
            // та. у которой координата y больше, та должна быть ближе к нам
            return Float.compare(y, entry.getY());
        } else {
            return level > entry.getLevel() ? 1 : -1;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Image getDrawImg() {
        return drawImg;
    }

    public void setDrawImg(Image drawImg) {
        this.drawImg = drawImg;
    }
}
