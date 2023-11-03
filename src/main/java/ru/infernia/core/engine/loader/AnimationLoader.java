package ru.infernia.core.engine.loader;

import lombok.RequiredArgsConstructor;
import ru.infernia.core.engine.wrapper.AnimationInfo;
import ru.infernia.core.engine.wrapper.GameAnimation;
import ru.infernia.utils.JsonUtil;

import java.util.List;

@RequiredArgsConstructor
public class AnimationLoader {
    private final SpriteSheetLoader spriteSheetLoader;

    public List<AnimationInfo> loadAnimation() {
        return JsonUtil.loadAnimation();
    }

    public GameAnimation loadGameAnimation(AnimationInfo info) {
        return new GameAnimation(info, spriteSheetLoader.loadGameSpriteSheet(info));
    }
}
