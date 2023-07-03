package com.interviews;

public class DiamondProblem {
    public static void main(String args[]) {
        Parent a = new Child();
        IParent b = new Child();
        Child c = new Child();

        a.print();
        b.print();
        c.print();
    }
}

class Parent {
    int x = 20;

    public void print() {
        System.out.println(x);
    }
}

interface IParent {
    int x = 10;

    void print();
}

class Child extends Parent implements IParent {
    public void print() {
        //System.out.println(x); //Ambiguous reference;
    }
}
