package com.belsoft.project_v2;

import java.util.Map;

public class MapInfo {
    private final Map<String, ?> map;
    private final boolean reverseSorting;

    public MapInfo(Map<String, ?> map, boolean reverseSorting) {
        this.map = map;
        this.reverseSorting = reverseSorting;
    }


    public Map<String, ?> getMap() {
        return map;
    }

    public boolean isReverseSorting() {
        return reverseSorting;
    }
}
