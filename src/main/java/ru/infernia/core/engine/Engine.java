package ru.infernia.core.engine;

import lombok.RequiredArgsConstructor;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import ru.infernia.core.input.GameKeyboard;
import ru.infernia.core.input.GameMouse;
import ru.infernia.entity.GameObject;
import ru.infernia.exception.GameException;
import stub.GeneratorStub;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

@RequiredArgsConstructor
public class Engine {
    private final GameKeyboard keyboard;
    private final GameMouse mouse;
    private List<GameObject> visibleObjects;

    public void start(int width, int height) {
        beginSession(width, height);
        visibleObjects = GeneratorStub.createAnimations();
        while (!Display.isCloseRequested()) {
            // очитстка экрана
            glClear(GL_COLOR_BUFFER_BIT);


            //activeEntity = mouse.mouseClickListener(visibleObjects, activeEntity);
            //mouse.mouseContainsListener(visibleObjects, activeEntity);
            //keyboard.keyListener(activeEntity);

            // отрисуем все видимые объекты
            for (GameObject entity : visibleObjects) {
                entity.draw();
            }

            Display.update();
            Display.sync(60);
        }
        Display.destroy();
    }

    public void beginSession(int width, int height) {
        try {

            Display.setTitle("Heroes of Sword and Sorcery");
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();

            glMatrixMode(GL_PROJECTION);
            glLoadIdentity();
            glOrtho(0, width, height, 0, 1, -1);
            glMatrixMode(GL_MODELVIEW);
            glEnable(GL_TEXTURE_2D);

        } catch (LWJGLException ex) {
            throw new GameException("can not start session", ex);
        }
    }
}
