package com.maths.huim.models;

public class ItemSetData {

    private long supportCount;
    private long occurance;
    private long utility;


    public ItemSetData(long supportCount, long utility, long occurance) {
        this.supportCount = supportCount;
        this.occurance = occurance;
        this.utility = utility;
    }

    public ItemSetData() {
        this.supportCount = 0;
        this.occurance = 0;
        this.utility = 0;
    }

    public long getSupportCount() {
        return supportCount;
    }

    public long getOccurance() {
        return occurance;
    }

    public long getUtility() {
        return utility;
    }

    public void setSupportCount(long supportCount) {
        this.supportCount = supportCount;
    }

    public void setOccurance(long occurance) {
        this.occurance = occurance;
    }

    public void setUtility(long utility) {
        this.utility = utility;
    }

    @Override
    public String toString() {
        return
                " Rule Stats : support = " + supportCount +
                ", occurance = " + occurance +
                ", utility = " + utility;
    }
}
