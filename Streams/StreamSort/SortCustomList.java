package com.trinadh.StreamSort;

import com.trinadh.ApiExample.Database;
import com.trinadh.ApiExample.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCustomList {
    public static void main(String args[]){
        List<Employee> employee = Database.getEmployees();
        System.out.println(employee);
        //output: [Employee{id=123, name='Trinadh', dept='SDE', salary=150000}, Employee{id=124, name='Rakesh', dept='CyberSecurity', salary=135000}, Employee{id=125, name='mithil', dept='SWE Intern', salary=35000}, Employee{id=126, name='kiran', dept='Senior Software Engineer', salary=200000}]

        //sort based on the salary in ascending order: traditional approach
        Collections.sort(employee,new MyComparator());
        System.out.println(employee);
        //[Employee{id=125, name='mithil', dept='SWE Intern', salary=35000}, Employee{id=124, name='Rakesh', dept='CyberSecurity', salary=135000}, Employee{id=123, name='Trinadh', dept='SDE', salary=150000}, Employee{id=126, name='kiran', dept='Senior Software Engineer', salary=200000}]
    }
}

class MyComparator implements  Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.getSalary()-o2.getSalary());
    }
}
