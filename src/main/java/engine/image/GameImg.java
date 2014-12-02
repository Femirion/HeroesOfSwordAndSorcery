package engine.image;

import engine.point.Point;

import java.util.Map;

/**
 * author Vostryakov Alexander
 *
 * Класс, хранящий набор изображений для
 */
public class GameImg {

    /**
     * отображаемое изображение
     */
    private TextureStorage drawImage;

    // базовое изображение. изначально совпадает с drawImage
    private TextureStorage baseImage;

    /**
     * справочник, хранящий соответствие между
     * название действия - активное изоображение
     */
    private Map<String, TextureStorage> activeImages;

    /**
     * Конструктор для неактивного изображения,
     * которое никогда не будет изменяться - ни при наведении мыши,
     * ни при каких других ситуациях
     *
     * @param drawImage изображение, которое будет отрисовываться
     */
    public GameImg(TextureStorage drawImage) {
        this.drawImage = drawImage;
    }

    /**
     * Конструктор для изображения, которое будет изменять
     * при некотоорых игровых действиях.
     *
     * @param drawImage изображение, которое будет отрисовываться
     * @param activeImages справочник: Название действия - изображение соответствующее действию
     */
    public GameImg(TextureStorage drawImage,
                   Map<String, TextureStorage> activeImages) {
        this.drawImage = drawImage;
        // изначально совпадает с отрисованным изображеним
        this.baseImage = drawImage;
        this.activeImages = activeImages;
    }

    public int getWidth() {
        return drawImage.getWidth();
    }

    public int getHeight() {
        return drawImage.getHeight();
    }


    public TextureStorage getDrawImage() {
        return drawImage;
    }

    public void setDrawImage(TextureStorage drawImage) {
        this.drawImage = drawImage;
    }

    public TextureStorage getBaseImage() {
        return baseImage;
    }

    public void setBaseImage(TextureStorage baseImage) {
        this.baseImage = baseImage;
    }

    public Map<String, TextureStorage> getActiveImages() {
        return activeImages;
    }

    public void setActiveImages(Map<String, TextureStorage> activeImages) {
        this.activeImages = activeImages;
    }

}
