package ru.infernia.texture;

import static ru.infernia.core.engine.TextureLoader.RESOURCES_PATH;


public enum TextureStorage {

    BRICK("brick_texture.png", 132F, 132F),
    STAR("star_texture.png", 153F, 153F),
    ROLLING_STAR("rolling_star.png", 920F, 102F),
    SMAL_ROLLING_STAR("rolling_star.png", 113F, 27F),
    CAPITAN("capitan.png", 900F, 300F),
//    BRICK_1("brick-1.png", 200F, 200F),
    CAPITAN2("capitan2.png", 900F, 110F);

    private final String url;
    private final float width;
    private final float height;


    TextureStorage(String url, float width, float height) {
        this.width = width;
        this.height = height;
        this.url = url;
    }

    public String getUrl() {
        return String.format(RESOURCES_PATH, url);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
