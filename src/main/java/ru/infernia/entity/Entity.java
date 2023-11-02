package ru.infernia.entity;

import lombok.Getter;
import lombok.Setter;
import ru.infernia.figure.Point;

@Getter
@Setter
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

    public Entity(Point point, int width, int height, String name, int layer) {
        this.point = point;
        this.width = width;
        this.height = height;
        this.name = name;
        this.layer = layer;
    }
}
