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
    private Animation drawImage;

    // базовое изображение. изначально совпадает с drawImage
    private Animation baseImage;

    /**
     * справочник, хранящий соответствие между
     * название действия - активное изоображение
     */
    private Map<String, Animation> activeImages;

    /**
     * Конструктор для неактивного изображения,
     * которое никогда не будет изменяться - ни при наведении мыши,
     * ни при каких других ситуациях
     *
     * @param drawImage изображение, которое будет отрисовываться
     */
    public GameImg(Animation drawImage) {
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
    public GameImg(Animation drawImage,
                   Map<String, Animation> activeImages) {
        this.drawImage = drawImage;
        // изначально совпадает с отрисованным изображеним
        this.baseImage = drawImage;
        this.activeImages = activeImages;
    }

    public int getWidth() {
        return drawImage.getImage().getWidth();
    }

    public int getHeight() {
        return drawImage.getImage().getHeight();
    }


    public Animation getDrawImage() {
        return drawImage;
    }

    public void setDrawImage(Animation drawImage) {
        this.drawImage = drawImage;
    }

    public Animation getBaseImage() {
        return baseImage;
    }

    public void setBaseImage(Animation baseImage) {
        this.baseImage = baseImage;
    }

    public Map<String, Animation> getActiveImages() {
        return activeImages;
    }

    public void setActiveImages(Map<String, Animation> activeImages) {
        this.activeImages = activeImages;
    }

}
