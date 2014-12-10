package engine.image;

import engine.point.Point;
import org.newdawn.slick.opengl.Texture;
import stub.GeneratorStub;

import java.util.List;

/**
 * Хранитель конктретных игровых изображений.
 * Вытаскивает из листа спрайтов конкретный спрайт
 * author Vostryakov Alexander
 */
public enum ImageStorage {

    // кирпич неактивный
    BRICK_1("brick",
            0, 32,
            0, 32,
            TextureStorage.BRICK,
            GeneratorStub.generateBrickPoints(),
            new Point(16F, 16F)),

    // кирпич активный
    ACTIVE_BRICK_1("active_brick",
            0, 32,
            33, 65,
            TextureStorage.BRICK,
            GeneratorStub.generateBrickPoints(),
            new Point(16F, 16F)),

    // кирпич неактивный
    BRICK_2("brick",
            33, 66,
            0, 32,
            TextureStorage.BRICK,
            GeneratorStub.generateBrickPoints(),
            new Point(16F, 16F)),

    // кирпич активный
    ACTIVE_BRICK_2("active_brick",
            33, 66,
            33, 65,
            TextureStorage.BRICK,
            GeneratorStub.generateBrickPoints(),
            new Point(16F, 16F)),

    STAR("star",
            0, 50,
            0, 50,
            TextureStorage.STAR,
            GeneratorStub.getStarPointList(),
            new Point(26F, 26F)),

    ACTIVE_STAR("active_star",
            52, 101,
            0, 50,
            TextureStorage.STAR,
            GeneratorStub.getStarPointList(),
            new Point(26F, 26F));

    // имя. может быть произвольным
    private String name;
    private int startWidth;
    private int endWidth;
    private int startHeight;
    private int endHeight;

    private TextureStorage texture;

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
     * @param name          имя изображения
     * @param startWidth    начальная точка изображения (ширина)
     * @param endWidth      конечная точка изображения (ширина)
     * @param startHeight   начальная точка изображения (высота)
     * @param endHeight     конечная точка изображения (высота)
     * @param texture       текстура
     * @param points        набор вершин текстуры (для сложной формы изображения)
     * @param internalPoint внутрення точка (для определния принадлежности другой точки изображению)
     */
    ImageStorage(String name, int startWidth, int endWidth,
                 int startHeight, int endHeight, TextureStorage texture,
                 List<Point> points, Point internalPoint) {
        this(name, startWidth, endWidth, startHeight, endHeight, texture);
        this.points = points;
        this.internalPoint = internalPoint;
    }

    /**
     * Статичное игровое изображение
     *
     * @param name        имя изображения
     * @param startWidth  начальная точка изображения (ширина)
     * @param endWidth    конечная точка изображения (ширина)
     * @param startHeight начальная точка изображения (высота)
     * @param endHeight   конечная точка изображения (высота)
     * @param texture     текстура
     */
    ImageStorage(String name, int startWidth, int endWidth,
                 int startHeight, int endHeight, TextureStorage texture) {
        this.name = name;
        this.startWidth = startWidth;
        this.endWidth = endWidth;
        this.startHeight = startHeight;
        this.endHeight = endHeight;
        this.texture = texture;
        this.points = null;
        this.internalPoint = null;

    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return endWidth - startWidth;
    }

    public int getHeight() {
        return endHeight - startHeight;
    }

    public Texture getTexture() {
        return texture.getTexture();
    }

    public TextureStorage getTextureStorage() {
        return texture;
    }

    public List<Point> getPoints() {
        if (points == null) {
            throw new IllegalArgumentException(
                    "Вы пытаетесь получить список активных точек для статичного изображения");
        }
        return points;
    }

    public Point getInternalPoint() {
        if (points == null) {
            throw new IllegalArgumentException(
                    "Вы пытаетесь получить внутренюю для статичного изображения");
        }
        return internalPoint;
    }

    public int getStartWidth() {
        return startWidth;
    }

    public int getEndWidth() {
        return endWidth;
    }

    public int getStartHeight() {
        return startHeight;
    }

    public int getEndHeight() {
        return endHeight;
    }

    /**
     * Возвращает изображение по названию
     *
     * @param value название
     * @return загруженное изображение
     */
    public static ImageStorage getImage(String value) {
        for (ImageStorage imageStorage : ImageStorage.values()) {
            if (value.equals(imageStorage.name)) {
                return imageStorage;
            }
        }
        throw new IllegalArgumentException("Не найдено изображение с именем " + value);
    }

}
