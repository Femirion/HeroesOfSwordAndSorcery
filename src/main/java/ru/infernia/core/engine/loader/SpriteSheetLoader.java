package ru.infernia.core.engine.loader;

import lombok.RequiredArgsConstructor;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import ru.infernia.core.engine.storage.TexturesStorage;
import ru.infernia.core.engine.wrapper.AnimationInfo;
import ru.infernia.core.engine.wrapper.GameSpriteSheet;
import ru.infernia.core.engine.wrapper.TextureInfo;
import ru.infernia.exception.GameException;

@RequiredArgsConstructor
public class SpriteSheetLoader {
    private final TexturesStorage texturesStorage;

    public GameSpriteSheet loadGameSpriteSheet(AnimationInfo info) {
        TextureInfo textureInfo = texturesStorage.getInfo(info.getTexture());
        try {
            SpriteSheet sprites = new SpriteSheet(textureInfo.getUrl(), info.getFrameHeight(), info.getFrameWidth());
            return new GameSpriteSheet(sprites);
        } catch (SlickException e) {
            throw new GameException("can not create animation for " + info.getTexture());
        }
    }
}
