package model.entities;

import engine.Engine;
import engine.ImageStorage;

import static engine.Engine.*;

/**
 * Класс, представляющий собой сущность игрового мира
 * author Vostryakov Alexander
 */
public class GameEntity implements Comparable {

    private long id;

    // координата X на экране
    private float x;

    // координата Y на экране
    private float y;

    // координата X внутри мира
    private float wx;

    // координата Y внутри мира
    private float wy;

    private ImageStorage image;

    // уромень для определения порядка отрисовки объектов
    private byte level;

    // флаг, показывающий, является ли объект интерактивным
    private boolean isInteractive = false;

    public GameEntity(long id, float x, float y, float wx, float wy,
                      ImageStorage image, byte level,
                      boolean isInteractive) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.wx = wx;
        this.wy = wy;
        this.image = image;
        this.level = level;
        this.isInteractive = isInteractive;
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

    public float getWX() {
        return wx;
    }

    public void setWX(float wx) {
        this.wx = wx;
    }

    public float getWY() {
        return wy;
    }

    public void setWY(float wy) {
        this.wy = wy;
    }

    public float getWidth() {
        return image.getWidht();
    }

    public float getHeight() {
        return image.getHeight();
    }

    public ImageStorage getImage() {
        return image;
    }

    public void setImage(ImageStorage image) {
        this.image = image;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public boolean isInteractive() {
        return isInteractive;
    }

    public void setInteractive(boolean isInteractive) {
        this.isInteractive = isInteractive;
    }

    @Override
    public int compareTo(Object obj) {
        GameEntity entry = (GameEntity) obj;
        if (level == entry.level) {
            // та. у которой координата y больше, та должна быть ближе к нам
            return Float.compare(y, entry.y);
        } else {
            return level > entry.level ? 1 : -1;
        }
    }

    public void draw() {
        Engine.draw(this);
    }

    public boolean constraint(float x, float y) {
        return  x > this.getX() &&
                x < this.getX() + this.getWidth() &&
                HEIGTH - y > this.getY() &&
                WIDTH - y < this.getY() + this.getHeight();

    }

}
