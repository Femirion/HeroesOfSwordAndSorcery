import ru.infernia.core.engine.Engine;
import ru.infernia.core.input.GameKeyboard;
import ru.infernia.core.input.GameMouse;

/**
 * author Vostryakov Alexander
 */
public class Game {

    public static void main(String[] args) {
        // todo try to fix it
        System.setProperty("org.lwjgl.librarypath", "/home/aleksandr/project/HeroesOfSwordAndSorcery/lib/natives");
        GameKeyboard keyboard = new GameKeyboard();
        GameMouse mouse = new GameMouse();

        Engine engine = new Engine(keyboard, mouse);
        engine.start(1600, 900);
    }
}
