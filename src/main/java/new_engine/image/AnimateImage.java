package new_engine.image;

import new_engine.texture.TextureStorage;

/**
 * Анимированное игровое изображение
 * 29.12.14.
 */
public class AnimateImage extends Image {

    // число, которое будет добавляться к ширине, для получения нового кадра
    private int addWidth;

    private float beginWidth;

    private float beginHeight;

    public AnimateImage(
            int startWidth,
            int endWidth,
            int startHeight,
            int endHeight,
            int addWidth,
            TextureStorage texture) {

        super(startWidth, endWidth, startHeight, endHeight - 2, texture);
        this.addWidth = addWidth;
        this.beginWidth = startWidth;
        this.beginHeight = startHeight;
    }

    public int getAddWidth() {
        return addWidth;
    }

    public void setAddWidth(int addWidth) {
        this.addWidth = addWidth;
    }

    public float getBeginWidth() {
        return beginWidth;
    }

    public void setBeginWidth(float beginWidth) {
        this.beginWidth = beginWidth;
    }

    public float getBeginHeight() {
        return beginHeight;
    }

    public void setBeginHeight(float beginHeight) {
        this.beginHeight = beginHeight;
    }
}
