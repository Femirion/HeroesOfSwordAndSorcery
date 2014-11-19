package engine;

import org.newdawn.slick.opengl.Texture;

/**
 * author Vostryakov Alexander
 */
public enum ImageStorage {

    // кирпич №1
    BRICK("brick", 32f, 32f, Engine.loadTexture("brick.png"));


    private String name;
    private float widht;
    private float height;
    private Texture texture;


    ImageStorage (String name, float widht, float height, Texture texture) {
        this.name = name;
        this.widht = widht;
        this.height = height;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public float getWidht() {
        return widht;
    }

    public float getHeight() {
        return height;
    }

    public Texture getTexture() {
        return texture;
    }

    public static ImageStorage getImage(String value) {
        for (ImageStorage imageStorage : ImageStorage.values()) {
            if (value.equals(imageStorage.name)) {
                return imageStorage;
            }
        }
        throw new RuntimeException("Не найдена текстура с именем " + value);
    }






}
