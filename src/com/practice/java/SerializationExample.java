package com.practice.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SerializationExample implements Serializable {
    private int i, j; // Normal variables
    private transient int k; // Transient variables

    // Use of transient has no impact here
    private transient static int l;
    private transient final int m = 50;

    private SerializationExample(int i, int j, int k, int l) {
        this.i = i;
        this.j = j;
        this.k = k;
        SerializationExample.l = l;
    }

    public static void main(String[] args) throws Exception {
        SerializationExample input = new SerializationExample(10, 20, 30, 40);
        String fileName = "C:\\Users\\Gaurav\\Desktop\\SerializationExample.txt";

        // serialization
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(input);

        // de-serialization
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        SerializationExample output = (SerializationExample) ois.readObject();

        System.out.println("i = " + output.i);
        System.out.println("j = " + output.j);
        System.out.println("k = " + output.k);
        System.out.println("l = " + output.l);
        System.out.println("m = " + output.m);
    }

    // Invoked when writeObject() is called
    private void writeObject(ObjectOutputStream stream) throws IOException {
        System.out.println("writeObject called");
        stream.writeInt(100);
        stream.writeInt(200);
        stream.writeInt(300);
        stream.writeInt(400);
    }

    // Invoked when readObject() is called
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        System.out.println("readObject called");
        i = stream.readInt();
        j = stream.readInt();
        k = stream.readInt();
        l = stream.readInt();
    }
}