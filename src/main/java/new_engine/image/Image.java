package new_engine.image;

import new_engine.texture.TextureStorage;
import org.newdawn.slick.opengl.Texture;

/**
 * author Vostryakov Alexander
 */
public class Image {

    private int startWidth;
    private int endWidth;
    private int startHeight;
    private int endHeight;
    private TextureStorage texture;

    public int getStartWidth() {
        return startWidth;
    }

    public void setStartWidth(int startWidth) {
        this.startWidth = startWidth;
    }

    public int getEndWidth() {
        return endWidth;
    }

    public void setEndWidth(int endWidth) {
        this.endWidth = endWidth;
    }

    public int getStartHeight() {
        return startHeight;
    }

    public void setStartHeight(int startHeight) {
        this.startHeight = startHeight;
    }

    public int getEndHeight() {
        return endHeight;
    }

    public void setEndHeight(int endHeight) {
        this.endHeight = endHeight;
    }

    public Texture getTexture() {
        return getTexture();
    }

    public void setTextureStorage(TextureStorage texture) {
        this.texture = texture;
    }

    public TextureStorage getTextureStorage() {
        return texture;
    }
}
