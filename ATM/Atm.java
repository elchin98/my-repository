package Bank;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Atm   {
    Scanner scan = new Scanner(System.in);
    Random ran = new Random();
    private final String id = "";
    private String cardHolderName;
    private String password = "123456";
    private String type;
    private double balance = 500.00;
    private int sifre = ran.nextInt(9999);
    //List<Method> Tran = new ArrayList<>();


    public Atm(String id,
               String cardHolderName,
               String password,
               String type,
               double balance) {
        //this.id = id;
        this.cardHolderName = cardHolderName;
        this.password = password;
        this.type = type;
        this.balance = balance;
    }

    public Atm(String id,
               String cardHolderName,
               String password) {
        //this.id = id;
        this.cardHolderName = cardHolderName;
        this.password = password;
        this.balance = 0;
    }

    public  Atm() {
    }
    public Atm (double balance) {

    }


    public static void main(String[] args) {
       Atm m = new Atm();
        Scanner sc = new Scanner(System.in) ;
        System.out.println("qisa kod : " + m.sifre); //  bunu yazmaga ehtiyac var
        List<Object> Tran = new ArrayList<>();
        Tran.add(Function.zaman()) ;
      //  Tran.add(Function.BalansNe(m.balance));
      //  Tran.add(Function.Transfer(m.sifre, m.balance));

        for (int i = 0; i<=3;) {
            System.out.println("Pin kodu  daxil edin :" + "");
            String kod = sc.next();
            if (kod.equals(m.password)) {
                System.out.println(" Bir emeliyyat secin :");
                System.out.println(" 1 - Balansi oyrenmek");
                System.out.println(" 2 - Pul  cixarmaq");
                System.out.println(" 3 - Pul  transferi");
                break;
            } else if (kod!=m.password) {
                System.out.println(" Kod  yanlisdir ");
                    i++;
                     if (i==3){
                    System.out.println(" Siz  kecid kodu  bir nece  defe  yanlis  daxil  etdiyinize  gore");
                         System.out.print("  emeliyyat dayandirilmis  ve  kartiniz  bloklanmisdir ");
                    System.exit(0);
                }
            }
        }
        byte operation = sc.nextByte();

        if( operation==1){
            Function.BalansNe(m.balance);
        }
        else if ( operation==2) {
            Function.Withdraw(m.balance);
        }
        else if (operation==3){
            Function.Transfer(m.sifre,m.balance);
        }
        else {
            System.out.println(" Zehmet  olmasa 3  emeliyyatdan birini secin");
        }


    }
}
