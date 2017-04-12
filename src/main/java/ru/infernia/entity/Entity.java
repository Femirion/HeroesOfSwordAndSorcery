package ru.infernia.entity;

import ru.infernia.figure.Point;

/**
 * Простая сущность
 *
 * Created by steam on 31.03.17.
 */
public abstract class Entity implements GameObject {

    protected Point point;
    protected int width;
    protected int height;
    protected String name;
    protected int layer = 0;

    public Entity(Point point, int width, int height, String name) {
        this.point = point;
        this.width = width;
        this.height = height;
        this.name = name;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }
}
