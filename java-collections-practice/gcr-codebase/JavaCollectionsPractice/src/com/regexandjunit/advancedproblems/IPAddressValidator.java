package com.regexandjunit.advancedproblems;

public class IPAddressValidator {
    public static void main(String[] args) {
        String[] ips = {
            "192.168.1.1",
            "255.255.255.255",
            "256.100.50.0",
            "123.45.67"
        };
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}"
                     + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        for (String ip : ips) {
            if (ip.matches(regex)) {
                System.out.println(ip + " → Valid");
            } else {
                System.out.println(ip + " → Invalid");
            }
        }
    }
}