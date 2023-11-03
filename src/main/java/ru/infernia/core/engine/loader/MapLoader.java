package ru.infernia.core.engine.loader;

import ru.infernia.entity.map.MapInfo;
import ru.infernia.entity.map.RegionInfo;
import ru.infernia.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class MapLoader {
    public MapInfo getMapInfo() {
        return JsonUtil.loadMap();
    }

    public RegionInfo getRegionInfo(int id) {
        return JsonUtil.loadRegion(id);
    }

    public List<RegionInfo> getAllRegionsInfo(List<Integer> regionIds) {
        List<RegionInfo> result = new ArrayList<>();
        for (int id : regionIds) {
            RegionInfo rgi = JsonUtil.loadRegion(id);
            result.add(rgi);
        }
        return result;
    }
}
