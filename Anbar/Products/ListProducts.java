package Products;

import Exceptions.ThisPartCantBeNegative;
import Interface.Inteface;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Transaction.Transaction;
import  Transaction.TransactionType ;

public class ListProducts extends  Products {


    public static List<Products> listAga = new ArrayList<>();
    public static List<Products> listElcin = new ArrayList<>();
    public static List<Products> listJabrail = new ArrayList<>();
    public static List<Products> listQedir = new ArrayList<>();
    public static List<Products> listRahil = new ArrayList<>();
    public static List<Products> listTural = new ArrayList<>();
    public static List<Products> listMehemmed = new ArrayList<>();
    public static List<Products> listMahsun = new ArrayList<>();
    public static List<Products> listRashid = new ArrayList<>();




    public static void mallar() {
        Products a1 = new Products(1, "Pirus", 10000, 3, "Toyota"
                , Products.productType.CAR, 2010, "Japan ");
        Products a2 = new Products(2, "PS5", 3000, 10, "SONY"
                , Products.productType.GAME_CONSOLE, 2020, "JAPAN");
        listAga.add(a1);
        listAga.add(a2);


        Products b1 = new Products(1, "Iphone12", 3000, 50, "Apple"
                , Products.productType.SMARTPHONE, 2020, "China ");
        Products b2 = new Products(2, "S21", 3500, 20, "Samsung"
                , Products.productType.SMARTPHONE, 2021, "China ");
        listElcin.add(b1);
        listElcin.add(b2);


        Products c1 = new Products(1, "TW-BJ100M4TR(SK)", 1200, 15, "Toshiba"
                , Products.productType.DISHWASHER, 2020, "Japan ");
        Products c2 = new Products(2, "SXB206/01", 260, 35, "Philips"
                , Products.productType.VAACUM_CLEANER, 2019, "China ");
        listJabrail.add(c1);
        listJabrail.add(c2);


        Products d1 = new Products(1, "KD-65XH8096", 2800, 8, "Sony"
                , Products.productType.TV, 2020, "Japan ");
        Products d2 = new Products(2, "DELUXE 32 KV", 1000, 12, "HOFFMANN"
                , Products.productType.COMBI, 2019, "Germany");
        listQedir.add(d1);
        listQedir.add(d2);


        Products e1 = new Products(1, "Apple Watch SE 44 mm Silver Gray", 870, 22, "Apple"
                , Products.productType.SMARTWATCH, 2020, "China");
        Products e2 = new Products(2, "XBOOM FH 2 ", 399, 15, "LG"
                , Products.productType.MUSIC_CENTER, 2019, "sOUTH KOREA");
        listRahil.add(e1);
        listRahil.add(e2);


        Products f1 = new Products(1, "SSD 240 GB", 120, 30, "Kingston"
                , Products.productType.SSD, 2020, "USA");
        Products f2 = new Products(2, "PowerShot sx 430 IS ", 599, 11, "Canon"
                , Products.productType.CAMERA, 2019, "Japan");
        listTural.add(f1);
        listTural.add(f2);


        Products i1 = new Products(1, "PIR-2186", 29, 24, "Polaris"
                , Products.productType.İRON, 2020, "USA");
        Products i2 = new Products(2, "HD 2501 Black Red", 49, 16, "Zimmer"
                , Products.productType.HAIR_DRYER, 2018, "USA");
        listMehemmed.add(i1);
        listMehemmed.add(i2);


        Products g1 = new Products(1, "X541uv-GQ1563", 1499, 7, "Asus"
                , Products.productType.LAPTOP, 2020, "USA");
        Products g2 = new Products(2, "LT12R410W  12000 BTU", 799, 15, "Lotus"
                , Products.productType.AIR_CONDITION, 2017, "India");
        listMahsun.add(g1);
        listMahsun.add(g2);


        Products h1 = new Products(1, "MW-1504", 35, 21, "Maxwell"
                , Products.productType.TOSTER, 2020, "USA");
        Products h2 = new Products(2, "SE2416H", 349, 14, "Dell"
                , Products.productType.MONITOR, 2016, "USA");
        listRashid.add(g1);
        listRashid.add(g2);


    }

    static Scanner scan = new Scanner(System.in);


    //-----------------------  M A L  E L A V E S I-------------------------------------------------

    public  void malElave() {
        System.out.println("Elave etmek istediyiniz malin mehsul siyahisindaki yerini secin ");
        int elaveMalSirasi=scan.nextInt();
        if (elaveMalSirasi<0){
            throw new ThisPartCantBeNegative("Malin sirasi menfi ola bilmez") ;
        }
        System.out.println("Elave  etmek istediyiniz malin adini  daxil edin");
        String elaveAMalAdi = scan.next();
        System.out.println("Elave etmek istediyiniz malin qiymetini daxil edin");
        double elaveMalQiymeti = scan.nextDouble();
        if(elaveMalQiymeti<0){
            throw new ThisPartCantBeNegative("Malin qiymeti menfi ola bilmez");
        }
        System.out.println("Elave etmek istediyinzi malin sayini daxil edin ");
        int elaveMalSayi = scan.nextInt();
        if(elaveMalSayi<0){
            throw new ThisPartCantBeNegative("Malin sayi menfi ola bilmez") ;
        }
        System.out.println("Elave etmek istediyiniz mali istehsal eden muesisenin adini daxil edin ");
        String elaveMalinFirmasi = scan.next();
        System.out.println("Elave etmek istedyiniz malin novunu daxil edin");
       String elaveMalinNovu= scan.next();
         productType valueOfEnum = productType.valueOf(elaveMalinNovu);
        System.out.println("Elave etmek istediyiniz malin istehsal tarixini daxil edin");
        int  elaveMalinIstehsalTarixi= scan.nextInt();
        if(elaveMalinIstehsalTarixi<0){
            throw new ThisPartCantBeNegative("Istehsal tarixi  menfi ola bilmez") ;
        }
        System.out.println("Elave etmek istediyiniz malin istehsal yerini daxil edin");
        String elaveMalinIstehsalYeri= scan.next();

        Products yeniMal = new Products( elaveMalSirasi,elaveAMalAdi,
                elaveMalQiymeti, elaveMalSayi, elaveMalinFirmasi,valueOfEnum
                , elaveMalinIstehsalTarixi,elaveMalinIstehsalYeri);

        System.out.println(yeniMal.toString());

        Inteface.LoginList.add(yeniMal);
        System.out.println(Inteface.LoginList.toString());

        Transaction tran = new Transaction(  elaveAMalAdi , TransactionType.ADDING,elaveMalSayi, LocalDateTime.now());
        Transaction.transactions.add(tran);
    }


    public static void malInfo (){
        System.out.println(Inteface.LoginList.toString());
    }

}