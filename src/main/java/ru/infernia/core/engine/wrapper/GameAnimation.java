package ru.infernia.core.engine.wrapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.newdawn.slick.Animation;

@Getter
@RequiredArgsConstructor
public class GameAnimation {
    private final AnimationInfo info;
    private final Animation animation;
    private final GameSpriteSheet spriteSheet;

    public GameAnimation(AnimationInfo info, GameSpriteSheet spriteSheet) {
        this.info = info;
        this.spriteSheet = spriteSheet;
        this.animation = new Animation(spriteSheet.getSprites(), info.getInterval());
    }

    public void draw(float x, float y) {
        animation.draw(x, y);
    }
}
