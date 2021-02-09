package com.maths.huim.models;

import com.maths.huim.api.ItemParamMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemTwuMap implements ItemParamMap {

    private Map<Integer, Long> map;

    public ItemTwuMap(Map<Integer, Long> map) {
        this.map = map;
    }

    public Map<Integer, Long> getMap() {
        return map;
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

    public Long getTWU(Integer key) {
        return getParam(key);
    }

    public Long setTWU(Integer key, Long value) {
        return setParam(key, value);
    }

//    public ItemTwuMap getPairRemoved(Integer s) {
//
//        Map<Integer, Long> newMap = new LinkedHashMap<>();
//        for(Map.Entry<Integer, Long> pair : this.map.entrySet()) {
//            if(!pair.getKey().equals(s)) {
//                newMap.put(pair.getKey(), pair.getValue());
//            }
//        }
//        return new ItemTwuMap(newMap);
//    }

    public ItemTwuMap getPairRemoved(Integer s) {

        Map<Integer, Long> newMap = new LinkedHashMap<>();
        boolean found = false;
        for(Map.Entry<Integer, Long> pair : this.map.entrySet()) {
            if(found) {
                newMap.put(pair.getKey(), pair.getValue());
            }
            if(pair.getKey().equals(s)) {
                found = true;
            }
        }
        return new ItemTwuMap(newMap);
    }

    @Override
    public String toString() {
        return "ItemTwuMap{" +
                "map=" + map +
                '}';
    }
}
