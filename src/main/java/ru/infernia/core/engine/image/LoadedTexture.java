package ru.infernia.core.engine.image;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoadedTexture {
    private String name;
    private String img;
    private int width;
    private int height;
}
