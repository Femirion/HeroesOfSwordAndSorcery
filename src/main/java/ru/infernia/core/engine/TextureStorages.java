package ru.infernia.core.engine;

import ru.infernia.core.engine.image.GameTexture;
import ru.infernia.core.engine.image.TextureInfo;
import ru.infernia.core.util.JsonUtil;
import ru.infernia.exception.GameException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TextureStorages {
    private static final String TEXTURES_PATH = "/src/main/resources/json/textures.json";
    private final TextureLoader loader;
    private final Map<String, GameTexture> textures = new HashMap<>();
    private final Map<String, TextureInfo> textureInfos = new HashMap<>();

    public TextureStorages(TextureLoader loader) {
        this.loader = loader;
        textureInfos.putAll(JsonUtil.loadTexture(TEXTURES_PATH).stream()
                .collect(Collectors.toMap(TextureInfo::getName, v -> v)));
        textures.putAll(textureInfos.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v  -> loader.loadTexture(v.getValue()))));

    }

    public GameTexture getByName(String name) {
        return Optional.ofNullable(textures.get(name))
                .orElseThrow(() -> new GameException("can not find texture with name=" + name));
    }

    public TextureInfo getInfo(String name) {
        return Optional.ofNullable(textureInfos.get(name))
                .orElseThrow(() -> new GameException("can not find texture info with name=" + name));
    }


}
