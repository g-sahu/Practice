package com.practice.sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class NewInsertionSort {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Users\\Gaurav\\Desktop\\Array.txt"));
        int[] arr = new int[100000];
        int x = 0;

        while (sc.hasNext()) {
            arr[x++] = sc.nextInt();
        }

        int temp;
        long start = System.currentTimeMillis();

        for(int i=1; i<arr.length; i++) {
            for (int j=0; j<i; j++) {
                if(arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println("Time taken: " + (end - start));
    }
}
