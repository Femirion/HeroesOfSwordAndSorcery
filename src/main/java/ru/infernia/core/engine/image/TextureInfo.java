package ru.infernia.core.engine.image;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.infernia.core.engine.TextureLoader;

@Data
@RequiredArgsConstructor
public class TextureInfo {
    private String name;
    private String img;
    private int width;
    private int height;

    public String getUrl() {
        return String.format(TextureLoader.RESOURCES_PATH, img);
    }
}
