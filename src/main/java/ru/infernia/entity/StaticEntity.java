package ru.infernia.entity;

import ru.infernia.figure.Point;
import ru.infernia.core.engine.image.GameImage;

/**
 * StaticEntity
 * <p>
 * Created by steam on 12.04.17.
 */
public class StaticEntity extends Entity {
    private final GameImage image;

    public StaticEntity(Point point, int width, int height, String name, GameImage image) {
        super(point, width, height, name);
        this.image = image;
    }

    @Override
    public void draw() {
        image.draw(point.getX(), point.getY(), width, height);
    }
}
