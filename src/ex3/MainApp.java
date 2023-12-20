package ex3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws IOException {
        BufferedReader flux_in;
        String nume_fis="ex3_in.txt";
        flux_in = new BufferedReader(new FileReader(nume_fis));
        String str=flux_in.readLine();
        flux_in.close();
        System.out.println(str);

        Scanner sca=new Scanner(System.in);


        System.out.println("cate charactere vor fi sterse?");
        int cs= sca.nextInt();
        int ind=0;
        boolean b=false;
        while(b==false){
            System.out.println("de la ce index?");
            ind= sca.nextInt();
            if(str.length()>=ind){
                b=true;
            }
        }
        StringBuffer sb=new StringBuffer(str);
        int i=ind-1;
        int j=0;
        while(j<cs){
            j++;
            i++;
            sb.deleteCharAt(i);
            System.out.println(sb);
            i--;
        }


        System.out.println(sb);
    }
}
