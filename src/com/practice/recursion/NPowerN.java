package com.practice.recursion;

import java.util.Scanner;

public class NPowerN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long exp = computeNPower(n);
        System.out.print("Exponential Value is : " + exp);
        printHelloWorld(exp);
        scanner.close();
    }

    private static long computeNPower(int n){
        long exponenetial = 1;
        for(int i = 0 ; i < n ; i++){
            exponenetial *= n;
        }
        return exponenetial;
    }

    private static void printHelloWorld(long n){
        for(int i = 0 ; i <n ; i++){
            System.out.println("Hello World : " + i);
        }
    }

}