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
            TextureStorage texture) {

        super(startWidth, endWidth - 1, startHeight, endHeight - 1, texture);
        this.addWidth = endWidth - startWidth;
        this.beginWidth = startWidth;
        this.beginHeight = startHeight;
    }

    public int getAddWidth() {
        return addWidth;
    }

    public float getBeginWidth() {
        return beginWidth;
    }

    public float getBeginHeight() {
        return beginHeight;
    }

}
