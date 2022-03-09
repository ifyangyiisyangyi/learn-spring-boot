package com.example.yang.job;

public class Test {
    public static void main(String[] args) {
        Boolean a = true;
        int b = 0;
        while (a) {
            b++;
            System.out.println(b);
            if (b == 10) {
                a = false;
            }
        }
    }
}
