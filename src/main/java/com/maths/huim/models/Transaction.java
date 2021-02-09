package com.maths.huim.models;


import java.util.HashMap;
import java.util.Map;

public class Transaction {

    private int tid;
    private Map<Integer, Long> itemCountMap;
    private long totalUtil;

    public Transaction(int tid, Map<Integer, Long> itemCountMap, long totalUtil) {
        this.tid = tid;
        this.itemCountMap = itemCountMap;
        this.totalUtil = totalUtil;
    }

    public Transaction(int tid) {
        this.tid = tid;
        this.itemCountMap = new HashMap<Integer, Long>();
        totalUtil = 0;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Map<Integer, Long> getItemCountMap() {
        return itemCountMap;
    }

    public void setItemCountMap(Map<Integer, Long> itemCountMap) {
        this.itemCountMap = itemCountMap;
    }

    public long getTotalUtil() {
        return totalUtil;
    }

    public void setTotalUtil(long totalUtil) {
        this.totalUtil = totalUtil;
    }

  /*  public Long getItemCountMap(Integer key) {
        return itemCountMap.get(key);
    }

    public Long setItemCountMap(Integer key, Long value) {
        return itemCountMap.put(key, value);
    }

    public Long getCount(Integer key) {
        return getItemCountMap(key);
    }

    public Long setCount(Integer key, Long value) {
        return setItemCountMap(key, value);
    }*/

    @Override
    public String toString() {
        return "Transaction{" +
                "tid=" + tid +
                ", itemCountMap=" + itemCountMap +
                ", totalUtil=" + totalUtil +
                '}';
    }
}
