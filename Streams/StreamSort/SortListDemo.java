package com.trinadh.StreamSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListDemo {
    public static void main(String args[]){

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(12);
        list.add(3);
        list.add(4);

        //traditional approach to sort the list in ascending and descending order
        Collections.sort(list);
        System.out.println(list);
        //output: [2, 3, 4, 12]

        System.out.println("list in reverse order in traditional order: ");
        Collections.reverse(list);
        System.out.println(list);
        //output: [12, 4, 3, 2]

        System.out.println("sorting list using stream lambda functions: ");
        list.stream().sorted().forEach(t->System.out.print(t + " "));
        //output: 2 3 4 12

        System.out.println("\nreverse order with stream function");
        list.stream().sorted(Collections.reverseOrder()).forEach(t->System.out.print(t + " "));
        //output: 12 4 3 2


    }
}
