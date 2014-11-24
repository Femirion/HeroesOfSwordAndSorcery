package engine.image;

import engine.Engine;
import engine.point.Point;
import org.newdawn.slick.opengl.Texture;
import stub.GeneratorStub;

import java.util.List;

/**
 * Хранилище всех игровых изображений.
 * Позволяет загружать одну текстуру на все объекты,
 * использующие данную текстуру.
 * author Vostryakov Alexander
 */
public enum TextureStorage {

    // звезда активная
    STAR("star", 80, 80,
            Engine.loadTexture("star.png"),
            GeneratorStub.getStarPointList(),
            new Point(25F, 25F)),
    // звезда №1 неактивный
    ACTIVE_STAR("active_star", 80, 80,
            Engine.loadTexture("active_star.png"),
            GeneratorStub.getStarPointList(),
            new Point(25F, 25F)),
    // кирпич неактивный
    BRICK("brick", 32, 32,
            Engine.loadTexture("brick.png"),
            GeneratorStub.generateBrickPoints(),
            new Point(16F, 16F)),
    // кирпич активный
    ACTIVE_BRICK("active_brick", 32, 32,
            Engine.loadTexture("active_brick.png"),
            GeneratorStub.generateBrickPoints(),
            new Point(16F, 16F));


    // имя. может быть произвольным
    private String name;
    // ширина текстуры
    private int widht;
    // высота текстуры
    private int height;
    // сама текстура
    private Texture texture;
    // вершины кривой, ограничивающей сложное изображение
    private List<Point> points;
    /**
     * Внутрення точка изображения. используется
     * для того, чтобы определять положение другой точки
     * относительно изображения (внутри/снаружи)
     */
    private Point internalPoint;

    /**
     * Активное игровое изображение
     *
     * @param name имя изображения
     * @param widht ширина
     * @param height высота
     * @param texture текстура
     * @param points набор вершин текстуры (для сложной формы изображения)
     * @param internalPoint внутрення точка (для определния принадлежности другой точки изображению)
     */
    TextureStorage(String name, int widht, int height,
                   Texture texture, List<Point> points, Point internalPoint) {
        this(name, widht, height, texture);
        this.points = points;
        this.internalPoint = internalPoint;
    }

    /**
     * Статичное игровое изображение
     *
     * @param name имя изображения
     * @param widht ширина
     * @param height высота
     * @param texture текстура
     */
    TextureStorage(String name, int widht, int height, Texture texture) {
        this.name = name;
        this.widht = widht;
        this.height = height;
        this.texture = texture;
        this.points = null;
        this.internalPoint = null;

    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return widht;
    }

    public int getHeight() {
        return height;
    }

    public Texture getTexture() {
        return texture;
    }

    public List<Point> getPoints() {
        if (points == null) {
            throw new IllegalArgumentException("Вы пытаетесь получить список активных точек для статичного изображения");
        }
        return points;
    }

    public Point getInternalPoint() {
        if (points == null) {
            throw new IllegalArgumentException("Вы пытаетесь получить внутренюю для статичного изображения");
        }
        return internalPoint;
    }

    /**
     * Возвращает изображение по названию
     *
     * @param value название
     * @return загруженное изображение
     */
    public static TextureStorage getImage(String value) {
        for (TextureStorage textureStorage : TextureStorage.values()) {
            if (value.equals(textureStorage.name)) {
                return textureStorage;
            }
        }
        throw new IllegalArgumentException("Не найдено изображение с именем " + value);
    }

}
