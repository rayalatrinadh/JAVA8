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
        map.forEach((key,value)->System.out.println(key +": "+value));
          //output: 1: Trinadh  2: Bajji  3: rakhi

        map.entrySet().stream().forEach((obj)->System.out.println(obj));
          //output: 1=Trinadh 2=Bajji 3=rakhi



    }
}
