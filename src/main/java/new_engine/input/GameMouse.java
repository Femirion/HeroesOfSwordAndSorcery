package new_engine.input;

//import static engine.Engine.HEIGHT;

/**
 * Обработка событий мыши
 *
 * author Vostryakov Alexander
 */
public class GameMouse {

    /*public void mouseContainsListener(List<GameEntity> visibleObjects, GameEntity activeEntity) {
        // обрабатываем то, что мышь наведена на один из игровых объектов
        // тут процедура чуть хитрее, чем раньше
        // дело в том, что имейдж выделенного изображения
        // заменяется на другой. таким образом, нам нужно не только поменять
        // имейдж выделенного объекта, но и вернуть назад все предыдущие имейджи
        // чтобы в один момент времени мог быть выделен только один имейдж.
        // поэтому isFindContainsObject - флаг, показывающий, что объект уже выделен
        // и остальные объекты нужно гасить.
        ListIterator<GameEntity> iterator = visibleObjects.listIterator(visibleObjects.size());
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
                        entity.setDrawImage(entity.getGameImg().getActiveImages().get("pointing"));
                        isFindContainsObject = true;
                    } else {
                        entity.setDrawImage(entity.getGameImg().getBaseImage());
                    }
                } else {
                    // мы попали в объект. но он не интерактивный
                    isFindContainsObject = true;
                }
            } else {
                if (entity.equals(activeEntity)) {
                    entity.setDrawImage(entity.getGameImg().getActiveImages().get("pointing"));
                } else {
                    entity.setDrawImage(entity.getGameImg().getBaseImage());
                }
            }
        }
    }


    *//**
     * Обработчик событий мыши
     *//*
    public GameEntity mouseClickListener(List<GameEntity> visibleObjects, GameEntity activeEntity) {

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
                            return entity;
                        }
                    } else {
                        return null;
                    }
                }

            }
        }
        return activeEntity;
    }


    *//**
     * Метод определяющий попадания мыши в игровой объект
     * @param entity игровой объект
     * @param x координата x мыши
     * @param y координата y мыши
     * @return true - если попали внутрь
     *//*
    private boolean isCrossed(GameEntity entity, int x, int y) {
        List<Point> pointList = entity.getDrawImage().getImage().getPoints();
        // флаг, показывающий что прямая от указателя мыши до точки,
        // пересекает какое-нить из ребер.
        // учтем, что если пересечений четное количество,
        // поэтому используем оператор ^
        boolean isCrossed = false;
        for (int i = 0; i < pointList.size(); i++) {
            // последняя и нулевая точка образуют последнее ребро
            // нужно взять последнюю и первую точку в качестве вершин
            if (i == pointList.size() - 1) {
                isCrossed = isCrossed ^ StraightUtils.isCrossed(
                        entity.getInternalPointX(),
                        entity.getInternalPointY(),
                        x,
                        y,
                        pointList.get(i).getX(entity),
                        pointList.get(i).getY(entity),
                        pointList.get(0).getX(entity),
                        pointList.get(0).getY(entity));

            } else {
                isCrossed = isCrossed ^ StraightUtils.isCrossed(
                        entity.getInternalPointX(),
                        entity.getInternalPointY(),
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
*/
}
