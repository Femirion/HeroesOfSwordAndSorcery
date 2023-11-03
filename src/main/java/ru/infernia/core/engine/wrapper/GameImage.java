package ru.infernia.core.engine.wrapper;

import org.newdawn.slick.Image;

public class GameImage {
    private final ImageInfo info;
    private final Image image;

    public GameImage(ImageInfo info, GameTexture texture) {
        this.info = info;
        Image tmp = new Image(texture.getTexture());
        if (info.getStartX() != 0 || info.getStartY() != 0) {
            tmp = tmp.getSubImage(info.getStartX(), info.getStartY(),
                    info.getStartX() + info.getWidth(), info.getStartY() + info.getHeight());
        }
        this.image = tmp;
    }

    public ImageInfo getInfo() {
        return info;
    }

    public void draw(float x, float y) {
        image.draw(x, y, info.getWidth(), info.getHeight());
    }
}
