package com.maths.huim.impl;

import com.maths.huim.models.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ItemUtilityTableImpl {

    public Map< List<Integer>, ItemUtilityTable> init(List<Transaction> transactions, ItemTwuMap itemTwuMap) {

        List<Transaction> trns = transactions;
        Map<List<Integer>, ItemUtilityTable> itemUtilityTableMap = new LinkedHashMap<List<Integer>, ItemUtilityTable>();
        for(Map.Entry<Integer, Long> itemTwu: itemTwuMap.getMap().entrySet()) {
            Map<Integer, ItemTransactionUtility> itemTransactionUtilityMap = new HashMap<Integer, ItemTransactionUtility>();
            for(Transaction transaction : trns) {
                long totalUtil = transaction.getTotalUtil();
                if(transaction.getItemCountMap().containsKey(itemTwu.getKey())) {
                    long eu = transaction.getItemCountMap().get(itemTwu.getKey()) /* * itemUnitProfitMap.getMap().get(itemTwu.getKey())*/;
                    itemTransactionUtilityMap.put(transaction.getTid(),
                            new ItemTransactionUtility(transaction.getTid(), eu, totalUtil - eu));
                    transaction.setTotalUtil(totalUtil - eu);
                }
            }
            itemUtilityTableMap.put(Arrays.asList(itemTwu.getKey()), new ItemUtilityTable(Arrays.asList(itemTwu.getKey()), itemTransactionUtilityMap));
        }

        return itemUtilityTableMap;
    }

    public long sumItemUtility(ItemUtilityTable itemUtilityTable) {

        long sum = 0;
        for(Map.Entry<Integer, ItemTransactionUtility> pair : itemUtilityTable.getItemTransactionUtilities().entrySet()) {
            sum += pair.getValue().getItemUtility();
        }
        return sum;
    }

    public long sumResidualUtility(ItemUtilityTable itemUtilityTable) {

        long sum = 0;
        for(Map.Entry<Integer, ItemTransactionUtility> pair : itemUtilityTable.getItemTransactionUtilities().entrySet()) {
            sum += pair.getValue().getResidualUtility();
        }
        return sum;
    }

    public ItemUtilityTable computeClosure(ItemUtilityTable table1, ItemUtilityTable table2) { // ASSUMING THE SECOND TABLE IS A PRIMARY ONE

        List<Integer> unionItemSet = Stream.concat(table1.getItemSet().stream(), table2.getItemSet().stream()).collect(Collectors.toList());

        Map<Integer, ItemTransactionUtility> itemTransactionUtilityMap = new HashMap<Integer, ItemTransactionUtility>();
        for(Map.Entry<Integer, ItemTransactionUtility> map : table1.getItemTransactionUtilities().entrySet()) {
            if(table2.getItemTransactionUtilities().containsKey(map.getKey())) {
                long eu = map.getValue().getItemUtility() + table2.getItemTransactionUtilities().get(map.getKey()).getItemUtility();
                long ru = map.getValue().getResidualUtility() - table2.getItemTransactionUtilities().get(map.getKey()).getItemUtility();
                itemTransactionUtilityMap.put( map.getKey(), new ItemTransactionUtility(map.getKey(), eu, ru));
            }
        }
        return new ItemUtilityTable(unionItemSet, itemTransactionUtilityMap);
    }

    public Set<Integer> getTidSet(ItemUtilityTable itemUtilityTable) {

        return itemUtilityTable.getItemTransactionUtilities().keySet();
    }

    public boolean isClosureCheck(ItemUtilityTable itemUtilityTable1, ItemUtilityTable itemUtilityTable2) {

        Set<Integer> tidSet1 = getTidSet(itemUtilityTable1);
        Set<Integer> tidSet2 = getTidSet(itemUtilityTable2);
        if(tidSet2 == null) return false;
        if(tidSet1 == null) return true;
        return tidSet2.containsAll(tidSet1);
    }
}
