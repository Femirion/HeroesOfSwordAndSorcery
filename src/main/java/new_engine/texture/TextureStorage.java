package new_engine.texture;

import new_engine.core.Engine;
import org.newdawn.slick.opengl.Texture;

/**
 * Хранилище текстур
 *
 * author Vostryakov Alexander
 */
public enum TextureStorage {

    BRICK(Engine.loadTexture("brick_texture.png"), 132F, 132F),
    STAR(Engine.loadTexture("star_texture.png"), 153F, 153F),
    ROLLING_STAR(Engine.loadTexture("rolling_star.png"), 920F, 102F),
    SMAL_ROLLING_STAR(Engine.loadTexture("rolling_star.png"), 113F, 27F),
    CAPITAN(Engine.loadTexture("capitan.png"), 900F, 300F);

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
