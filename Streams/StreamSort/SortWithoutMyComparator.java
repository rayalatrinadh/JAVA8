package com.trinadh.StreamSort;

import com.trinadh.ApiExample.Database;
import com.trinadh.ApiExample.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortWithoutMyComparator {
    public static void main(String args[]){
        List<Employee> employees = Database.getEmployees();
        System.out.println(employees);
        //output: [Employee{id=123, name='Trinadh', dept='SDE', salary=150000}, Employee{id=124, name='Rakesh', dept='CyberSecurity', salary=135000}, Employee{id=125, name='mithil', dept='SWE Intern', salary=35000}, Employee{id=126, name='kiran', dept='Senior Software Engineer', salary=200000}]

        //sort based on the salary in ascending order: traditional approach
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary()-o2.getSalary());
            }
        });
        System.out.println(employees); //Ascending order
        //output: [Employee{id=125, name='mithil', dept='SWE Intern', salary=35000}, Employee{id=124, name='Rakesh', dept='CyberSecurity', salary=135000}, Employee{id=123, name='Trinadh', dept='SDE', salary=150000}, Employee{id=126, name='kiran', dept='Senior Software Engineer', salary=200000}]

        System.out.println("using lambda function: ");
        Collections.sort(employees, (o1,o2) -> (int) (o2.getSalary()-o1.getSalary()));
        System.out.println(employees); //Descending Order;
        //output: [Employee{id=126, name='kiran', dept='Senior Software Engineer', salary=200000}, Employee{id=123, name='Trinadh', dept='SDE', salary=150000}, Employee{id=124, name='Rakesh', dept='CyberSecurity', salary=135000}, Employee{id=125, name='mithil', dept='SWE Intern', salary=35000}]

        //Using Streams
        System.out.println("print list using Streams.. ");
        employees.stream().sorted((o1,o2)-> (int) (o2.getSalary()-o1.getSalary())).forEach(System.out::print);
        //output: Employee{id=126, name='kiran', dept='Senior Software Engineer', salary=200000}Employee{id=123, name='Trinadh', dept='SDE', salary=150000}Employee{id=124, name='Rakesh', dept='CyberSecurity', salary=135000}Employee{id=125, name='mithil', dept='SWE Intern', salary=35000}

        //Approach 4:
        System.out.println("\n---> Stream using Comparator : ");
        employees.stream().sorted(Comparator.comparing(emp -> emp.getSalary())).forEach(System.out::print);
        //output: Employee{id=125, name='mithil', dept='SWE Intern', salary=35000}Employee{id=124, name='Rakesh', dept='CyberSecurity', salary=135000}Employee{id=123, name='Trinadh', dept='SDE', salary=150000}Employee{id=126, name='kiran', dept='Senior Software Engineer', salary=200000}

        //Approach 5:
        System.out.println("\n---> by using Method Reference instead of lambda expressiong using Streams : ");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::print);
        //output: Employee{id=125, name='mithil', dept='SWE Intern', salary=35000}Employee{id=124, name='Rakesh', dept='CyberSecurity', salary=135000}Employee{id=123, name='Trinadh', dept='SDE', salary=150000}Employee{id=126, name='kiran', dept='Senior Software Engineer', salary=200000}
    }
}
