package ru.infernia.figure;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {
    private int x;
    private int y;

    /*

    *//**
     * Возвращает координату X точки,
     * с учетом расположения на экране
     * @param entity игровой объект
     * @return координата X точки с учетом расположения объекта
     *//*
    public float getX(GameEntity entity) {
        return x  + entity.getX();
    }

    *//**
     * Возвращает координату Y точки,
     * с учетом расположения на экране
     * @param entity игровой объект
     * @return координата Y точки с учетом расположения объекта
     *//*
    public float getY(GameEntity entity) {
        return y + entity.getY();
    }*/
}
