package sk.kosickaakademia.illiaspivak.sort;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> listA = readFile("resource\\a.txt");
        ArrayList<Integer> listB = readFile("resource\\b.txt");
        int a = numberOfElements("resource\\a.txt");
        int b = numberOfElements("resource\\b.txt");
        System.out.println("Subor A:");
        printList(listA, a);
        System.out.println("Subor B:");
        printList(listB, b);
        numbersAnotB(listA, listB);
        numbersBnotA(listA, listB);
        ArrayList<Integer> listAB = unification(listA, listB);
        newC(listAB);

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
        System.out.println();
    }
    /**
     * Metoda vypisuje zo suboru a tie cisla, ktore sa nenachadzaju v subore b
     */
    public static void numbersAnotB(ArrayList<Integer> a, ArrayList<Integer> b){
        System.out.println("Cisla zo suboru A, ktore sa nenachadzaju v subore B ");
        for (Integer cislo : a)
            if (b.contains(cislo));
            else
                System.out.print(cislo + " ");
        System.out.println();
    }
    /**
     * Metoda vypisuje zo suboru b tie cisla, ktore sa nenachadzaju v subore a
     */
    public static void numbersBnotA(ArrayList<Integer> a, ArrayList<Integer> b){
        System.out.println("Cisla zo suboru B, ktore sa nenachadzaju v subore A ");
        for (Integer cislo : b)
            if (a.contains(cislo));
            else
                System.out.print(cislo + " ");
        System.out.println();
    }
    /**
     * Metoda vytvori ArrayList kde budu vsetky cisla zo suboru a aj b bez duplicit
     */
    public static ArrayList<Integer> unification (ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> c=new ArrayList<>();
        c.addAll(a);
        c.addAll(b);
        c = (ArrayList<Integer>) c.stream().distinct().collect(Collectors.toList());
        return c;
    }
    /**
     * Metoda vytvori subor c, kde bude arraylist suma AB
     */
    public   static void newC (ArrayList<Integer> c){
        try {
            File file = new File("resource\\c.txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            for (Integer cislo : c)
                fw.write(cislo + " ");
            fw.close();
        }catch (IOException ex){}
    }

}
