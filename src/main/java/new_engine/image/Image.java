package new_engine.image;

import new_engine.texture.TextureStorage;
import org.newdawn.slick.opengl.Texture;

/**
 * игровое изображение
 * author Vostryakov Alexander
 */
public class Image {

    private float startWidth;
    private float endWidth;
    private float startHeight;
    private float endHeight;
    private TextureStorage texture;

    public Image(int startWidth, int endWidth,
                 int startHeight, int endHeight,
                 TextureStorage texture) {

        this.startWidth = startWidth;
        this.endWidth = endWidth;
        this.startHeight = startHeight;
        this.endHeight = endHeight;
        this.texture = texture;
    }

    public float getStartWidth() {
        return startWidth;
    }

    public void setStartWidth(float startWidth) {
        this.startWidth = startWidth;
    }

    public float getEndWidth() {
        return endWidth;
    }

    public void setEndWidth(float endWidth) {
        this.endWidth = endWidth;
    }

    public float getStartHeight() {
        return startHeight;
    }

    public void setStartHeight(float startHeight) {
        this.startHeight = startHeight;
    }

    public float getEndHeight() {
        return endHeight;
    }

    public void setEndHeight(float endHeight) {
        this.endHeight = endHeight;
    }

    public Texture getTexture() {
        return getTextureStorage().getTexture();
    }

    public void setTextureStorage(TextureStorage texture) {
        this.texture = texture;
    }

    public TextureStorage getTextureStorage() {
        return texture;
    }
}
