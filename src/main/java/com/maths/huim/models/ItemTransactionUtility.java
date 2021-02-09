package com.maths.huim.models;

public class ItemTransactionUtility {

    private long itemUtility;
    private long residualUtility;

    public ItemTransactionUtility(int tid, long itemUtility, long residualUtility) {
        this.itemUtility = itemUtility;
        this.residualUtility = residualUtility;
    }

    public long getItemUtility() {
        return itemUtility;
    }

    public void setItemUtility(long itemUtility) {
        this.itemUtility = itemUtility;
    }

    public long getResidualUtility() {
        return residualUtility;
    }

    public void setResidualUtility(long residualUtility) {
        this.residualUtility = residualUtility;
    }

    @Override
    public String toString() {
        return "ItemTransactionUtility{" +
                ", itemUtility=" + itemUtility +
                ", residualUtility=" + residualUtility +
                '}';
    }
}
