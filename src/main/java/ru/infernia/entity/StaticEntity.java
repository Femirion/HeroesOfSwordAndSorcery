package ru.infernia.entity;

import ru.infernia.figure.Point;

/**
 * StaticEntity
 * <p>
 * Created by steam on 12.04.17.
 */
public class StaticEntity extends Entity {


    public StaticEntity(Point point, int width, int height, String name) {
        super(point, width, height, name);
//        this.image = image;
    }

    @Override
    public void draw() {
//        image.draw(point.getX(), point.getY(), width, height);
    }
}
