package ru.infernia.entity.object;

import ru.infernia.core.engine.wrapper.GameImage;

public class StaticEntity extends Entity {
    private final GameImage image;

    public StaticEntity(long id, int x, int y, int width, int height, String name, GameImage image) {
        super(id, x, y, width, height, name);
        this.image = image;
    }

    public StaticEntity(long id, int x, int y, String name, GameImage image) {
        super(id, x, y, image.getInfo().getWidth(), image.getInfo().getHeight(), name);
        this.image = image;
    }

    @Override
    public void draw() {
        image.draw(x, y);
    }
}
