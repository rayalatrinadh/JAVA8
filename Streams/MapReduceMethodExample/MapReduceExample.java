package com.trinadh.MapReduceMethodExample;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class MapReduceExample {
    public static void main(String args[]) {
        List<Integer> numbers = Arrays.asList(12, 13, 7, 8, 1, 2, 3, 4, 5, 6, 1);

        System.out.println("traditional approach to calculate sum");
        int sum = 0;
        for (int num : numbers)
            sum += num;

        System.out.println(sum);
        //62

        System.out.println("using java 8 stream : ");
        int reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduceSum); //62

        System.out.println("reduce sum with method reference: ");
        Optional<Integer> reduceSumwithMethodReference = numbers.stream().reduce(Integer::sum);
        System.out.println(reduceSumwithMethodReference.get()); //62

        System.out.println("multiplication result with map reduce function: " );
        Integer multiplicationResumt = numbers.stream().reduce(1,(a,b) -> a*b);
        System.out.println(multiplicationResumt);//6289920

        System.out.println("max Value with map reduce function : " );
        Integer maxValue = numbers.stream().reduce(0,(a,b) -> a > b ? a : b);
        System.out.println(maxValue); //13

        System.out.println("max value with map reduce method reference : ");
        Integer mapReduceMethodReference = numbers.stream().reduce(Integer::max).get();
        System.out.println(mapReduceMethodReference); //13

        System.out.println("===========Example 2: with String=======================");

        List<String> words = Arrays.asList("coreJava","node.js","spring","hibernate","microservices","AWS");

        String longestString = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
        System.out.println(longestString);  //microservices



    }
}
