package com.maths.huim.utils;

import com.maths.huim.models.Transaction;

import java.util.List;
import java.util.Map;

public class TransactionUtil {

    public void updateItemCountMap(Transaction transaction, Integer item, Long count) {

        Map<Integer, Long> map = transaction.getItemCountMap();
        map.put(item, count);
        transaction.setItemCountMap(map);
    }

    public double getAverageUtilityItem(Transaction transaction, int item) {

        Map<Integer, Long> itemCountMap = transaction.getItemCountMap();
        if(itemCountMap.containsKey(item)) {
            return transaction.getTotalUtil() / 1.0;
        }
        else {
            return 0;
        }
    }

    public double getAverageUtilityItemset(Transaction transaction, List<Integer> itemset) {
        double utility = 0.0;
        Map<Integer, Long> itemCountMap = transaction.getItemCountMap();
        for(Map.Entry<Integer, Long> pair : itemCountMap.entrySet()) {
            if(itemCountMap.containsKey(pair.getKey())) {
                utility += pair.getValue();
            }
        }
        return utility / itemset.size();
    }


}
