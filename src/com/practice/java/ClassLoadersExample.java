package com.practice.java;

import java.util.ArrayList;

public class ClassLoadersExample {

    public static void main(String[] args) {
        System.out.println("Classloader of this class:" + ClassLoadersExample.class.getClassLoader());
        System.out.println("Classloader of ArrayList:" + ArrayList.class.getClassLoader());
    }
}
