package com.trinadh.java8Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo01 {
    public static void main(String args[]){

        List<Student> studentList = Stream.of(
                new Student(1,"Trinadh",28,"Male","computer","chicago",120, Arrays.asList("+13127921025","+917305786115")),
                new Student(2,"Rakesh",25,"Male","electronics","naperville",1, Arrays.asList("+123445","+567885")),
                new Student(3,"kiran",27,"Male","cyber","chicago",12, Arrays.asList("+123446","+567886")),
                new Student(4,"kitturayala",26,"Male","cyber","chicago",12, Arrays.asList("+123446","+567886")),
                new Student(5,"rob",27,"female","maths","mendota",12, Arrays.asList("+123447","+567887")),
                new Student(6,"michael",29,"male","science","jersey",10, Arrays.asList("+131279210255","+9173057861154")))
                .collect(Collectors.toList());

        //1. Find the students whose rank is in between 1 to 12
        List<Student> students = studentList.stream()
                .filter(student -> student.getRank() >= 1 && student.getRank() <= 12)
                .collect(Collectors.toList());
        System.out.println(students);

        List<Student> studentsWithRankLessThan10 = studentList.stream()
                .filter(student -> student.getRank() < 10)
                .collect(Collectors.toList());
        System.out.println("studentsWIthRankLessThan10 : \n" + studentsWithRankLessThan10);

        //2. Find the students who stays in chicago
        List<Student> studentsInChicago = studentList.stream()
                .filter(student -> student.getCity().equalsIgnoreCase("chicago"))
                .collect(Collectors.toList());

        System.out.println("studentsInChicago :\n "+ studentsInChicago);

        //2.1 Find the students who stays in chicago and sort them by their names
        List<Student> studentsInChicagoWithSortedNames = studentList.stream()
                .filter(student -> student.getCity().equalsIgnoreCase("chicago"))
                .sorted(Comparator.comparing(Student::getFirstName, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println("StudnetInChicagoWithSortedNames :\n "+ studentsInChicagoWithSortedNames);

        //3. Find all Department Names
        List<String> allDepartmentNames = studentList.stream()
                .map(Student::getDept)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("allDepartmentNames : \n" + allDepartmentNames);

        //3.1 Find all Department Names using Set
        Set<String> allDepartmentNamesUsingSet = studentList.stream()
                .map(Student::getDept)
                .collect(Collectors.toSet());
        System.out.println("allDepartmentNamesUsingSet : \n" + allDepartmentNamesUsingSet);

        //3.2 Find all Department names using list or set but needed department names in ordered in Ascending Order
        Set<String> allDepartmentAscOrder = studentList.stream()
                .sorted(Comparator.comparing(Student::getDept))
                .map(Student::getDept)
                .collect(Collectors.toSet());

   System.out.println("allDepartmentAscOrder :\n "+ allDepartmentAscOrder);
         //3.3 Find all Department names using set and departments names in DescingOrder / ReverseOrder
        Set<String> allDepartmentDescOrder = studentList.stream()
                .sorted(Comparator.comparing(Student::getDept,Comparator.reverseOrder()))
                .map(Student::getDept)
                .collect(Collectors.toSet());
        System.out.println("allDepartmentDescOrder :\n "+ allDepartmentDescOrder);

        //4. Find all the contact numbers
        List<String> contacts = studentList.stream()
                .flatMap(student -> student.getContacts().stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("contacts : " + contacts);
/*

IMPORTANT : flatmap -> The "flatMap" method is a powerful tool in the Java Stream API
that allows you to transform each element of a stream into a new stream of elements,
and then combine all those streams into a single stream.

One2One -> map
One2Many -> flatmap
 */

        //5. Group the Student by Department Names
       Map<String, List<Student>> groupingStudentsByDepartmentNames = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept));
       System.out.println("groupingStudentsByDepartmentNames : \n "+ groupingStudentsByDepartmentNames);


  //6. Find the department who is having maximum number of students
        Map.Entry<String, Long> results = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("results : " + results);

   //7. Find the average age of male and female students


        //----------------------------------------------------- 2025, January 24th, Friday--------------------------------
        System.out.println("8. Print all the phone Numbers ");
        List<String> phoneNumbersList = studentList.stream()
                .flatMap(std -> std.getContacts().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(phoneNumbersList);

        System.out.println("9. Print Group the Students by Department Names : ");

        Map<String, List<Student>> groupStudentsByDept = studentList.stream()
                .collect(Collectors.groupingBy(Student :: getDept));
        System.out.println(groupStudentsByDept);

      System.out.println("9.1 Print Group the Students by Department Names : Only FistNames in the list");

      Map<String ,List<String>> groupStudentsByDeptFirstNames = studentList.stream()
              .collect(Collectors.groupingBy(
                      Student :: getDept,
                      Collectors.mapping(Student::getFirstName, Collectors.toList())
              ));
      System.out.println(groupStudentsByDeptFirstNames);

        System.out.println("9.2. Print Group the Students by Department Names : Only FirstNames in the list in AscendingOrder");

        Map<String, List<String>> groupStudentsByDeptFirstNamesInAscendingORder = studentList.stream()
                .collect(Collectors.groupingBy(
                        Student :: getDept,
                        Collectors.mapping(Student::getFirstName, Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream().sorted().collect(Collectors.toList())
                        ))
                ));
        System.out.println(groupStudentsByDeptFirstNamesInAscendingORder);


    }
}
