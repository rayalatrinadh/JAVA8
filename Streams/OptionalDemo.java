package com.trinadh;

import com.trinadh.MapFlatMapExample.Customer;

import java.util.Arrays;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {

        Customer customer = new Customer(123,"trinadh", null , Arrays.asList("1233","111"));

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);


        Optional<String> emailOptionalCheck = Optional.of(customer.getEmail());
        System.out.println(emailOptionalCheck);
    }
}
