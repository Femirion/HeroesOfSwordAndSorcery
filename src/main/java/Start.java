import model.entities.GameEntity;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stub.GeneratorStub;

import java.util.Collections;
import java.util.List;

import static engine.Engine.*;

/**
 * author Vostryakov Alexander
 */
public class Start {

    private static Logger logger = LoggerFactory.getLogger(Start.class);
    private List<GameEntity> visibleObjects;

    public Start() {
        try {
            beginSession();
            visibleObjects = GeneratorStub.getRandomVisibleObjects();
            Collections.sort(visibleObjects);
            while (!Display.isCloseRequested()) {

                mouseListener();

                for (GameEntity entity : visibleObjects) {
                    draw(entity.getTexture(),
                            entity.getX(),
                            entity.getY(),
                            entity.getWidth(),
                            entity.getHeight()
                    );
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

    public void mouseListener() {
        if (Mouse.isButtonDown(0)) {
            for (GameEntity entity : visibleObjects) {
                if (entity.isInteractive()) {
                    if (Mouse.getX() > entity.getX() &&
                            Mouse.getX() < entity.getX() + entity.getWidth() &&
                            HEIGTH - Mouse.getY() > entity.getY() &&
                            HEIGTH -Mouse.getY() < entity.getY() + entity.getHeight()) {
                        System.out.println(entity.getId());
                    }
                }
            }

        }
    }

}
