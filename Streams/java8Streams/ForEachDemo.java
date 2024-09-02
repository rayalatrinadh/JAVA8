package com.trinadh.java8Streams;

import java.util.ArrayList;
import java.util.List;

public class ForEachDemo {
    public static void main(String args[]){
        List<String> list = new ArrayList<>();
        list.add("trinadh");
        list.add("rayala");
        list.add("rakesh");
        list.add("datta");

        //System.out.println("list: " + list);
            //output: list: [trinadh, rayala, rakesh, datta]

//        for(String str : list){
//            System.out.println(str);
//        }

        //output: trinadh rayala rakesh datta

        //list.stream().forEach(Action);
        list.stream().forEach(t -> System.out.println(t));
          //output: trinadh rayala rakesh datta




    }
}
