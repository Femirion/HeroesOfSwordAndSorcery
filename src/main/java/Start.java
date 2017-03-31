import new_engine.input.GameKeyboard;
import new_engine.input.GameMouse;
import org.apache.log4j.Logger;
import org.lwjgl.opengl.Display;
import ru.infernia.entity.GameObject;
import stub.GeneratorStub;

import java.util.List;
import java.util.stream.Collectors;

import static new_engine.core.Engine.beginSession;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

/**
 * author Vostryakov Alexander
 */
public class Start {

    private static final Logger log = Logger.getLogger(Start.class);

    // отображаемые на экране объекты
    private List<GameObject> visibleObjects;

    public Start() {
        GameKeyboard keyboard = new GameKeyboard();
        GameMouse mouse = new GameMouse();

        beginSession();
        visibleObjects = GeneratorStub.createAnimateStub();

        visibleObjects = visibleObjects.stream()
                .sorted((x, y) -> Integer.compare(x.getLayer(), y.getLayer()))
                .collect(Collectors.toList());


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
