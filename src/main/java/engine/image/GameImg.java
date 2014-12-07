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
    private ImageStorage drawImage;

    // базовое изображение. изначально совпадает с drawImage
    private ImageStorage baseImage;

    /**
     * справочник, хранящий соответствие между
     * название действия - активное изоображение
     */
    private Map<String, ImageStorage> activeImages;

    /**
     * Конструктор для неактивного изображения,
     * которое никогда не будет изменяться - ни при наведении мыши,
     * ни при каких других ситуациях
     *
     * @param drawImage изображение, которое будет отрисовываться
     */
    public GameImg(ImageStorage drawImage) {
        this.drawImage = drawImage;
        this.baseImage = drawImage;
    }

    /**
     * Конструктор для изображения, которое будет изменять
     * при некотоорых игровых действиях.
     *
     * @param drawImage изображение, которое будет отрисовываться
     * @param activeImages справочник: Название действия - изображение соответствующее действию
     */
    public GameImg(ImageStorage drawImage,
                   Map<String, ImageStorage> activeImages) {
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


    public ImageStorage getDrawImage() {
        return drawImage;
    }

    public void setDrawImage(ImageStorage drawImage) {
        this.drawImage = drawImage;
    }

    public ImageStorage getBaseImage() {
        return baseImage;
    }

    public void setBaseImage(ImageStorage baseImage) {
        this.baseImage = baseImage;
    }

    public Map<String, ImageStorage> getActiveImages() {
        return activeImages;
    }

    public void setActiveImages(Map<String, ImageStorage> activeImages) {
        this.activeImages = activeImages;
    }

}
