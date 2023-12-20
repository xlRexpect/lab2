package ex2;

import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;

public class MainApp {
    public static void main(String[] args) throws IOException {
        BufferedReader flux_in;
        String nume_fis="cantec_in.txt";
        flux_in = new BufferedReader(new FileReader(nume_fis));
        String linie;
        int n=0;

        Random  rand=new Random();


        //aflam nr de linii
        while((linie=flux_in.readLine())!=null){
            n++;
        }

        flux_in.close();
        flux_in = new BufferedReader(new FileReader(nume_fis));
        String[] versuri = new String[n];
        n=0;

        //citim judetele in vector
        while ((linie = flux_in.readLine()) != null) {
            versuri[n] = linie;
            n++;
        }

        //afisare fara sortare
        for(int i=0;i<n;i++){
            System.out.println(versuri[i]);
        }

        String fis_out = "cantec_out.txt";
        PrintStream flux_out = new PrintStream(fis_out);
        int nr_cuv=0;
        int nr_voc=0;
        int vers_len=0;
        float val_gen=0;

        for(int i=0;i<n;i++){
            //nr de cuvinte
            nr_cuv=0;
            StringTokenizer st = new StringTokenizer(versuri[i]," ");
            while (st.hasMoreTokens()) {
                st.nextToken();
                nr_cuv++;
            }

            //nr de vocale
            nr_voc=0;
            vers_len=versuri[i].length();
            for(int j=0;j<vers_len;j++){
                String aux=versuri[i];
                aux=aux.toLowerCase();
                if(aux.charAt(j)=='a'||aux.charAt(j)=='e'||aux.charAt(j)=='i'||aux.charAt(j)=='o'||aux.charAt(j)=='u'){
                    nr_voc++;
                }

                if(versuri[i].endsWith("ta")){
                    versuri[i]=versuri[i]+" *";
                }
            }


            val_gen=rand.nextFloat(0,1);
            System.out.println(val_gen);
            if(val_gen<=0.4){
                StringBuffer sb=new StringBuffer(versuri[i]);
                char charAtIndex = versuri[i].charAt(0);
                //System.out.println(charAtIndex);
                char charInLowerCase = Character.toLowerCase(charAtIndex);  //!!! aproape toate versurile incep cu litera mare deci am facut cu lowercase
                sb.setCharAt(0,charInLowerCase);
                flux_out.println(sb + " " + nr_cuv + " " + nr_voc);
            }else {
                flux_out.println(versuri[i] + " " + nr_cuv + " " + nr_voc);
            }
        }


    }
}
