package com.lambdaexpression.nameuppercasing;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

public class NameUpperCase {
    public static void main(String[] args) {
        List<String> names = Arrays.asList( "samarjeet", "Anita",  "Suresh","Priya");
        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
