package com.trinadh.ApiExample;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(123, "Trinadh", "SDE", 150000));
        list.add(new Employee(124,"Rakesh","CyberSecurity", 135000));
        list.add(new Employee(125, "mithil", "SWE Intern", 35000));
        list.add(new Employee(126, "kiran", "Senior Software Engineer", 200000));
        return list;
    }
}
