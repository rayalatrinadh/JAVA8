package com.trinadh.MapFlatMapExample;

import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    public static void main(String args[]){
        System.out.println("Map Vs FlatMap with Realtime Example: " );

        List<Customer> customersList = ECartDB.getAll();

        System.out.println(customersList);
        //[Customer{id=10, name='trinadh', email='3nadhmail@gmail.com', phoneNumbers=[1234, 5678]}, Customer{id=11, name='rayala', email='rayala@gmail.com', phoneNumbers=[2332, 2111]}, Customer{id=12, name='Rakesh', email='rakhi@gmail.com', phoneNumbers=[1111, 1222]}]

        //---> need to get the emails as List<String> from List<Stream>
        //List<Customer> convert to List<String> ------>> Data Transformation
        //mapping: customer -> customer.getEmail()   ONE TO ONE MAPPING


        System.out.println("mapping: customer -> customer.getEmail()   ONE TO ONE MAPPING ");
        List<String> emails = customersList.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());
        System.out.println(emails);
        //[3nadhmail@gmail.com, rayala@gmail.com, rakhi@gmail.com]

        //customer -> customer.getPhoneNumbers() --->> ONE TO MANY MAPPING
        //customer -> customer.getPhoneNumbers() -----> ONE TO MANY MAPPING
        System.out.println("customer -> customer.getPhoneNumbers() -----> ONE TO MANY MAPPING : ");
        List<List<String>> phoneNumbers = customersList.stream()
                .map(customerr -> customerr.getPhoneNumbers())
                .collect(Collectors.toList());
        System.out.println(phoneNumbers);
        //[[1234, 5678], [2332, 2111], [1111, 1222]]

        //List<Customer> convert to List<String> -> Data Transformation
        //mapping : customer -> phone Numbers
        //customer -> customer.getPhoneNumbers() ----> ONE TO MANY mapping

        List<String> phones = customersList.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println("Flat Map: " );
        System.out.println(phones);
        //[1234, 5678, 2332, 2111, 1111, 1222]

    }
}
