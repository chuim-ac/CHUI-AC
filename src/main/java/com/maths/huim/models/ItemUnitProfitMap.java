package com.maths.huim.models;

import com.maths.huim.api.ItemParamMap;

import java.util.Map;

public class ItemUnitProfitMap implements ItemParamMap {

    private Map<Integer, Long> map;

    public ItemUnitProfitMap(Map<Integer, Long> map) {
        this.map = map;
    }

    public Map<Integer, Long> getMap() {
        return this.map;
    }

    public void setMap(Map<Integer, Long> map) {
        this.map = map;
    }

    public Long getParam(Integer key) {
        return map.get(key);
    }

    public Long setParam(Integer key, Long value) {
        return map.put(key, value);
    }

    public Long getUnitProfit(Integer key) {
        return getParam(key);
    }

    public Long setUnitProfit(Integer key, Long value) {
        return setParam(key, value);
    }


    @Override
    public String toString() {
        return "ItemUnitProfitMap{" +
                "map=" + map +
                '}';
    }
}
