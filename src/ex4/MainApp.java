package ex4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        class Persoana{
            private String nume, cnp;
            Persoana(String Nume,String Cnp){
                nume=Nume;
                cnp=Cnp;
            }
            String getNume(){
                return nume;
            }
            String getCnp(){
                return cnp;
            }


            long calcVarsta(String cnp){
                LocalDate dt1 =LocalDate.now();
                //System.out.println(dt1);
                int an=0;
                if(cnp.toCharArray()[0]=='1'||cnp.toCharArray()[0]=='2'){
                    an=1900;
                }else{
                    an=2000;
                }
                an=an+(byte)(cnp.toCharArray()[1]-'0')*10+ (byte)(cnp.toCharArray()[2]-'0');
                //System.out.println(an);


                int month=(byte)(cnp.toCharArray()[3]-'0')*10+(byte)(cnp.toCharArray()[4]-'0');
                int day=(byte)(cnp.toCharArray()[5]-'0')*10+(byte)(cnp.toCharArray()[6]-'0');

                LocalDate d2 = LocalDate.of(an, month, day);
                long nr_ani= ChronoUnit.YEARS.between(d2, dt1);
                return nr_ani;
            }

        }


        Scanner sc=new Scanner(System.in);
        int n=0;
        String UInume,UIcnp="5000101000000";
        boolean b;
        int len;
        System.out.println("Cate persoane?");
        n=sc.nextInt();
        Persoana v[] = new Persoana[n];
        for(int i=0;i<n;i++) {
            System.out.println("Numele persoanei "+(i+1)+"? ");
            UInume=sc.next();
            b=false;
            while(b==false){
                System.out.println("CNP-ul persoanei "+(i+1)+"? ");
                UIcnp=sc.next();
                b=true;
                len=UIcnp.length();

                b = isValid(len,UIcnp);


                //REZULTAT VALIDARE
                if(b==true){
                    System.out.println("CNP valid");
                }else{
                    System.out.println("CNP invalid");
                }
            }
            Persoana p=new Persoana(UInume,UIcnp);
            //System.out.println(p.getNume() + " " + p.getCnp());
            v[i]=p;
        }

        System.out.println("     NUME     |        CNP       |   VARSTA   ");
        for(int i=0;i<n;i++){
            System.out.println(v[i].getNume() + " " + v[i].getCnp()+" "+v[i].calcVarsta(v[i].getCnp()));
        }

    }

    private static boolean isValid(int len, String UIcnp) {
        // VALIDARE
        //lungime
        if(len !=13){
            //b =false;
            System.out.println("CNP are 13 caractere ☒");
            return false;
        }else {
            System.out.println("CNP are 13 caractere ☑");


            //Toate caracterele sunt cifre
            for (char ch : UIcnp.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    System.out.println("Toate caracterele sunt cifre  ☒");
                    return false;
                }
            }
            // if (b) {
            System.out.println("Toate caracterele sunt cifre  ☑");
            if (UIcnp.toCharArray()[0] != '1' && UIcnp.toCharArray()[0] != '2' && UIcnp.toCharArray()[0] != '5' && UIcnp.toCharArray()[0] != '6') {
                //b = false;
                System.out.println("cifră are una din valorile 1, 2, 5, 6  ☒");
                return false;
            } else {
                System.out.println("cifră are una din valorile 1, 2, 5, 6  ☑");
            }
            // }

            if(UIcnp.toCharArray()[12]!=(char)(cifradecontrol(UIcnp))+'0'){
                //b =false;
                //System.out.println(UIcnp.toCharArray()[12]+" "+(char)(cifradecontrol(UIcnp)));
                System.out.println("Cifra de control a CNP-ului are o valoare validă  ☒");
                return false;
            }else{
                //b =true;
                System.out.println("Cifra de control a CNP-ului are o valoare validă  ☑");
            }
        }
        return true;
    }

    private static byte cifradecontrol(String UIcnp) {
        String numar = "279146358279";
        int x = 0;
        for (int i = 0; i < 12; i++) {
            char ch1 = UIcnp.toCharArray()[i];
            char ch2 = numar.toCharArray()[i];
            byte a = (byte) (ch1 - '0');
            byte b = (byte) (ch2 - '0');
            x = x + a * b;
        }
        //System.out.println(x+" "+(x%11));
        return (byte)(x%11);
    }

}
