package com.maths.huim;

import com.maths.huim.dao.ItemUnitProfitMapDao;
import com.maths.huim.dao.TransactionDao;
import com.maths.huim.impl.ItemTwuMapImpl;
import com.maths.huim.impl.ItemUtilityTableImpl;
import com.maths.huim.models.*;
import com.maths.huim.utils.AntRoutingGraphUtils;
import com.maths.huim.utils.ItemTwuMapUtils;
import com.maths.huim.utils.MAUTableUtils;

import java.io.*;
import java.util.*;

public class runMAU {

    public static MAUTableUtils mauTableUtils = new MAUTableUtils();

    public static void main( String [] args) {

        File file = new File("data");
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });

        for (int i = 0; i < directories.length; ++i) {
            System.out.println(i + 1 + ". " + directories[i]);
        }

        System.out.print("\nSelect the dataset : ");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        System.out.print("Enter the minUtil value : ");
        long minUtil = sc.nextLong();
        Constants.setMinUtil(minUtil);
        System.out.print("Enter the delta value : ");
        double delta = sc.nextDouble();
        Constants.setDelta(delta);
        System.out.print("Enter the ant count value : ");
        long antCount = sc.nextLong();
        Constants.setAntCount(antCount);
        System.out.println("minUtil = " + Constants.minUtil + " delta = " + Constants.delta);

        ItemUnitProfitMap itemUnitProfitMap = (new ItemUnitProfitMapDao()).fetch(directories[index-1]);
        System.out.println(itemUnitProfitMap);
        System.out.println("subha");
        Map<Integer, Double> tableMAU = mauTableUtils.calculateMAUTable(itemUnitProfitMap.getMap());        // Calculate MAU table
        System.out.println(tableMAU);

        Set<Integer> itemSet = new HashSet<Integer>();
        List<Transaction> transactions = (new TransactionDao()).fetch(directories[index - 1], itemSet);     // Fetching transactions

        long beforeUsedMem = Runtime.getRuntime().totalMemory()- Runtime.getRuntime().freeMemory();
        long beforeTime = System.currentTimeMillis();

        ItemTwuMapImpl itemTwuMapImpl = new ItemTwuMapImpl();   // Calculating item twu map
        ItemTwuMap itemTwuMap = itemTwuMapImpl.calculate(transactions, itemSet);
        itemTwuMapImpl = null;
        System.out.println("Sorting and pruning itemsets...\n");

        ItemTwuMapUtils itemTwuMapUtils = new ItemTwuMapUtils(itemTwuMap);
        itemTwuMapUtils.prune(transactions, itemTwuMap, itemSet);   //Pruning Itemset
        itemTwuMapUtils.sortDesc(itemTwuMap);   //Sorting Itemset
        System.out.println(itemTwuMap);
        itemSet = null;
        itemTwuMapUtils = null;

        System.out.println("Calculating Item Utility Mappings...\n");
        ItemUtilityTableImpl itemUtilityTableImpl = new ItemUtilityTableImpl();
        Map<List<Integer>, ItemUtilityTable> itemUtilityTableMap = itemUtilityTableImpl.init(transactions, itemTwuMap);     // Calculating Item Utility Mapping
        transactions = null;
        itemUtilityTableImpl = null;
        System.out.println("Creating ant routing graph...\n");

        AntRoutingGraphUtils antRoutingGraphUtils = new AntRoutingGraphUtils();
        AntRoutingGraph antRoutingGraph = antRoutingGraphUtils.bootstrapAntGraph(itemTwuMap);

        System.out.println("Mining HUIs...\n");
        Map<List<Integer>, ItemSetData> itemSetCountMap = new HashMap<List<Integer>, ItemSetData>();
        long keyCount = itemTwuMap.getMap().keySet().size();
        itemTwuMap = null;

        FileWriter fileWriter;
        BufferedWriter bufferedWriter;

        try {
            fileWriter = new FileWriter("stats/" + directories[index - 1] + ".csv");
            bufferedWriter = new BufferedWriter(fileWriter);
            System.out.println("Total node count : " + keyCount + "\n");
            bufferedWriter.write("iterations, items_explored, HUIs_mined, Time_elapsed\n");
            antRoutingGraphUtils.computeHAUIs(antRoutingGraph, bufferedWriter, itemUtilityTableMap, itemSetCountMap, tableMAU, beforeTime);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("HUIs mined... creating output\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try
        {
            fileWriter = new FileWriter("results_HAUI/" + directories[index - 1] + ".txt");
            bufferedWriter = new BufferedWriter(fileWriter);

            for(Map.Entry<List<Integer>, ItemSetData> itemData : itemSetCountMap.entrySet()) {
                bufferedWriter.write(itemData.getKey() + " -> " + itemData.getValue() + "\n");
            }
            bufferedWriter.close();
        }
        catch (IOException excpt)
        {
            excpt.printStackTrace();
        }
        System.out.println("Output generated... check output\n");

        long afterTime = System.currentTimeMillis();
        long runTime = afterTime - beforeTime;
        long afterUsedMem = Runtime.getRuntime().totalMemory()- Runtime.getRuntime().freeMemory();
        long actualMemUsed = afterUsedMem - beforeUsedMem;

        System.out.println("\nRuntime = " + runTime);
        System.out.println("\nMemory Used = " + actualMemUsed);

    }
}
