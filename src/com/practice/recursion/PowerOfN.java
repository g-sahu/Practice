package com.practice.recursion;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import static java.math.BigDecimal.*;

public class PowerOfN {
    private static BigDecimal i = ONE;
    private static BigDecimal n;
    private static BigDecimal x = ONE;
    private static FileWriter file;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        n = new BigDecimal(scanner.nextInt());
        file = new FileWriter("C:\\Users\\Gaurav\\Desktop\\hello.txt");
        PowerOfN obj = new PowerOfN();
        obj.power();
        file.close();
    }

    private void power() throws IOException {
        x = x.multiply(n);

        if(i.equals(n)) {
            for(BigDecimal j=ONE; j.compareTo(x) <= 0; j = j.add(ONE)) {
                file.write("H\n");
            }
        } else {
            power();
        }

        i = i.add(ONE);
    }
}
