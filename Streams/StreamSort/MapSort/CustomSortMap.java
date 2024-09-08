package com.trinadh.StreamSort.MapSort;

import com.trinadh.ApiExample.Employee;

import java.util.*;

public class CustomSortMap {
    public static void main(String args[]){
        Map<Employee, Integer> employeeMap = new TreeMap<>(new Comparator<Employee>(){

            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o2.getSalary()-o1.getSalary());
            }
        });

        employeeMap.put(new Employee(123,"Trinadh","Swe",80000), 80);
        employeeMap.put(new Employee(124,"Rayala","Swe",90000), 90);
        employeeMap.put(new Employee(125,"Rakesh","cybersecurity",100000), 100);
        employeeMap.put(new Employee(126,"Kiran","Swe",110000), 110);

         System.out.println(employeeMap);
         //{Employee{id=126, name='Kiran', dept='Swe', salary=110000}=110, Employee{id=125, name='Rakesh', dept='cybersecurity', salary=100000}=100, Employee{id=124, name='Rayala', dept='Swe', salary=90000}=90, Employee{id=123, name='Trinadh', dept='Swe', salary=80000}=80}



    }
}
