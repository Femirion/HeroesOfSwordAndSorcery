package new_engine.core;

import new_engine.entity.GameObject;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;

/**
 * author Vostryakov Alexander
 */
public class Engine {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    /**
     * Подготовка к рисованию
     */
    public static void beginSession() {
        try {
            Display.setTitle("Heroes of Sword and Sorcery");
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create();

            glMatrixMode(GL_PROJECTION);
            glLoadIdentity();
            glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
            glMatrixMode(GL_MODELVIEW);
            glEnable(GL_TEXTURE_2D);

        } catch (LWJGLException ex) {
            System.out.println("Ошибка инициализации движка");
        }

    }


    /**
     * Рисование игрового объекта
     *
     * @param entity игровой объект
     */
    public static void draw(GameObject entity) {
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        entity.getDrawImg().getTexture().bind();

        // ширина всей текстуры
        float allWidth = entity.getDrawImg().getTextureStorage().getWidth();
        // высота всей текстуры
        float allHeight = entity.getDrawImg().getTextureStorage().getHeight();
        // начальное положение части (ширина)
        float startWidth = entity.getDrawImg().getStartWidth();
        // конечное положение части (ширина)
        float endWidth = entity.getDrawImg().getEndWidth();
        // начальное положение части (высота)
        float startHeight = entity.getDrawImg().getStartHeight();
        // конечное положение части (высота)
        float endHeigth = entity.getDrawImg().getEndHeight();

        float width = endWidth - startWidth;
        float height = endHeigth - startHeight;

        // дело в том, что GL хорошо работает с текстурами,
        // размер которых кратен степени двойки, и неочень с остальными
        // в итоге он делает фигню.
        // чтобы пофиксить это, я вычисляю соотношение изображения к
        // ближайшей большей степени двоийки.
        // например, для 50px это будет 50/32
        float widthGLFix = glFix(allWidth);
        float heightGLFix = glFix(allHeight);

        glTranslatef(entity.getX(), entity.getY(), 0);
        glBegin(GL_QUADS);

        // Тут вообще магия OpenGL-я
        // Мы хотим вевести не всю текстуру, а только небольшую часть
        // поэтому startWidth/width * widthGLFix указывает
        // на позицию (в относительном измерении) на текстуре
        // с которой нужно выводить изображение
        // widthGLFix, как уже писал выше, фиксит баг степеней двойки

        glTexCoord2f(
                startWidth / allWidth * widthGLFix,
                startHeight / allHeight * heightGLFix);
        glVertex2f(0, 0);

        glTexCoord2f(
                endWidth / allWidth * widthGLFix,
                startHeight / allHeight * heightGLFix);
        glVertex2f(width, 0);

        glTexCoord2f(
                endWidth / allWidth * widthGLFix,
                endHeigth / allHeight * heightGLFix);
        glVertex2f(width, height);

        glTexCoord2f(
                startWidth / allWidth * widthGLFix,
                endHeigth / allHeight * heightGLFix);
        glVertex2f(0, height);

        glDisable(GL_BLEND);
        glEnd();
        glLoadIdentity();

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
            System.out.println("Ошибка при загрузке текстуры " + name);
        }
        return texture;
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

}
