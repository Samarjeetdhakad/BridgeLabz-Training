package com.collectors.studentresultgrouping;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
public static void main(String[]args) {
	List<Student> list=List.of(new Student("jay","A"),new Student("raj","B"),
			new Student("dev","A+"),new Student("yug","A"),new Student("ananya","B"));
	Map<String ,List<String>> byGrade=list.stream().collect(Collectors.groupingBy(Student:: getGrade,Collectors.mapping(Student:: getName,Collectors.toList())));
	System.out.println(byGrade);
}
}