package ru.infernia.core.engine.image;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import ru.infernia.exception.GameException;

@Getter
@RequiredArgsConstructor
public class GameAnimation {
    private final Animation animation;

    public GameAnimation(String url, int width, int height, int interval) {
        SpriteSheet sprites;
        try {
            sprites = new SpriteSheet(url, width, height);
            this.animation = new Animation(sprites, interval);
        } catch (SlickException e) {
            throw new GameException("can not create animation for " + url);
        }
    }

    public void draw(float x, float y) {
        animation.draw(x, y);
    }
}
