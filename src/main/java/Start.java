import engine.point.Point;
import engine.unils.VectorUntils;
import model.entities.GameEntity;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stub.GeneratorStub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import static engine.Engine.HEIGHT;
import static engine.Engine.beginSession;

/**
 * author Vostryakov Alexander
 */
public class Start {

    private static Logger logger = LoggerFactory.getLogger(Start.class);

    // отображаемые на экране объекты
    private List<GameEntity> visibleObjects;

    public Start() {
        try {
            beginSession();
            visibleObjects = GeneratorStub.getStableVisibleObjects();
            Collections.sort(visibleObjects);
            while (!Display.isCloseRequested()) {

                mouseListener();

                for (GameEntity entity : visibleObjects) {
                    entity.draw();
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


    /**
     * Обработчик событий мыши
     */
    public void mouseListener() {

        // список объектов отсортирован по удаленности от игрока
        // значит логичнее всего искать начиная с более ближних
        ListIterator<GameEntity> iterator = visibleObjects.listIterator(visibleObjects.size());

        // обрабатываем нажание на левую кнопку мыши
        if (Mouse.isButtonDown(0)) {
            while (iterator.hasPrevious()) {
                GameEntity entity = iterator.previous();
                // да, мы нашил его!
                int mouseX = Mouse.getX();
                int mouseY = Mouse.getY();
                if (entity.contains(mouseX, mouseY)) {
                    // нам интересны только интерактивные объекты
                    if (entity.isInteractive()) {
                        // мышь попала в праямоугольник, заданный координатами,
                        // проверим, попали ли мы в саму фигуру
                        if (!isCrossed(entity, mouseX, HEIGHT - mouseY)) {
                            System.out.println("Попали внутрь");
                            return;
                        }
                    } else {
                        return;
                    }
                }

            }

        } else {
            // обрабатываем то, что мышь наведена на один из игровых объектов
            // тут процедура чуть хитрее, чем раньше
            // дело в том, что имейдж выделенного изображения
            // заменяется на другой. таким образом, нам нужно не только поменять
            // имейдж выделенного объекта, но и вернуть назад все предыдущие имейджи
            // чтобы в один момент времени мог быть выделен только один имейдж.
            // поэтому isFindContainsObject - флаг, показывающий, что объект уже выделен
            // и остальные объекты нужно гасить.
            boolean isFindContainsObject = false;
            while (iterator.hasPrevious()) {
                GameEntity entity = iterator.previous();
                    // выделить нужно только первый объект, который попадает под мышь
                    // другие объекты тоже могут попасть в это же самое время под мышь (если объекты пересекаются)
                    // но так как объекты отсортированы по удаленности от игрока, то выбираем ближайший объект
                    // а остальные гасим
                    int mouseX = Mouse.getX();
                    int mouseY = Mouse.getY();
                    if (entity.contains(mouseX, mouseY) && !isFindContainsObject) {
                        // мышь попала в прямоугольник, заданный координатами,
                        // проверим, попали ли мы в саму фигуру
                        if (entity.isInteractive()) {
                            if (!isCrossed(entity, mouseX, HEIGHT - mouseY)) {
                                entity.setDrawImage(entity.getImg().getActiveImages().get("pointing"));
                                isFindContainsObject = true;
                            } else {
                                entity.setDrawImage(entity.getImg().getBaseImage());
                            }
                        } else {
                            // мы попали в объект. но он не интерактивный
                            isFindContainsObject = true;
                        }
                    } else {
                        entity.setDrawImage(entity.getImg().getBaseImage());
                    }
                }

        }

    }

    /**
     * Метод определяющий попадания мыши в игровой объект
     * @param entity игровой объект
     * @param x координата x мыши
     * @param y координата y мыши
     * @return true - если попали внутрь
     */
    private boolean isCrossed(GameEntity entity, int x, int y) {
        List<Point> pointList = entity.getDrawImage().getPoints();
        // флаг, показывающий что прямая от указателя мыши до точки,
        // пересекает какое-нить из ребер.
        // учтем, что если пересечений четное количество,
        // поэтому используем оператор ^
        boolean isCrossed = false;
        for (int i = 0; i < pointList.size(); i++) {
            // последняя и нулевая точка образуют последнее ребро
            // нужно взять последнюю и первую точку в качестве вершин
            if (i == pointList.size() - 1) {
                isCrossed = isCrossed ^ VectorUntils.isCrossed(
                        entity.getInteralPointX(),
                        entity.getInteralPointY(),
                        x,
                        y,
                        pointList.get(i).getX(entity),
                        pointList.get(i).getY(entity),
                        pointList.get(0).getX(entity),
                        pointList.get(0).getY(entity));

            } else {
                isCrossed = isCrossed ^ VectorUntils.isCrossed(
                        entity.getInteralPointX(),
                        entity.getInteralPointY(),
                        x,
                        y,
                        pointList.get(i).getX(entity),
                        pointList.get(i).getY(entity),
                        pointList.get(i + 1).getX(entity),
                        pointList.get(i + 1).getY(entity));
            }
        }
        return isCrossed;
    }

}
