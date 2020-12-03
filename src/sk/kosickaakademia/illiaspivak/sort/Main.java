package sk.kosickaakademia.illiaspivak.sort;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> listA = readFile("resource\\a.txt");
        ArrayList<Integer> listB = readFile("resource\\b.txt");
        int a = numberOfElements("resource\\a.txt");
        int b = numberOfElements("resource\\b.txt");
        System.out.println("Subor A:");
        printList(listA, a);
        System.out.println();
        System.out.println("Subor B:");
        printList(listB, b);

    }

    /**
     * Metota citanie suborov, vrati ArrayList
     */
    public static ArrayList<Integer> readFile (String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner( new File(fileName) );

        ArrayList<Integer> list = new ArrayList<Integer>();

        while (sc.hasNext()){
            list.add(sc.nextInt());
        }
        return list;
    }
    /**
     * Metoda aby zistit rozmer subora
     */
    public static int numberOfElements (String fileName ) throws FileNotFoundException {
        Scanner sc = new Scanner( new File(fileName) );
        int number = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (sc.hasNext()){
            list.add(sc.nextInt());
            number++;
        }
        return number;

    }
    /**
     * Metoda aby vypisat elementy ArrayList
     */
    public static void printList (ArrayList<Integer> a, int b){
        for(int i=0;i<b;i++) {
            System.out.print(a.get(i) + " ");
        }
    }
}
