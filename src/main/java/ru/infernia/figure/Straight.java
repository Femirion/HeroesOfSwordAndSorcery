package ru.infernia.figure;

/**
 * Класс прямой линии
 *
 * Created by steam on 14.03.17.
 */
public class Straight {

    private Point start;
    private Point end;

    public Straight(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
}
