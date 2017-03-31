package ru.infernia.core;

import org.apache.log4j.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

import static org.lwjgl.opengl.GL11.*;

/**
 * Главный класс приложения
 * <p>
 * author Vostryakov Alexander
 */
public class Engine {

    private static final Logger log = Logger.getLogger(Engine.class);
    private static final String RESOURCE_TYPE = "PNG";

    public static final String RESOURCES_PATH = "/src/main/resources/image/%s";
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    /**
     * Подготовка к рисованию
     */
    public static void beginSession() {
        try {
            log.info("Start");

            Display.setTitle("Heroes of Sword and Sorcery");
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create();

            glMatrixMode(GL_PROJECTION);
            glLoadIdentity();
            glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
            glMatrixMode(GL_MODELVIEW);
            glEnable(GL_TEXTURE_2D);

        } catch (LWJGLException ex) {
            log.error("Ошибка инициализации движка");
        }
    }


    /**
     * Загрузка текструры
     *
     * @param name имя файла в каталоге src/resource/image
     * @return загруженная текстура
     */
    public static Texture loadTexture(String name) {
        Texture texture = null;
        InputStream in = ResourceLoader.getResourceAsStream(String.format(RESOURCES_PATH, name));
        try {
            texture = TextureLoader.getTexture(RESOURCE_TYPE, in);
        } catch (IOException ex) {
            log.error("Ошибка при загрузке текстуры " + name);
        }
        return texture;
    }

}
