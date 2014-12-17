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
    private int beginWidth;
    private int beginHeigth;
    private TextureStorage texture;

    public Image(int startWidth, int endWidth,
                 int startHeight, int endHeight,
                 TextureStorage texture) {

        this.startWidth = startWidth;
        this.endWidth = endWidth;
        this.startHeight = startHeight;
        this.endHeight = endHeight;
        this.beginWidth = startWidth;
        this.beginHeigth = startHeight;
        this.texture = texture;
    }

    public Image(int startWidth, int endWidth,
                 int startHeight, int endHeight,
                 int beginWidth, int beginHeigth,
                 TextureStorage texture) {

        this.startWidth = startWidth;
        this.endWidth = endWidth;
        this.startHeight = startHeight;
        this.endHeight = endHeight;
        this.beginWidth = beginWidth;
        this.beginHeigth = beginHeigth;
        this.texture = texture;
    }

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
        return getTextureStorage().getTexture();
    }

    public void setTextureStorage(TextureStorage texture) {
        this.texture = texture;
    }

    public int getBeginWidth() {
        return beginWidth;
    }

    public void setBeginWidth(int beginWidth) {
        this.beginWidth = beginWidth;
    }

    public int getBeginHeigth() {
        return beginHeigth;
    }

    public void setBeginHeigth(int beginHeigth) {
        this.beginHeigth = beginHeigth;
    }

    public TextureStorage getTextureStorage() {
        return texture;
    }
}
