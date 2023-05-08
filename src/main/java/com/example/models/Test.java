package com.example.models;

public class Test {
    public static void main(String[] args) throws Exception {
        for (int i = 201; i < 800; i++) {
            if (i % 5 == 0 && i % 10 == 0 && i % 15 == 0) {
                System.out.println(i);
            }
        }
    }
}
