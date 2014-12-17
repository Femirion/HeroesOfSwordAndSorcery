package new_engine.entity;

import new_engine.image.Image;
import org.lwjgl.Sys;

/**
 * Анимированный объект игрового мира
 * author Vostryakov Alexander
 */
public class AnimationGameObject extends AbstractGameObject {

    // текущий кадр анимации
    private int frame;

    // общее количество кадров
    private int frameCount;

    // период смены кадров
    private long period;

    // время, прошедшее с момента последней отрисовки
    private long time;

    // число, которое будет добавляться к ширине, для получения нового кадра
    private int addWidth;

    // число, которое будет добавляться в высоте для получения нового кадра
    private int addHeight;

    public AnimationGameObject(long id,
                               float x,
                               float y,
                               int level,
                               Image drawImg,
                               int frame,
                               int frameCount,
                               long period,
                               long time,
                               int addWidth,
                               int addHeight) {

        super(id, x, y, level, drawImg);
        this.frame = frame;
        this.frameCount = frameCount;
        this.period = period;
        this.time = time;
        this.addWidth = addWidth;
        this.addHeight = addHeight;
    }

    public int getFrame() {
        return frame;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public int getFrameCount() {
        return frameCount;
    }

    public void setFrameCount(int count) {
        this.frameCount = count;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public void draw() {
        time = System.currentTimeMillis() - time;
        if (time > period) {
            if (frame > frameCount) {
                frame = 0;
                time -= period;
                Image img = getDrawImg();
                img.setStartWidth(img.getBeginWidth() + addWidth * frame);
                img.setStartHeight(img.getStartHeight() + addHeight * frame);
                img.setEndWidth(img.getBeginWidth() + addWidth * frame);
                img.setEndHeight(img.getStartHeight() + addHeight * frame);
                img.setTextureStorage(img.getTextureStorage());
                this.setDrawImg(img);

            } else {
                time -= period;
                Image img = getDrawImg();
                img.setStartWidth(img.getStartWidth() + addWidth * frame);
                img.setStartHeight(img.getStartHeight() + addHeight * frame);
                img.setEndWidth(img.getEndWidth() + addWidth * frame);
                img.setEndHeight(img.getEndHeight() + addHeight * frame);
                img.setTextureStorage(img.getTextureStorage());
                frame++;
                this.setDrawImg(img);
            }
        }
        super.draw();
    }
}
