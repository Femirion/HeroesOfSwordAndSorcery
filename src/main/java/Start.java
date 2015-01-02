import new_engine.entity.AbstractGameObject;
import new_engine.entity.GameObject;
import new_engine.input.GameKeyboard;
import new_engine.input.GameMouse;
import org.lwjgl.opengl.Display;
import stub.GeneratorStub;

import java.util.Collections;
import java.util.List;

import static new_engine.core.Engine.beginSession;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

/**
 * author Vostryakov Alexander
 */
public class Start {

    //private static Logger logger = LoggerFactory.getLogger(Start.class);

    // отображаемые на экране объекты
    private List<AbstractGameObject> visibleObjects;

    public Start() {
        GameKeyboard keyboard = new GameKeyboard();
        GameMouse mouse = new GameMouse();

        beginSession();
        visibleObjects = GeneratorStub.getTwoRollingStars();
        Collections.sort(visibleObjects);
        while (!Display.isCloseRequested()) {
            // очитстка экрана
            glClear(GL_COLOR_BUFFER_BIT);

            // мышь
            //activeEntity = mouse.mouseClickListener(visibleObjects, activeEntity);
            //mouse.mouseContainsListener(visibleObjects, activeEntity);
            // клавиатура
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

    public static void main(String[] args) {
        new Start();
    }


}
