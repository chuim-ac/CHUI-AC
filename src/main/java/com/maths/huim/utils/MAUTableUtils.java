package com.maths.huim.utils;

import com.maths.huim.models.Constants;
import com.maths.huim.models.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MAUTableUtils {

    public long gcd(long a, long b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public Map<Integer, Long> fetchUnitProfits(List<Transaction> transactions) {

        Map<Integer, Long> itemUnitProfitMap = new HashMap<Integer, Long>();
        for(Transaction transaction : transactions) {
            Map<Integer, Long> itemCountMap = transaction.getItemCountMap();
            for(Map.Entry<Integer, Long> pair : itemCountMap.entrySet()) {
                if(itemUnitProfitMap.containsKey(pair.getKey())) {
                    long prev = itemUnitProfitMap.get(pair.getKey());
                    long curr = pair.getValue();
                    itemUnitProfitMap.put(pair.getKey(), gcd(prev, curr));
                }
                else {
                    itemUnitProfitMap.put(pair.getKey(), pair.getValue());
                }
            }
        }
        return itemUnitProfitMap;
    }

    public Map<Integer, Double> calculateMAUTable(Map<Integer, Long> itemUnitProfitMap) {

        Map<Integer, Double> tableMAU = new HashMap<Integer, Double>();
        for(Map.Entry<Integer, Long> pair : itemUnitProfitMap.entrySet()) {
            tableMAU.put(pair.getKey(), Math.max(Constants.glmau, Constants.beta2 * pair.getValue()));
        }
        return tableMAU;
    }

    public double getMinimumAverageUtilityItemset(Map<Integer, Double> tableMAU, List<Integer> itemset) {

        double utility = 0.0;
        for(int item : itemset) {
            utility += tableMAU.get(item);
        }
        return utility / itemset.size();
    }


}
