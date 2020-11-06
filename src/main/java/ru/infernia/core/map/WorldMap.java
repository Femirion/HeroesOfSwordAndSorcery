package ru.infernia.core.map;

import lombok.extern.log4j.Log4j;
import ru.infernia.entity.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * WorldMap
 */
@Log4j
public class WorldMap {
    private List<GameObject> entities = new ArrayList<>();

    void saveToFile(String fileName) {
        // TODO stub
        log.info(String.format("Save map to file=%s", fileName));
    }

    public List<GameObject> getEntities() {
        return entities;
    }

    public void setEntities(List<GameObject> entities) {
        this.entities = entities;
    }
}
