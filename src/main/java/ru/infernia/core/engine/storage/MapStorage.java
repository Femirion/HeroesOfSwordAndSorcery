package ru.infernia.core.engine.storage;

import ru.infernia.core.engine.loader.MapLoader;
import ru.infernia.entity.map.MapInfo;
import ru.infernia.entity.map.RegionInfo;

import java.util.Map;
import java.util.stream.Collectors;

public class MapStorage {
    private final MapLoader mapLoader;
    private MapInfo mapInfo;
    private Map<Integer, RegionInfo> regionInfo;

    public MapStorage(MapLoader mapLoader) {
        this.mapLoader = mapLoader;
        mapInfo = mapLoader.getMapInfo();
        regionInfo = mapLoader.getAllRegionsInfo(mapInfo.getRegions()).stream()
                .collect(Collectors.toMap(RegionInfo::getId, v -> v));
    }
}
