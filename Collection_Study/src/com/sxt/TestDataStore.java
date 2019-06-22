package com.sxt;

import java.util.*;

/**
 * ORM思想
 * @author fly
 * @date 2019/6/21
 */
public class TestDataStore {
    public static void main(String[] args) {
        Map<String,Object> row1 = new HashMap<>();
        row1.put("id",1001);
        row1.put("姓名","fly");
        row1.put("性别","男");
        Map<String,Object> row2 = new HashMap<>();
        row2.put("id",1003);
        row2.put("姓名","uvevuwwuwuw");
        row2.put("性别","男");
        Map<String,Object> row3 = new HashMap<>();
        row3.put("id",1002);
        row3.put("姓名","Ana");
        row3.put("性别","女");

        List<Map<String,Object>> list = new ArrayList<>();
        list.add(row1);
        list.add(row2);
        list.add(row3);

        for (Map<String,Object> m:list){
            Set<Map.Entry<String,Object>> ms = m.entrySet();
            for (Map.Entry tmp:ms){
                System.out.print(tmp+"\t");
            }
            System.out.println();
        }
    }
}
