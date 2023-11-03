package ru.infernia.core.engine.storage;

import ru.infernia.core.engine.loader.AnimationLoader;
import ru.infernia.core.engine.wrapper.AnimationInfo;
import ru.infernia.core.engine.wrapper.GameAnimation;
import ru.infernia.core.engine.wrapper.GameImage;
import ru.infernia.core.engine.wrapper.ImageInfo;
import ru.infernia.core.engine.loader.ImageLoader;
import ru.infernia.exception.GameException;
import ru.infernia.utils.JsonUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AnimationStorage {
    private final AnimationLoader animationLoader;
    private final Map<String, GameAnimation> animationInfos = new HashMap<>();

    public AnimationStorage(AnimationLoader animationLoader) {
        this.animationLoader = animationLoader;
        animationInfos.putAll(JsonUtil.loadAnimation().stream()
                .collect(Collectors.toMap(ImageInfo::getName, animationLoader::loadGameAnimation)));
    }

    public GameAnimation getByName(String name) {
        return Optional.ofNullable(animationInfos.get(name))
                .orElseThrow(() -> new GameException("can not find game animation with name=" + name));
    }

    public AnimationInfo getInfo(String name) {
        return Optional.ofNullable(animationInfos.get(name))
                .map(GameAnimation::getInfo)
                .orElseThrow(() -> new GameException("can not find animation info with name=" + name));
    }
}
