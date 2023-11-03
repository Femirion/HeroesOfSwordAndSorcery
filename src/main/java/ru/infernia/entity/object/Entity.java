package ru.infernia.entity.object;

import lombok.Getter;
import lombok.Setter;
import ru.infernia.figure.Point;

@Getter
@Setter
public abstract class Entity implements GameObject {
    protected long id;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected String name;
    protected int layer = 0;

    public Entity(long id, int x, int y, int width, int height, String name) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;
    }

    public Entity(long id, int x, int y, int width, int height, String name, int layer) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;
        this.layer = layer;
    }
}
