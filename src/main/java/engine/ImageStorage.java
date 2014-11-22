package engine;

import org.newdawn.slick.opengl.Texture;

/**
 * Хранилище всех игровых изображений.
 * Позволяет загружать одну текстуру на все объекты,
 * использующие данную текстуру.
 *
 * author Vostryakov Alexander
 */
public enum ImageStorage {

    // кирпич №1
    BRICK("brick", 32, 32, Engine.loadTexture("brick.png")),
    // активный кирпич
    ACTIVE_BRICK("active_brick", 32, 32, Engine.loadTexture("active_brick.png"));

    // имя. может быть произвольным
    private String name;
    // ширина текстуры
    private int widht;
    // высота текстуры
    private int height;
    // сама текстура
    private Texture texture;


    ImageStorage (String name, int widht, int height, Texture texture) {
        this.name = name;
        this.widht = widht;
        this.height = height;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public int getWidht() {
        return widht;
    }

    public int getHeight() {
        return height;
    }

    public Texture getTexture() {
        return texture;
    }

    /**
     * Возвращает изображение по названию
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
