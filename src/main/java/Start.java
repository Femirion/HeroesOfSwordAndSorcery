import engine.input.GameKeyboard;
import engine.input.GameMouse;
import model.entities.GameEntity;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stub.GeneratorStub;

import java.util.Collections;
import java.util.List;

import static engine.Engine.beginSession;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

/**
 * author Vostryakov Alexander
 */
public class Start {

    private static Logger logger = LoggerFactory.getLogger(Start.class);

    // активный объект
    private GameEntity activeEntity;

    // отображаемые на экране объекты
    private List<GameEntity> visibleObjects;

    public Start() {
        try {
            GameKeyboard keyboard = new GameKeyboard();
            GameMouse mouse = new GameMouse();

            beginSession();
            visibleObjects = GeneratorStub.getRandomVisibleObjects();
            Collections.sort(visibleObjects);
            while (!Display.isCloseRequested()) {
                // очитстка экрана
                glClear(GL_COLOR_BUFFER_BIT);

                // мышь
                activeEntity = mouse.mouseClickListener(visibleObjects, activeEntity);
                mouse.mouseContainsListener(visibleObjects, activeEntity);
                // клавиатура
                keyboard.keyListener(activeEntity);

                // отрисуем все видимые объекты
                for (GameEntity entity : visibleObjects) {
                    entity.draw();
                }

                Display.update();
                Display.sync(60);
            }
            Display.destroy();
        } catch (LWJGLException e) {
            logger.error("Exception", e);
        }
    }

    public static void main(String[] args) {
        new Start();
    }


}
