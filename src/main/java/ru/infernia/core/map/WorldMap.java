package ru.infernia.core.map;

import org.apache.log4j.Logger;
import ru.infernia.entity.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * WorldMap
 * <p>
 * Created by steam on 12.04.17.
 */
public class WorldMap {

    private static final Logger log = Logger.getLogger(WorldMap.class);

    private List<GameObject> entities = new ArrayList<>();

    void saveToFile(String fileName) {
        // TODO stub
        log.info(String.format("Save map to fils=%s", fileName));
    }

    public List<GameObject> getEntities() {
        return entities;
    }

    public void setEntities(List<GameObject> entities) {
        this.entities = entities;
    }
}
