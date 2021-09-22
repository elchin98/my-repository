package Interface;

import Accounts.Account;
import Products.Products;
import Products.ListProducts;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Inteface {

   public  static  List<Account> accounts =  new ArrayList<>();
    public  static  List<Products> LoginList =  new ArrayList<>();
    public static Account object = null;
    Random random = new Random();
     int qisaKod= random.nextInt(9999);



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ListProducts ob1 = new ListProducts();
        Products obj2 = new Products();
        hesab();
        ListProducts.mallar();

        boolean enteringData = true;
do {
        System.out.println(" Welcome to the store :)\n Please enter account ID ");
        String ID = scan.next();
        for (Account acc : accounts) {
            if (acc.getAccountId().equals(ID)) {

                object = acc;
                LoginList = object.list;
                System.out.println(LoginList.toString());
                System.out.println(object.list.toString());

            }
        }


        if (object != null) {
            for (int i = 0; i <=3; i++) {
                if (i == 3) {
                    System.out.println("You entered the password wrong  3 time continously");
                   return;
                }
                System.out.println("Please enter the password :");
                System.out.println(object.getPassword()  + "   | This is for  remembering  password  |");
                String password = scan.next();
                if (password.equals(object.getPassword())) {
                    System.out.println(" Welcome to the STore !");
                    enteringData=false;
                    break;
                } else {
                    System.out.println("Password you entered is WRONG");

                }
            }

        } else {
            System.out.println(" Dont matching with any account by ID you entered");

        }
    }while (enteringData);



        Inteface bos = new Inteface();
        System.out.println(bos.qisaKod +"   | Bu kod  random  olaraq  verilen  kod  oldugu  ucun  gosterilir |");
        boolean redd = true;
        do {
            System.out.println("Zehmet olmasa size  gonderilen   kodu  daxil edin :");
            int sifre = scan.nextInt();

            if (sifre == bos.qisaKod) {
                System.out.println("Welcome");
                break;
            }
            else {
                boolean yoxlama ;
                do {
                    yoxlama=false;
                    System.out.println("Daxil etdiyiniz sifre  yanlisdir");
                    System.out.println("Sifreni  yeniden daxil etmek    ucun 1 :  emeliyyati sonlandirmaq ucun 0 daxil edin");
                    int secim = scan.nextInt();
                    if (secim == 1) {
                        redd = true;
                    }
                    if (secim != 1& secim!=0) {
                        yoxlama=true;
                    }
                    if(secim==0){
                        System.out.println("Bizi  secdiyiniz ucun minnetdariq :)");
                        System.exit(0);
                    }

                }while (yoxlama);
            }
        } while (redd) ;


  boolean emeliyataDavamYaYox = true;
do {
        System.out.println("Hesab  emeliyyatlari ucun 1-i secin :\n  Anbar emeliyyatlari ucun 2-i secin  \n Prosesi sonlandirmaq ucun 0 daxil edin");
        int secim = scan.nextInt();
        if (secim == 1) {
            System.out.println("Hesab melumatlarini goruntulemek ucun 1-i secin");
            int hesabSecim = scan.nextInt();
            if (hesabSecim == 1) {
                System.out.println(object.toString());
            }
            System.out.println("Davam etmek isteyirsinizse 1 daxil edin \n Eks halda 0 daxil edin");
            int interFaceDavam = scan.nextInt();
            if (interFaceDavam==1 ){
                emeliyataDavamYaYox=true;
            }
            if(interFaceDavam!=1){
                return;
            }
        }

        if (secim==2) {
            System.out.println(" Anbardaki mehsullar barede melumat elde etmek ucun 1  daxil edin \n" +
                    "" + "Mal elave etmek isteyirsinizse 2 daxil edin\n" +
                    "Her hansi mali silmek isteyirsinizse 3 daxil edin \nMal transfer etmek isteyirsinizse 4 daxil edin\n" +
                    " Emeliyyat tarixcesini  goruntulemek ucun 5 daxil edin");
            int anbarEmelyat = scan.nextInt();


            if(anbarEmelyat==1){
                ListProducts.malInfo();
            }
            if (anbarEmelyat == 2) {
                ob1.malElave();
            }
            if (anbarEmelyat == 3) {
                obj2.malSilinmesi();
            }
            if (anbarEmelyat == 4) {
                obj2.transfer();
            }
            if (anbarEmelyat == 5) {
                obj2.showHistory();
            }



            System.out.println("Davam etmek isteyirsinizse 1 daxil edin \n Eks halda 0 daxil edin");
            int interFaceDavam = scan.nextInt();
            if (interFaceDavam==1 ){
                emeliyataDavamYaYox=true;
            }
            if(interFaceDavam!=1){
                return;
            }
        }
        if (secim !=2 & secim != 1){
            return;
        }
    }while (emeliyataDavamYaYox);



    }
    public static void  hesab () {
        Account a1 = new Account("101010", "Agha@", "12345", 5400, ListProducts.listAga);
        Account a2 = new Account("202020", "Elcin98@", "12345", 3700,ListProducts.listElcin);
        Account a3 = new Account("303030", "Jabrail@", "12345", 1500,ListProducts.listJabrail);
        Account a4 = new Account("404040", "Qedir@", "12345", 2240,ListProducts.listQedir);
        Account a5 = new Account("505050", "Rahil@", "12345", 1200,ListProducts.listRahil);
        Account a6 = new Account("606060", "Tural@", "12345", 75000,ListProducts.listTural);
        Account a7 = new Account("707070", "Mehemmed@", "12345", 4250,ListProducts.listMehemmed);
        Account a8 = new Account("808080", "Mahsun@", "12345", 2600,ListProducts.listMahsun);
        Account a9 = new Account("909090", "Rashid@", "12345", 3200,ListProducts.listRashid);

        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a3);
        accounts.add(a4);
        accounts.add(a5);
        accounts.add(a6);
        accounts.add(a7);
        accounts.add(a8);
        accounts.add(a9);

    }
}
