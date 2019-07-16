package com.stackoverflow;

import java.lang.reflect.Field;
import java.util.Scanner;

public class PrintVariable {

    public static void main(String[] args) throws IllegalAccessException {
        String A = "something";
        String userInput = new Scanner(System.in).nextLine();
        System.out.print(userInput);

        PrintVariable printVariable = new PrintVariable();
        printVariable.getVariableValue();
    }

    private void getVariableValue() throws IllegalAccessException {
        Field[] fields = getClass().getFields();

        for(Field field : fields) {
            String name = field.getName();
            Object value = field.get(this);
            System.out.println(name + ": " + value.toString());
        }
    }
}
