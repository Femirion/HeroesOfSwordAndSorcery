package ru.infernia.core.engine.loader;

import org.newdawn.slick.util.ResourceLoader;
import ru.infernia.core.engine.image.GameTexture;
import ru.infernia.core.engine.image.TextureInfo;
import ru.infernia.exception.GameException;

import java.io.IOException;
import java.io.InputStream;

public class TextureLoader {
    private static final String RESOURCE_TYPE = "PNG";
    public static final String RESOURCES_PATH = "/src/main/resources/image/%s";

    public GameTexture loadTexture(TextureInfo textureInfo) {
        String name = String.format(RESOURCES_PATH, textureInfo.getFileName());
        try (InputStream in = ResourceLoader.getResourceAsStream(name))  {
            return new GameTexture(textureInfo, org.newdawn.slick.opengl.TextureLoader.getTexture(RESOURCE_TYPE, in));
        } catch (IOException ex) {
            throw new GameException("can not load texture " + textureInfo.getName());
        }
    }
}
