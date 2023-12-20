package ex1;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args)throws IOException{
        BufferedReader flux_in;
        String nume_fis="judete_in.txt";
        flux_in = new BufferedReader(new FileReader(nume_fis));
        String linie;
        int n=0;

        //aflam nr de linii

        while((linie=flux_in.readLine())!=null){
            n++;
        }

        flux_in.close();
        flux_in = new BufferedReader(new FileReader(nume_fis));
        String[] judete = new String[n];
        n=0;

        //citim judetele in vector
        while ((linie = flux_in.readLine()) != null) {
            judete[n] = linie;
            n++;
        }

        //afisare fara sortare
        for(int i=0;i<n;i++){
            System.out.println(judete[i]);
        }
        flux_in.close();
        Arrays.sort(judete);
        System.out.println();

        //afisare cu sortare
        for(int i=0;i<n;i++){
            System.out.println(judete[i]);
        }

        Scanner s=new Scanner(System.in);
        System.out.println("ce judet cauti?");
        String jud=s.next();

        System.out.println(Arrays.binarySearch(judete,jud));

    }
}
