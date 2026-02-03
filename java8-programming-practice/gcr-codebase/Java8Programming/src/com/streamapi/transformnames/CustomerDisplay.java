package com.streamapi.transformnames;

import java.util.Arrays;
import java.util.List;

public class CustomerDisplay {
    public static void main(String[] args) {
        List<String> customers = Arrays.asList(
            "samarjeet",
            "rahul",
            "amit",
            "neha",
            "priya"
        );
        customers.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
    }
}