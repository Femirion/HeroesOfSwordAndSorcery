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

        // ширина всей текстуры
        float width = entity.getDrawImage().getTextureStorage().getWidth();
        // высота всей текстуры
        float height = entity.getDrawImage().getTextureStorage().getHeight();
        // начальное положение части (ширина)
        float startWidth = entity.getDrawImage().getStartWidth();
        // конечное положение части (ширина)
        float endWidth = entity.getDrawImage().getEndWidth();
        // начальное положение части (высота)
        float startHeight = entity.getDrawImage().getStartHeight();
        // конечное положение части (высота)
        float endHeigth = entity.getDrawImage().getEndHeight();

        // дело в том, что GL хорошо работает с текстурами,
        // размер которых кратен степени двойки, и неочень с остальными
        // в итоге он делает фигню.
        // чтобы пофиксить это, я вычисляю соотношение изображения к
        // ближайшей большей степени двоийки.
        // например, для 50px это будет 50/32
        float widthGLFix = glFix(width);
        float heightGLFix = glFix(height);

        glTranslatef(entity.getX(), entity.getY(), 0);
        glBegin(GL_QUADS);

        // Тут вообще магия OpenGL-я
        // Мы хотим вевести не всю текстуру, а только небольшую часть
        // поэтому startWidth/width * widthGLFix указывает
        // на позицию (в относительном измерении) на текстуре
        // с которой нужно выводить изображение
        // widthGLFix, как уже писал выше, фиксит баг степеней двойки

        glTexCoord2f(
                startWidth/width * widthGLFix,
                startHeight/height * heightGLFix);
        glVertex2f(0, 0);

        glTexCoord2f(
                endWidth/width * widthGLFix ,
                startHeight/height * heightGLFix);
        glVertex2f(entity.getWidth(), 0);

        glTexCoord2f(
                endWidth/width * widthGLFix,
                endHeigth/height * heightGLFix);
        glVertex2f(entity.getWidth(), entity.getHeight());

        glTexCoord2f(
                startWidth/width * widthGLFix,
                endHeigth/height * heightGLFix );
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
        int x = (int) value;
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        return value / x;
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
