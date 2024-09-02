package com.trinadh.ApiExample;

import java.util.List;
import java.util.stream.Collectors;

public class TaxService {

    public static List<Employee> evaluateTaxUsers(String input){

        return(input.equalsIgnoreCase("tax")) ?
                Database.getEmployees().stream().filter(emp->emp.getSalary()>100000).collect(Collectors.toList())
                :
                Database.getEmployees().stream().filter(emp->emp.getSalary()<=100000).collect(Collectors.toList());
    }

    public static void main(String args[]){
        System.out.println("Tax : " + evaluateTaxUsers("tax"));
        //output: Tax : [Employee{id=123, name='Trinadh', dept='SDE', salary=150000}, Employee{id=124, name='Rakesh', dept='CyberSecurity', salary=135000}, Employee{id=126, name='kiran', dept='Senior Software Engineer', salary=200000}]

        System.out.println("not Tax: " + evaluateTaxUsers("no tax"));
        //output: not Tax: [Employee{id=125, name='mithil', dept='SWE Intern', salary=35000}]
    }
}
