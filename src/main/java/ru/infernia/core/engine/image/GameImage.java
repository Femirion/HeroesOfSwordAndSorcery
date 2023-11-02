package ru.infernia.core.engine.image;

import lombok.RequiredArgsConstructor;
import org.newdawn.slick.Image;

@RequiredArgsConstructor
public class GameImage {
    private final Image image;

    public GameImage(GameTexture texture) {
        this.image = new Image(texture.getTexture());
    }

    public void draw(float x, float y, float width, float height) {
        image.draw(x, y, width, height);
    }
}