package engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glLoadIdentity;

/**
 * author Vostryakov Alexander
 */
public class Engine {

    private static Logger logger = LoggerFactory.getLogger(Engine.class);

    public static final int WIDTH = 600;
    public static final int HEIGTH = 400;

    private Engine(){}

    public static void beginSession() throws LWJGLException {
        Display.setTitle("Fisteria");
        Display.setDisplayMode(new DisplayMode(WIDTH, HEIGTH));
        Display.create();

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, WIDTH, HEIGTH, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
    }

    public static void draw(Texture texture, float x, float y, float width, float height) {
        texture.bind();
        glTranslatef(x, y, 0);
        glBegin(GL_QUADS);

        glTexCoord2f(0, 0);
        glVertex2f(0, 0);

        glTexCoord2f(1, 0);
        glVertex2f(width, 0);

        glTexCoord2f(1, 1);
        glVertex2f(width, height);

        glTexCoord2f(0, 1);
        glVertex2f(0, height);

        glEnd();
        glLoadIdentity();

    }

    public static Texture loadTexture(String name) {
        Texture texture = null;
        InputStream in = ResourceLoader.getResourceAsStream(
                "/src/main/resources/image/" + name);
        try {
            texture = TextureLoader.getTexture("PNG", in);
        } catch (IOException ex) {
            logger.error("Ошибка при загрузке текстуры", ex);
        }
        return texture;
    }

}
