package chapter05;

import org.w3c.dom.ls.LSOutput;

public class Queue {

    char[] q;
    int putIndex, getIndex;


    Queue(int size) {
        q = new char[size]; // memory
        putIndex = getIndex = 0; // at the beginning, put and get locations are the same
    }

    void put(char ch) {
        if (putIndex == q.length) {
            System.out.println(" - Queue is full.");
            return; // Avoid ArrayIndexOutOfBoundsException exception
        }

        q[putIndex++] = ch; // add a new character and increase the putIndex
    }

    char get() {
        if (getIndex == putIndex) {
            System.out.println(" - Queue is empty");
            return (char) 0;
        }
        return q[getIndex++];
    }

    //Demonstration
    public static void main(String[] args) {
        Queue bigQ = new Queue(100);
        Queue smallQ = new Queue(4);
        char ch;
        int i;

        System.out.println("Using bigQ to store the alphabet.");
        for( i=0; i < 26; i++) {
            bigQ.put((char) ('A' + i));
        }

        System.out.println("Contents of bigQ: ");
        for (i = 0; i < 26; i++) {
            ch = bigQ.get();
            if (ch != (char) 0) System.out.print(ch);
        }

        System.out.println("\n");

        System.out.println("Using smallQ to generate errors.");

        for (i = 0; i < 5; i++) {
            System.out.print("Attempting to store " + (char) ('Z' - i));
            smallQ.put((char) ('Z' - i));
            System.out.println();
        }

        System.out.println();

        System.out.println("Contents of smallQ: ");
        for (i=0; i < 5; i++) {
            ch = smallQ.get();
            if(ch != (char) 0) System.out.print(ch);
        }
    }
}
