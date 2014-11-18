import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.lwjgl.opengl.GL11.*;
import static engine.Engine.*;
/**
 * author Vostryakov Alexander
 */
public class Start {

    private static Logger logger = LoggerFactory.getLogger(Start.class);

    public Start() {
        try {
            beginSession();

            Texture texture1 = loadTexture("brick.png");
            Texture texture2 = loadTexture("brick.png");

            while (!Display.isCloseRequested()) {
                draw(texture1, 0, 0, 32, 32);
                draw(texture2, 0, 32, 32, 32);

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
