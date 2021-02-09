package com.maths.huim.models;

import java.util.ArrayList;
import java.util.List;

public class PathUtil {

    private List<Integer> path;
    private long util;

    public PathUtil(List<Integer> path, long util) {
        this.path = path;
        this.util = util;
    }

    public PathUtil() {
        this.path = new ArrayList<Integer>();
        this.util = 0;
    }

    public List<Integer> getPath() {
        return path;
    }

    public void setPath(List<Integer> path) {
        this.path = path;
    }

    public long getUtil() {
        return util;
    }

    public void setUtil(long util) {
        this.util = util;
    }

    @Override
    public String toString() {
        return "PathUtil{" +
                "path=" + path +
                ", util=" + util +
                '}';
    }
}
