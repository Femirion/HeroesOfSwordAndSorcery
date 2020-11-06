package ru.infernia.texture;

/**
 * Хранилище текстур
 *
 * author Vostryakov Alexander
 */
public enum TextureStorage {

    BRICK("brick_texture.png", 132F, 132F),
    STAR("star_texture.png", 153F, 153F),
    ROLLING_STAR("rolling_star.png", 920F, 102F),
    SMAL_ROLLING_STAR("rolling_star.png", 113F, 27F),
    CAPITAN("capitan.png", 900F, 300F),
    BRICK_1("brick-1.png", 200F, 200F),
    CAPITAN2("capitan2.png", 900F, 110F);

    // сама текстура
    private final Texture texture = new Texture();
    private final String url = "";
    private final float width = 200;
    private final float height = 200;


    TextureStorage(String url, float width, float height) {
//        this.texture = Engine.loadTexture(url);
//        this.width = width;
//        this.height = height;
//        this.url = url;
    }

    public String getUrl() {
//        return String.format(RESOURCES_PATH, url);
        return "";
    }

    public Texture getTexture() {
        return texture;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
