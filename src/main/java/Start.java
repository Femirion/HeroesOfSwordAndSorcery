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
        ListIterator<GameEntity> iterator = visibleObjects.listIterator(visibleObjects.size() - 1);

        // обрабатываем нажание на левую кнопку мыши
        if (Mouse.isButtonDown(0)) {
            while (iterator.hasPrevious()) {
                GameEntity entity = iterator.previous();
                // нам интересны только интерактивные объекты
                if (entity.isInteractive()) {
                    // да, мы нашил его!
                    if (entity.contains(Mouse.getX(), Mouse.getY())) {
                        // мышь попала в праямоугольник, заданный координатами,
                        // проверим, попали ли мы в саму фигуру
/*                        if (!isCrossed(entity)) {
                            System.out.println("Попали внутрь");
                            return;
                        } else {
                            System.out.println("Не попали внутрь");
                        }*/
                        System.out.println("Mouse: " + Mouse.getX() + "   " +  (HEIGHT - Mouse.getY()));
                        System.out.println("Point: " + entity.getInteralPointX() + "   " +  entity.getInteralPointY());
                        for (Point point : entity.getDrawImage().getPoints()) {
                            System.out.println(">> " + point.getX(entity) + "   " + point.getY(entity));
                        }
                        System.out.println(isCrossed(entity));

                    } else {
                        entity.setDrawImage(entity.getImg().getBaseImage());
                    }
                    return;
                }

            }

        } /**else {
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
                if (entity.isInteractive()) {
                    // выделить нужно только первый объект, который попадает под мышь
                    // другие объекты тоже могут попасть в это же самое время под мышь (если объекты пересекаются)
                    // но так как объекты отсортированы по удаленности от игрока, то выбираем ближайший объект
                    // а остальные гасим
                    if (entity.contains(Mouse.getX(), Mouse.getY()) && !isFindContainsObject) {
                        // мышь попала в праямоугольник, заданный координатами,
                        // проверим, попали ли мы в саму фигуру
                        if (!isCrossed(entity)) {
                            entity.setDrawImage(entity.getImg().getActiveImages().get("pointing"));
                            isFindContainsObject = true;
                        } else {
                            entity.setDrawImage(entity.getImg().getBaseImage());
                        }

                    } else {
                        entity.setDrawImage(entity.getImg().getBaseImage());
                    }
                }
            }
        }**/

    }

    /**
     * Метод определяющий попадания мыши в игровой объект
     * @param entity игровой объект
     * @return true - если попали внутрь
     */
    private boolean isCrossed(GameEntity entity) {
        List<Point> pointList = entity.getDrawImage().getPoints();
        // флаг, показывающий что прямая от указателя мыши до точки,
        // пересекает какое-нить из ребер.
        // учтем, что если пересечений четное количество,
        // поэтому используем оператор ^
        boolean isCrossed = false;
        int x = Mouse.getX();
        int y = HEIGHT - Mouse.getY();
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
                //System.out.println(isCrossed);

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
                //System.out.println(isCrossed);
            }
        }
        return isCrossed;
    }

}
