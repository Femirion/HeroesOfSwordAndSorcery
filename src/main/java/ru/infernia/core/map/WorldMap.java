package ru.infernia.core.map;

import ru.infernia.entity.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * WorldMap
 * <p>
 * Created by steam on 12.04.17.
 */
public class WorldMap {

    private List<GameObject> entities = new ArrayList<>();

    void saveToFile(String fileName) {
        // TODO stub
    }

    public List<GameObject> getEntities() {
        return entities;
    }

    public void setEntities(List<GameObject> entities) {
        this.entities = entities;
    }
}
