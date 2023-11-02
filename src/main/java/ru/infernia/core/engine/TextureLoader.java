package ru.infernia.core.engine;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.ResourceLoader;
import ru.infernia.core.engine.image.GameTexture;
import ru.infernia.exception.GameException;
import ru.infernia.texture.TextureStorage;

import java.io.IOException;
import java.io.InputStream;

public class TextureLoader {

    private static final String RESOURCE_TYPE = "PNG";
    public static final String RESOURCES_PATH = "/src/main/resources/image/%s";

    public GameTexture loadTexture(TextureStorage textureStorage) {
        return loadTexture(textureStorage.getUrl());
    }

    public GameTexture loadTexture(String name) {
        GameTexture texture;
        try (InputStream in = ResourceLoader.getResourceAsStream(name))  {
            texture = new GameTexture(org.newdawn.slick.opengl.TextureLoader.getTexture(RESOURCE_TYPE, in));
        } catch (IOException ex) {
            throw new GameException("can not load texture " + name);
        }
        return texture;
    }

}
