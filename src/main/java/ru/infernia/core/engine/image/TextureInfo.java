package ru.infernia.core.engine.image;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.infernia.core.engine.loader.TextureLoader;

@Data
@RequiredArgsConstructor
public class TextureInfo {
    private String name;
    private String fileName;
    private int width;
    private int height;

    public String getUrl() {
        return String.format(TextureLoader.RESOURCES_PATH, fileName);
    }
}
