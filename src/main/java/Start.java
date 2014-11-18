import model.GameEntity;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stub.GeneratorStub;

import java.util.List;

import static engine.Engine.*;
/**
 * author Vostryakov Alexander
 */
public class Start {

    private static Logger logger = LoggerFactory.getLogger(Start.class);
    private static List<GameEntity> visibleObjects;

    public Start() {
        try {
            beginSession();
            visibleObjects = GeneratorStub.getVisibleObjects();
            while (!Display.isCloseRequested()) {

                for (GameEntity entity : visibleObjects) {
                    draw(entity.getTexture(), entity.getX(), entity.getY(),
                            32, 32);
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
