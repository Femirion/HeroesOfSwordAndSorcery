package ru.infernia.core.engine;

import lombok.RequiredArgsConstructor;
import ru.infernia.core.engine.image.GameTexture;
import ru.infernia.core.engine.image.LoadedTexture;
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

    public TextureStorages(TextureLoader loader) {
        this.loader = loader;
        textures.putAll(JsonUtil.loadTexture(TEXTURES_PATH).stream()
                .collect(Collectors.toMap(LoadedTexture::getName, loader::loadTexture)));

    }

    public GameTexture getByName(String name) {
        return Optional.ofNullable(textures.get(name))
                .orElseThrow(() -> new GameException("can not find texture with name=" + name));
    }


}
