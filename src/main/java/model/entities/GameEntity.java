package model.entities;

import engine.Engine;
import engine.image.GameImg;
import engine.image.TextureStorage;

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

    // игровое изображение, привязанное к сущности
    private GameImg img;

    // слой для определения порядка отрисовки объектов
    private byte level;

    // флаг, показывающий, является ли объект интерактивным
    private boolean isInteractive;

    private boolean isPassable;

    /**
     * позволяет создвать интерктивные и проходимые объекты.
     * @param id идентификатор объекта
     * @param x координата X
     * @param y координата Y
     * @param wx координата X в игровом мире
     * @param wy координата Y в игровом мире
     * @param img изображение
     * @param level слой
     * @param isInteractive флаг, показывающий, является ли данный объект интерактивным
     * @param isInteractive флаг, показывающий, является ли данный объект проходимым
     */
    public GameEntity(long id, float x, float y, float wx, float wy,
                      GameImg img,byte level,boolean isInteractive, boolean isPassable) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.wx = wx;
        this.wy = wy;
        this.img = img;
        this.level = level;
        this.isInteractive = isInteractive;
        this.isPassable = isPassable;
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

    public boolean contains(float x, float y) {
        return  x > this.getX() &&
                x < this.getX() + this.getWidth() &&
                HEIGHT - y > this.getY() &&
                HEIGHT - y < this.getY() + this.getHeight();

    }

    public TextureStorage getDrawImage() {
        return img.getDrawImage();
    }

    public void setDrawImage(TextureStorage storage) {
        img.setDrawImage(storage);
    }

    public int getWidth() {
        return img.getWidth();
    }

    public int getHeight() {
        return img.getHeight();
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

    public GameImg getImg() {
        return img;
    }

    public void setImg(GameImg img) {
        this.img = img;
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

    public boolean isPassable() {
        return isPassable;
    }

    public void setPassable(boolean isPassable) {
        this.isPassable = isPassable;
    }

    /**
     * Врозвращает координату X внутренней точки.
     * с учетом расположения изображения на экране
     * @return координата X внутреней точки
     */
    public float getInteralPointX() {
        return img.getDrawImage().getInternalPoint().getX(this);
    }

    /**
     * Врозвращает координату Y внутренней точки.
     * с учетом расположения изображения на экране
     * @return координата Y внутреней точки
     */
    public float getInteralPointY() {
        return img.getDrawImage().getInternalPoint().getY(this);
    }

}
