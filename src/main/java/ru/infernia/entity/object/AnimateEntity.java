package ru.infernia.entity.object;

import ru.infernia.core.engine.image.GameAnimation;
import ru.infernia.figure.Point;

public class AnimateEntity extends Entity {
    private final GameAnimation animation;
    public AnimateEntity(long id, Point point, int width, int height, int interval, String name, String url) {
        super(id, point, width, height, name);
        this.animation = new GameAnimation(url, width, height, interval);
    }

    @Override
    public void draw() {
        final Point point = getPoint();
        animation.draw(point.getX(), point.getY());
    }
}
