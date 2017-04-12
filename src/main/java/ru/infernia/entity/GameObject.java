package ru.infernia.entity;

import ru.infernia.figure.Point;

/**
 * GameObject
 *
 * Created by steam on 31.03.17.
 */
public interface GameObject {

    void draw();

    int getLayer();

    String getName();

    Point getPoint();

    int getWidth();

    int getHeight();

}
