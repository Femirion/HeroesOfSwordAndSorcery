package ru.infernia.entity;

import org.apache.log4j.Logger;
import ru.infernia.figure.Point;

/**
 * Анимированная сущность
 * <p>
 * Created by steam on 31.03.17.
 */
public class AnimateEntity extends Entity {

    private static final Logger log = Logger.getLogger(AnimateEntity.class);

//    private SpriteSheet sprites;
//    private Animation animation;

    public AnimateEntity(Point point, int width, int height, int interval, String name, String url) {
        super(point, width, height, name);
//        try {
//            this.sprites = new SpriteSheet(url, width, height);
//
//        } catch (SlickException e) {
//            log.error(String.format("Ошибка при инициализации сущности %s", name));
//        }
//        this.animation = new Animation(sprites, interval);
    }

    @Override
    public void draw() {
        final Point point = getPoint();
//        animation.draw(point.getX(), point.getY());
    }
}
