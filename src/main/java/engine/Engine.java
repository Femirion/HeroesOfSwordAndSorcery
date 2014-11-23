package engine;

import model.entities.GameEntity;
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
 * Основная класс игрового "движка"
 * author Vostryakov Alexander
 */
public class Engine {

    private static Logger logger = LoggerFactory.getLogger(Engine.class);

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    private Engine(){}

    /**
     * Подготовка к рисованию
     * @throws LWJGLException
     */
    public static void beginSession() throws LWJGLException {
        Display.setTitle("Heroes of Sword and Sorcery");
        Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
        Display.create();

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
    }

    /**
     * Рисование игрового объекта
     * @param entity игровой объект
     */
    public static void draw(GameEntity entity) {
        entity.getImg().getDrawImage().getTexture().bind();
        glTranslatef(entity.getX(), entity.getY(), 0);
        glBegin(GL_QUADS);

        glTexCoord2f(0, 0);
        glVertex2f(0, 0);

        glTexCoord2f(1, 0);
        glVertex2f(entity.getWidth(), 0);

        glTexCoord2f(1, 1);
        glVertex2f(entity.getWidth(), entity.getHeight());

        glTexCoord2f(0, 1);
        glVertex2f(0, entity.getHeight());

        glEnd();
        glLoadIdentity();

    }

    /**
     * Рисование произольного изображения
     * @param texture текстура
     * @param x координата X левого верхнего угла
     * @param y координата Y правого вернехго угла
     * @param width ширина
     * @param height высота
     */
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

    /**
     * Загрузка текструры
     * @param name имя файла в каталоге src/resource/image
     * @return загруженная текстура
     */
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
