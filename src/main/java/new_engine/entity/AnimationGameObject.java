package new_engine.entity;

import new_engine.image.AnimateImage;
import new_engine.image.Image;
import org.lwjgl.Sys;

/**
 * Анимированный объект игрового мира
 *
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

    public AnimationGameObject(long id,
                               float x,
                               float y,
                               int level,
                               AnimateImage drawImg,
                               int frame,
                               int frameCount,
                               long period,
                               long time
    ) {
        super(id, x, y, level, drawImg);
        this.frame = frame;
        this.frameCount = frameCount;
        this.period = period;
        this.time = time;
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
        // получаем текущее время
        long currenctTime = System.currentTimeMillis() - time;
        // если текущее время больше чем период отрисовки анимации
        // тогда нужно отрисовать новый кадр
        if (currenctTime > period) {
            // если текущий кадр >= чем кол-во кадров
            // тогда нужно отрисовать первый кадр
            if (frame >= frameCount) {
                frame = 1;
                time = System.currentTimeMillis();
                AnimateImage img = (AnimateImage) getDrawImg();
                img.setStartWidth(img.getBeginWidth());
                img.setStartHeight(img.getBeginHeight());
                img.setEndWidth(img.getBeginWidth() + img.getAddWidth());
                img.setEndHeight(img.getEndHeight());
                this.setDrawImg(img);
                super.draw();
            } else {
                time = System.currentTimeMillis();
                AnimateImage img = (AnimateImage) getDrawImg();
                img.setStartWidth(img.getStartWidth() + img.getAddWidth() + 1);
                img.setStartHeight(img.getStartHeight());
                img.setEndWidth(img.getStartWidth() + img.getAddWidth());
                img.setEndHeight(img.getEndHeight());
                frame++;
                this.setDrawImg(img);
                super.draw();
            }

            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        // img.getEndWidth()время отрисовать анимацию не пришло,
        // просто отрисуем текущий кадр еще раз
        } else {
            super.draw();
        }

    }
}
