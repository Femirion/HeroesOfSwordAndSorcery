package model.entities;

import engine.Engine;
import engine.ImageStorage;
import engine.Point;

import java.util.List;
import java.util.Map;

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

    // простое изображение
    private ImageStorage defaultImage;

    // неактивное изображение
    private ImageStorage unactiveImage;

    // справочник, хранящий соответствие между
    // название действия - активное изоображение
    private Map<String, ImageStorage> activeImages;

    // справочник, хранящий соответствия между
    // навзанием действия - список точек.
    // Используется для проверки попадает ли точка в сложную область,
    // созданную списком вершин области
    private Map<String, List<Point>> points;

    // слой для определения порядка отрисовки объектов
    private byte level;

    // флаг, показывающий, является ли объект интерактивным
    private boolean isInteractive = false;

    /**
     * Конструктор игрового объекта
     * @param id идентификатор
     * @param x координата X
     * @param y координата Y
     * @param wx координата X в игровом мире
     * @param wy координата Y в игровом мире
     * @param image изображение
     * @param level слой
     */
    public GameEntity(long id, float x, float y, float wx, float wy,
                      ImageStorage image, byte level) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.wx = wx;
        this.wy = wy;
        this.defaultImage = image;
        this.activeImages = null;
        points = null;
        this.level = level;
        // такой объект считается неинтерактивным поумолчанию
        this.isInteractive = false;
    }

    /**
     * Более продвинуты конструктор
     * @param id идентификатор объекта
     * @param x координата X
     * @param y координата Y
     * @param wx координата X в игровом мире
     * @param wy координата Y в игровом мире
     * @param image изображение
     * @param activeImages справочник активных изображений
     * @param points справочник вершин изображений
     * @param level слой
     * @param isInteractive флаг, показывающий, является ли данный объект интерактивным
     */
    public GameEntity(long id, float x, float y, float wx, float wy,
                      ImageStorage image, Map<String, ImageStorage> activeImages,
                      Map<String, List<Point>> points, byte level,
                      boolean isInteractive) {
        this(id, x, y, wx, wy, image, level);
        this.unactiveImage = image;
        this.activeImages = activeImages;
        this.points = points;
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
        return defaultImage.getWidht();
    }

    public float getHeight() {
        return defaultImage.getHeight();
    }

    public ImageStorage getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(ImageStorage defaultImage) {
        this.defaultImage = defaultImage;
    }

    public ImageStorage getUnactiveImage() {
        return unactiveImage;
    }

    public void setUnactiveImage(ImageStorage unactiveImage) {
        this.unactiveImage = unactiveImage;
    }

    public Map<String, ImageStorage> getActiveImage() {
        return activeImages;
    }

    public void setActiveImage(Map<String, ImageStorage> activeImages) {
        this.activeImages = activeImages;
    }

    public Map<String, List<Point>> getPoints() {
        return points;
    }

    public void setPoints(Map<String, List<Point>> points) {
        this.points = points;
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

    public boolean contains(float x, float y) {
        return  x > this.getX() &&
                x < this.getX() + this.getWidth() &&
                HEIGHT - y > this.getY() &&
                HEIGHT - y < this.getY() + this.getHeight();

    }

}
