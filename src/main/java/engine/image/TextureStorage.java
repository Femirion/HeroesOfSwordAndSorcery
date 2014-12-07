package engine.image;

import engine.Engine;
import org.newdawn.slick.opengl.Texture;

/**
 * Хранилище текстур
 *
 * author Vostryakov Alexander
 */
public enum TextureStorage {

    BRICK(Engine.loadTexture("TEST.png"), 132F, 132F);

    // сама текстура
    private Texture texture;
    private float width;
    private float height;


    TextureStorage(Texture texture, float width, float height) {
        this.texture = texture;
        this.width = width;
        this.height = height;
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
