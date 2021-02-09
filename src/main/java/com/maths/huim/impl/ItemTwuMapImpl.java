package com.maths.huim.impl;

import com.maths.huim.models.ItemTwuMap;
import com.maths.huim.models.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ItemTwuMapImpl {

    public ItemTwuMap calculate(List<Transaction> transactions, Set<Integer> itemSet) {

        Map<Integer, Long> twuMap = new HashMap<Integer, Long>();

        for(Transaction transaction : transactions) {
            for(Integer pair : itemSet) {
                if(transaction.getItemCountMap().containsKey(pair)) {
                    if(twuMap.containsKey(pair)) {
                        twuMap.put(pair, transaction.getTotalUtil() + twuMap.get(pair));

                    }
                    else {
                        twuMap.put(pair, transaction.getTotalUtil());
                    }
                }
            }
        }

        return new ItemTwuMap(twuMap);
    }
}
