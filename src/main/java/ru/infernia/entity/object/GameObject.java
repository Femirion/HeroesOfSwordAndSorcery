package ru.infernia.entity.object;

import ru.infernia.figure.Point;

public interface GameObject {

    void draw();

    int getLayer();

    String getName();

    Point getPoint();

    int getWidth();

    int getHeight();

}
