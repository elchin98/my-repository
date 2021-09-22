package Bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Function {

    LocalDateTime vaxt;
    DateTimeFormatter esas;

    public static String zaman() {

        LocalDateTime vaxt = LocalDateTime.now();
        DateTimeFormatter esas = DateTimeFormatter.ofPattern("dd-MM-YY   hh:mm");
        return esas.format(vaxt);
    }

    public static void BalansNe(double gh) {
        // Function f = new Function();
        System.out.println(" Balans: " + gh);
        System.out.println(zaman());
    }


    public static void Withdraw(double balance) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zehmet  olmasa  meblegi daxil edin :");
        double mebleg = sc.nextDouble();
        if (mebleg < balance) {
            balance -= mebleg;
            System.out.println(" Emeliyyat icra olundu");
            System.out.println("Balans:" + balance);
            System.out.println(zaman());
        } else {
            System.out.println("Kartda kifayet qeder vesait yoxdur");
            System.out.println(zaman());
        }
    }

    public static void Transfer(int sifre, double balance) {
        Scanner scan = new Scanner(System.in);
        System.out.println(" Gondermek istediyiniz hesabin nomresini daxil edin :");
        long hesabNomresi = scan.nextLong();
        System.out.println(" Hesab  sahibinin ad ve soyadini daxil edin");
        String ad = scan.next();
        String soyad = scan.next();
        System.out.println(" Gondermek istediyiniz  meblegi daxil edin ");
        long transferMeblegi = scan.nextLong();
        System.out.println("Zehmet olmasa size  gonderilen  4 reqemli kodu  daxil edin :");
        int qisaKod = scan.nextInt();
        if (qisaKod == sifre) {
            if (transferMeblegi <= balance) {

                System.out.println("Pul transferi  icra olundu ");
                balance -= transferMeblegi;
                System.out.println("Balans:" + balance);
                System.out.println(zaman());
            } else {
                System.out.println(" Bu emeliyyat ucun balansinizda kifayet qeder  vesait yoxdur");
                System.out.println(zaman());
            }
        } else {
            System.out.println(" Daxil etdiyiniz sifre yanlisdir");
        }}

    }

