package com.maths.huim.models;

public class ItemPropensity {

    int index;
    double propensity;

    public ItemPropensity(int index, double propensity) {
        this.index = index;
        this.propensity = propensity;
    }

    public ItemPropensity() {
    }

    public int getIndex() {
        return index;
    }

    public double getPropensity() {
        return propensity;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setPropensity(double propensity) {
        this.propensity = propensity;
    }
}
