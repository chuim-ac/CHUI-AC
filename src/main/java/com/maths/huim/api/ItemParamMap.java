package com.maths.huim.api;

import java.util.HashMap;
import java.util.Map;

public interface ItemParamMap {

    public Map<Integer, Object> map = new HashMap<Integer, Object>();

    public Map<Integer, Long> getMap();

    public void setMap(Map<Integer, Long> map);

    public Long getParam(Integer key);

    public Long setParam(Integer key, Long value);




}
