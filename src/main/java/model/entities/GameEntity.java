package model.entities;

import engine.Engine;
import org.newdawn.slick.opengl.Texture;

import java.util.Comparator;

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

    // ширина
    private float width;

    // высота
    private float height;

    // уромень для определения порядка отрисовки объектов
    private byte level;

    // текстура
    private Texture texture;

    // флагЮ, показывающий, является ли объект интерактивным
    private boolean isInteractive = false;

    public GameEntity(long id, float x, float y, float wx, float wy,
                      float width, float height, byte level,
                      Texture texture, boolean isInteractive) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.wx = wx;
        this.wy = wy;
        this.width = width;
        this.height = height;
        this.level = level;
        this.texture = texture;
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

    public float getWx() {
        return wx;
    }

    public void setWx(float wx) {
        this.wx = wx;
    }

    public float getWy() {
        return wy;
    }

    public void setWy(float wy) {
        this.wy = wy;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
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
}
