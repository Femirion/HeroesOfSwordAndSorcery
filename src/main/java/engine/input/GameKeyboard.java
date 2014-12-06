package engine.input;

import model.entities.GameEntity;
import org.lwjgl.input.Keyboard;

/**
 * Обработка событий клавиатуры
 *
 * author Vostryakov Alexander
 */
public class GameKeyboard {

    /**
     * обработчик событий клавиатуры
     */
    public void keyListener(GameEntity activeEntity) {
        if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
            if (activeEntity != null) {
                activeEntity.setX(activeEntity.getX() - 1);
            }
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
            if (activeEntity != null) {
                activeEntity.setY(activeEntity.getY() - 1);
            }
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
            if (activeEntity != null) {
                activeEntity.setY(activeEntity.getY() + 1);
            }
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
            if (activeEntity != null) {
                activeEntity.setX(activeEntity.getX() + 1);
            }
        }

    }
}
