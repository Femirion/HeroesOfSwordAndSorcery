package ru.infernia.core.engine.image;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.newdawn.slick.opengl.Texture;

@Getter
@RequiredArgsConstructor
public class GameTexture {
    private final TextureInfo info;
    private final Texture texture;
}
