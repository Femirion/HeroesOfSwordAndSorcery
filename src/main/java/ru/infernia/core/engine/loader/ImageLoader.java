package ru.infernia.core.engine.loader;

import lombok.RequiredArgsConstructor;
import ru.infernia.core.engine.image.GameImage;
import ru.infernia.core.engine.image.ImageInfo;
import ru.infernia.core.engine.storage.TexturesStorage;
import ru.infernia.utils.JsonUtil;

import java.util.List;

@RequiredArgsConstructor
public class ImageLoader {
    private final TexturesStorage texturesStorage;

    public List<ImageInfo> loadImages() {
        return JsonUtil.loadImages();
    }

    public GameImage loadGameImage(ImageInfo imageInfo) {
        return new GameImage(imageInfo, texturesStorage.getByName(imageInfo.getTexture()));
    }
}
