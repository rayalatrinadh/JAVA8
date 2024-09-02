package com.trinadh.java8Streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachDemo {
    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("trinadh");
        list.add("rayala");
        list.add("rakesh");
        list.add("datta");

        //System.out.println("list: " + list);
        //output: list: [trinadh, rayala, rakesh, datta]

        /*for(String str : list){
            System.out.println(str);
        }*/
        //output: trinadh rayala rakesh datta

        //list.stream().forEach(Action);
        list.stream().forEach(t -> System.out.println(t));
        //output: trinadh rayala rakesh datta

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Trinadh");
        map.put(2, "Bajji");
        map.put(3, "rakhi");

        //2 ways we can use forEach with maps
        map.forEach((key, value) -> System.out.println(key + ": " + value));
        //output: 1: Trinadh  2: Bajji  3: rakhi

        map.entrySet().stream().forEach((obj) -> System.out.println(obj));
        //output: 1=Trinadh 2=Bajji 3=rakhi

        System.out.println("---------> Filter (Conditional Check)");
        List<String> list2 = new ArrayList<>();
        list2.add("trinadh");
        list2.add("rakesh");
        list2.add("kiran");
        list2.add("mithil");
        list2.add("Chandu");
        list2.add("Lalith");
        list2.add("rakhi");
        list2.add("ram");

        System.out.println(" need to print names start with r in traditional approach");
        for (String str : list2) {
            if (str.startsWith("r")) {
                System.out.println(str);
            }
        }
        //output: rakesh rakhi ram

        //with filter and lambda expression by using streams
        System.out.println("with filter : ");
        list2.stream().filter(t -> t.startsWith("r")).forEach(t -> System.out.println(t));
        //output: rakesh rakhi ram

        System.out.println("map Fileter example :");

        Map<Integer, String> mapFilter = new HashMap<>();
        mapFilter.put(1, "trinadh");
        mapFilter.put(2, "rakhi");
        mapFilter.put(3, "Rayala");
        mapFilter.put(4, "Kiran");

        System.out.println("need to print the even map key values : ");

        mapFilter.entrySet().stream().filter(k -> k.getKey() % 2 == 0).forEach(obj -> System.out.println(obj));


    }
}
