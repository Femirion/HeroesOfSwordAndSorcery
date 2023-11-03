package ru.infernia.entity.map;

import lombok.Data;

import java.util.List;

@Data
public class MapInfo {
    private int width;
    private int height;
    private List<Integer> regions;
}
