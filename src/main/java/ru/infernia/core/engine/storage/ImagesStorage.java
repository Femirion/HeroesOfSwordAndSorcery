package ru.infernia.core.engine.storage;

import ru.infernia.core.engine.image.GameImage;
import ru.infernia.core.engine.image.ImageInfo;
import ru.infernia.core.engine.loader.ImageLoader;
import ru.infernia.exception.GameException;
import ru.infernia.utils.JsonUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ImagesStorage {
    private final ImageLoader imageLoader;
    private final Map<String, GameImage> imageInfos = new HashMap<>();

    public ImagesStorage(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
        imageInfos.putAll(JsonUtil.loadImages().stream()
                .collect(Collectors.toMap(ImageInfo::getName, imageLoader::loadGameImage)));
    }

    public GameImage getByName(String name) {
        return Optional.ofNullable(imageInfos.get(name))
                .orElseThrow(() -> new GameException("can not find game image with name=" + name));
    }

    public ImageInfo getInfo(String name) {
        return Optional.ofNullable(imageInfos.get(name))
                .map(GameImage::getInfo)
                .orElseThrow(() -> new GameException("can not find image info with name=" + name));
    }
}
