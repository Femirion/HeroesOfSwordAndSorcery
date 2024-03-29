package ru.infernia.core.engine.storage;

import ru.infernia.core.engine.wrapper.GameTexture;
import ru.infernia.core.engine.wrapper.TextureInfo;
import ru.infernia.core.engine.loader.TextureLoader;
import ru.infernia.utils.JsonUtil;
import ru.infernia.exception.GameException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TexturesStorage {
    private static final String TEXTURES_PATH = "/src/main/resources/json/textures.json";
    private final TextureLoader loader;
    private final Map<String, GameTexture> textures = new HashMap<>();

    public TexturesStorage(TextureLoader loader) {
        this.loader = loader;
        textures.putAll(JsonUtil.loadTexture(TEXTURES_PATH).stream()
                .collect(Collectors.toMap(TextureInfo::getName, loader::loadTexture)));

    }

    public GameTexture getByName(String name) {
        return Optional.ofNullable(textures.get(name))
                .orElseThrow(() -> new GameException("can not find texture with name=" + name));
    }

    public TextureInfo getInfo(String name) {
        return Optional.ofNullable(textures.get(name))
                .map(GameTexture::getInfo)
                .orElseThrow(() -> new GameException("can not find texture info with name=" + name));
    }
}
