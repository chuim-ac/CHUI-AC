package com.maths.huim;

import com.maths.huim.dao.TransactionDao;
import com.maths.huim.models.Transaction;
import com.maths.huim.utils.MAUTableUtils;

import java.io.*;
import java.util.*;

public class MAUTableCalculator {

    public static void main(String [] args) {

        MAUTableUtils mauTableUtils = new MAUTableUtils();

        File file = new File("data");
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });

        FileWriter fileWriter;
        BufferedWriter bufferedWriter;

        for (int i = 0; i < directories.length; ++i) {
            Set<Integer> itemSet = new HashSet<Integer>();
            List<Transaction> transactions = (new TransactionDao()).fetch(directories[i], itemSet);
            Map<Integer, Long> itemUnitProfitMap = mauTableUtils.fetchUnitProfits(transactions);
            System.out.println(directories[i]);
            System.out.println(itemUnitProfitMap);
            try {
                fileWriter = new FileWriter("data/" + directories[i] + "/item_unit_profit.txt");
                bufferedWriter = new BufferedWriter(fileWriter);
                for(Map.Entry<Integer, Long> pair : itemUnitProfitMap.entrySet()) {
                    bufferedWriter.write(pair.getKey() + ":" + pair.getValue() + "\n");
                }
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
