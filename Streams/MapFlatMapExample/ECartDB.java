package com.trinadh.MapFlatMapExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ECartDB {

    public static List<Customer> getAll(){
        return Stream.of(
                new Customer(10, "trinadh", "3nadhmail@gmail.com", Arrays.asList("1234","5678")),
                new Customer(11,"rayala","rayala@gmail.com",Arrays.asList("2332","2111")),
                new Customer(12,"Rakesh","rakhi@gmail.com",Arrays.asList("1111","1222"))
        ).collect(Collectors.toList());
    }
}
