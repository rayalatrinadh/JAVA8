package com.trinadh;

import com.trinadh.MapFlatMapExample.Customer;

import java.util.Arrays;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {

        Customer customer = new Customer(123, "trinadh", null, Arrays.asList("1233", "111"));

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);


//        Optional<String> emailOptionalCheck = Optional.of(customer.getEmail());
//        System.out.println(emailOptionalCheck);

        System.out.println("----------------");
        Optional<String> emailOption2 = Optional.ofNullable(customer.getEmail());
        System.out.println(emailOption2);




        System.out.println(emailOption2.orElse("default@gmail.com"));

        System.out.println(emailOption2.orElseGet(()->"default@gmail.com"));

        System.out.println(emailOption2.map(String::toUpperCase).orElseGet(()->"default@gmail.com"));
        System.out.println(emailOption2.orElseThrow(() -> new IllegalArgumentException("email not present")));




    }
}
