package com.maths.huim.models;

import java.util.ArrayList;
import java.util.List;

public class GenChui {

    private List<String> itemSet;
    private List<String> prevSet;
    private List<String> postSet;
    private double minUtil;


    public GenChui(List<String> itemSet, double minUtil) {
        this.itemSet = itemSet;
        this.minUtil = minUtil;
    }

    public GenChui(List<String> itemSet, List<String> prevSet, List<String> postSet, double minUtil) {
        this.itemSet = itemSet;
        this.prevSet = prevSet;
        this.postSet = postSet;
        this.minUtil = minUtil;
    }

    public GenChui() {
        this.itemSet = new ArrayList<String>();
        this.prevSet = new ArrayList<String>();
        this.postSet = new ArrayList<String>();
        this.minUtil = Constants.minUtil;
    }

    public List<String> getItemSet() {
        return itemSet;
    }

    public void setItemSet(List<String> itemSet) {
        this.itemSet = itemSet;
    }

    public List<String> getPrevSet() {
        return prevSet;
    }

    public void setPrevSet(List<String> prevSet) {
        this.prevSet = prevSet;
    }

    public List<String> getPostSet() {
        return postSet;
    }

    public void setPostSet(List<String> postSet) {
        this.postSet = postSet;
    }

    public double getMinUtil() {
        return minUtil;
    }

    public void setMinUtil(double minUtil) {
        this.minUtil = minUtil;
    }

    @Override
    public String toString() {
        return "GenChui{" +
                "itemSet=" + itemSet +
                ", prevSet=" + prevSet +
                ", postSet=" + postSet +
                ", minUtil=" + minUtil +
                '}';
    }
}
