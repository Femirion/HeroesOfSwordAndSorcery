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
     *
     * @param entity игровой объект
     */
    public static void draw(GameEntity entity) {
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        entity.getImg().getDrawImage().getTexture().bind();

        glTranslatef(entity.getX(), entity.getY(), 0);
        glBegin(GL_QUADS);

        // TODO временный код
        glTexCoord2f(entity.getDrawImage().getStartWidth() /
                        entity.getDrawImage().getTextureStorage().getWidth(),
                entity.getDrawImage().getStartHeight() /
                        entity.getDrawImage().getTextureStorage().getHeight());
        glVertex2f(0, 0);

        glTexCoord2f(entity.getDrawImage().getEndWidth() /
                        entity.getDrawImage().getTextureStorage().getWidth(),
                entity.getDrawImage().getStartHeight() /
                        entity.getDrawImage().getTextureStorage().getHeight());
        glVertex2f(entity.getWidth(), 0);

        glTexCoord2f(entity.getDrawImage().getEndWidth() /
                        entity.getDrawImage().getTextureStorage().getWidth(),
                entity.getDrawImage().getEndHeight() /
                        entity.getDrawImage().getTextureStorage().getHeight());
        glVertex2f(entity.getWidth(), entity.getHeight());

        glTexCoord2f(entity.getDrawImage().getStartWidth() /
                        entity.getDrawImage().getTextureStorage().getWidth(),
                entity.getDrawImage().getEndHeight() /
                        entity.getDrawImage().getTextureStorage().getHeight());
        glVertex2f(0, entity.getHeight());

        glDisable(GL_BLEND);
        glEnd();
        glLoadIdentity();

    }

    /**
     * Метод, возвращающий отношение параметра (ширины или высоты)
     * к ближайшей большей степени двойки. потому что иначе OPG
     * работает со степенями двойки в качестве ширины и высоты.
     * и тогда изображение будет выводится уменьшеным до
     * ближайшей меньшей степени двойки. Например, если высота 100,
     * то само изображение будет 64 пикселя, остальные 36 будет пустота
     *
     * @param value ширина или высота
     * @return отношение параметра к степени 2
     */
    private static float glFix(float value) {
        // TODO переделать потом на алгоритм со сдвигом старшего бита
        int i = 2;
        while (i < value) {
            i *= 2;
        }
        return value / i;
    }

    /**
     * Загрузка текструры
     *
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
