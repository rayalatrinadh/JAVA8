package com.trinadh.StreamSort.MapSort;

import java.util.*;

public class SortMapDemoTraditional {
    public static void main(String args[]){
        Map<String, Integer> map = new HashMap<>();
        map.put("trinadh",7);
        map.put("rayala",5);
        map.put("rakesh",6);
        map.put("kiran",7);

        System.out.println("***************************Traditional Approach*****************************");
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for(Map.Entry<String,Integer> entry: entries){
            System.out.println(entry.getKey() +  " "+ entry.getValue());
        }

        System.out.println("***************************Java 8 Lambda Function Approach*****************************");
        Collections.sort(entries, (o1,o2) -> o1.getKey().compareTo(o2.getKey()));
        for(Map.Entry<String,Integer> entry: entries){
            System.out.println(entry.getKey() +  " "+ entry.getValue());
        }


    }
}
