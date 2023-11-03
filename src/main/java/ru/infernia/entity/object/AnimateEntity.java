package ru.infernia.entity.object;

import ru.infernia.core.engine.wrapper.GameAnimation;

public class AnimateEntity extends Entity {
    private final GameAnimation animation;
    public AnimateEntity(long id, int x, int y, GameAnimation gameAnimation) {
        super(id, x, y, gameAnimation.getInfo().getFrameWidth(), gameAnimation.getInfo().getFrameHeight(), gameAnimation.getInfo().getName());
        this.animation = new GameAnimation(gameAnimation.getInfo(), gameAnimation.getSpriteSheet());
    }

    @Override
    public void draw() {
        animation.draw(x, y);
    }
}
