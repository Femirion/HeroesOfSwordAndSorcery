package ru.infernia.texture;

import ru.infernia.exception.NotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TextureMap {
    private static final String ERROR_MSG = "texture with id=%s has not hound in TextureType=%s";
    private Map<String, Map<String, Texture>> maps = new HashMap<>();

    public Texture get(String textureType, String textureId) {
        return Optional.ofNullable(maps.get(textureType))
                .map(t -> t.get(textureId))
                .orElseThrow(() -> new NotFoundException(String.format(ERROR_MSG, textureId, textureType)));
    }

}
