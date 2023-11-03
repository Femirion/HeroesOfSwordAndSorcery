package ru.infernia.entity.object;

import ru.infernia.figure.Point;
import ru.infernia.core.engine.image.GameImage;

public class StaticEntity extends Entity {
    private final GameImage image;

    public StaticEntity(Point point, int width, int height, String name, GameImage image) {
        super(point, width, height, name);
        this.image = image;
    }

    @Override
    public void draw() {
        image.draw(point.getX(), point.getY());
    }
}