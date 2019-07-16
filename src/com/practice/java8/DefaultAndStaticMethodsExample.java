package com.practice.java8;

import static java.lang.Thread.currentThread;

public class DefaultAndStaticMethodsExample {

    public static void main(String[] args) {
        Java8Class.staticMethod(); //This calls the method in Java8Class, not Java8Interface
        Java8Interface.staticMethod(); //This calls the method in Java8Interface, not Java8Class

        Java8Class java8Class = new Java8Class();
        java8Class.defaultMethod();
    }

}


interface Java8Interface {
    void showMe(); //Needs to be implemented

    //Doesn't needs to be implemented in implementing class(es)
    default void defaultMethod() {
        System.out.println(Java8Interface.class.getSimpleName() + " : " + currentThread().getStackTrace()[1].getMethodName());
    }

    //Not available to implementing class
    static void staticMethod() {
        System.out.println(Java8Interface.class.getSimpleName() + " : " + currentThread().getStackTrace()[1].getMethodName());
    }
}

class Java8Class implements Java8Interface {
    public void showMe() {
        System.out.println(getClass().getSimpleName() + " : " + currentThread().getStackTrace()[1].getMethodName());
    }

    static void staticMethod() {
        System.out.println(Java8Class.class.getSimpleName() + " : " + currentThread().getStackTrace()[1].getMethodName());
    }
}