package com.maths.huim.dao;

import com.maths.huim.api.InputDao;
import com.maths.huim.models.ItemUnitProfitMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ItemUnitProfitMapDao implements InputDao {

    public ItemUnitProfitMap fetch(String scenario) {

        Map<Integer, Long> map = new HashMap<Integer, Long>();
        try {
            String filePath = "data/" + scenario + "/item_unit_profit.txt";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null){
                String[] params = line.split(":");
                int item = Integer.parseInt(params[0]);
                long unitProfit = Long.parseLong(params[1]);
                map.put(item, unitProfit);
                line = reader.readLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        return new ItemUnitProfitMap(map);
    }
}
