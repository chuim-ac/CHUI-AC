package com.maths.huim.models;

import java.util.List;
import java.util.Map;

public class ItemUtilityTable {

    private List<Integer> itemSet;
    private Map<Integer, ItemTransactionUtility> itemTransactionUtilities;

    public ItemUtilityTable(List<Integer> itemSet, Map<Integer, ItemTransactionUtility> itemTransactionUtilities) {
        this.itemSet = itemSet;
        this.itemTransactionUtilities = itemTransactionUtilities;
    }

    public ItemUtilityTable() { }


    public List<Integer> getItemSet() {
        return itemSet;
    }

    public void setItemSet(List<Integer> itemSet) {
        this.itemSet = itemSet;
    }

    public Map<Integer, ItemTransactionUtility> getItemTransactionUtilities() {
        return itemTransactionUtilities;
    }

    public void setItemTransactionUtilities(Map<Integer, ItemTransactionUtility> itemTransactionUtilities) {
        this.itemTransactionUtilities = itemTransactionUtilities;
    }

    @Override
    public String toString() {
        return "ItemUtilityTable{" +
                "itemSet='" + itemSet + '\'' +
                ", itemTransactionUtilities=" + itemTransactionUtilities +
                '}';
    }

}
