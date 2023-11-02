package ru.infernia.core.engine.image;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.newdawn.slick.opengl.Texture;
import ru.infernia.core.engine.TextureLoader;

@Getter
@RequiredArgsConstructor
public class GameTexture {
    private final LoadedTexture loadedTexture;
    private final Texture texture;

    public String getUrl() {
        return String.format(TextureLoader.RESOURCES_PATH, loadedTexture.getImg());
    }
}
