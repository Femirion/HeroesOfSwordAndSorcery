import engine.point.Point;
import engine.unils.VectorUntils;
import model.entities.GameEntity;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stub.GeneratorStub;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

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
            visibleObjects = GeneratorStub.getRandomVisibleObjects();
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
                        System.out.println("Кирпич " + entity.getId() + " " +
                                entity.getId() + " " + entity.getY());
                        // можем завершить поиск. тк. этот объект самый ближний,
                        // и перекрывает части других объектов
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
                if (entity.isInteractive()) {
                    // выделить нужно только первый объект, который попадает под мышь
                    // другие объекты тоже могут попасть в это же самое время под мышь (если объекты пересекаются)
                    // но так как объекты отсортированы по удаленности от игрока, то выбираем ближайший объект
                    // а остальные гасим
                    if (entity.contains(Mouse.getX(), Mouse.getY()) && !isFindContainsObject) {
                        // мышь попала в праямоугольник, заданный координатами,
                        // проверим, попали ли мы в саму фигуру
                        List<Point> pointList = entity.getDrawImage().getPoints();
                        // флаг, показывающий что прямая от указателя мыши до точки,
                        // пересекает каждое из ребер
                        boolean isNoCrossed = true;
                        for (int i = 0; i < pointList.size(); i++) {
                            if (i == pointList.size() - 1) {
                                // нужно взять последнюю и первую точку в качестве вершин
                                isNoCrossed = isNoCrossed && !VectorUntils.isCrossed(entity.getDrawImage().getInternalPoint().getX()  + entity.getWidth(),
                                        entity.getDrawImage().getInternalPoint().getY()  + entity.getHeight(),
                                        Mouse.getX(),
                                        Mouse.getY(),
                                        pointList.get(i).getX() + entity.getWidth(),
                                        pointList.get(i).getY() + entity.getHeight(),
                                        pointList.get(0).getX() + entity.getWidth(),
                                        pointList.get(0).getY() + entity.getHeight());

                            } else {
                                isNoCrossed = isNoCrossed && !VectorUntils.isCrossed(entity.getDrawImage().getInternalPoint().getX()  + entity.getWidth(),
                                        entity.getDrawImage().getInternalPoint().getY()  + entity.getHeight(),
                                        Mouse.getX(),
                                        Mouse.getY(),
                                        pointList.get(i).getX() + entity.getWidth(),
                                        pointList.get(i).getY() + entity.getHeight(),
                                        pointList.get(i + 1).getX() + entity.getWidth(),
                                        pointList.get(i + 1).getY() + entity.getHeight());
                            }
                        }
                        if (!isNoCrossed) {
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
        }

    }

}
