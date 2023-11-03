package ru.infernia.core.engine.image;

import lombok.Data;

@Data
public class ImageInfo {
    private String name;
    private String texture;
    private int width;
    private int height;
    private int startX;
    private int startY;
}
