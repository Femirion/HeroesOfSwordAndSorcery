package ru.infernia.entity.object;

import ru.infernia.figure.Point;

public interface GameObject {
    void draw();
    long getId();
    int getLayer();
    String getName();
    int getX();
    int getY();
    int getWidth();
    int getHeight();
}
