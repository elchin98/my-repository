package Products;

import Accounts.Account;
import Exceptions.ThisPartCantBeNegative;
import Interface.Inteface;
import Transaction.Transaction;
import  Transaction.TransactionType ;
import java.time.LocalDateTime;
import java.util.Scanner;

import static Products.ListProducts.scan;

public class Products {

    private int line ;
    private String producerFirm;
    private  String nameProduct ;
    private  int  numberOfProduct ;
    private  double priceOfProduct ;
    private int productionYear ;
    private String madeIn ;
    private  productType type;
    static int  productSayi ;



    public enum productType {
        SMARTPHONE,
        LAPTOP,
        CAR,
        GAME_CONSOLE,
        DISHWASHER,
        VAACUM_CLEANER,
        TV,
        COMBI,
        SMARTWATCH,
        MUSIC_CENTER,
        SSD,
        CAMERA,
        İRON,
        HAIR_DRYER,
        AIR_CONDITION,
        MONITOR,
        TOSTER



    }



public Products (int line,String nameProduct ,
                 double priceOfProduct ,
                 int numberOfProduct ,
                 String producerFirm ,
                    productType type,
                 int productionYear,
                 String madeIn){
    this.line = line ;
    this.nameProduct = nameProduct ;
    this.priceOfProduct = priceOfProduct;
    this.numberOfProduct = numberOfProduct;
    this.producerFirm = producerFirm;
    this.type = type;
    this.productionYear = productionYear;
    this.madeIn = madeIn ;
}


public Products(){

}

public  String getNameProduct(){ return  nameProduct ;}
public int  getNumberOfProduct(){return  numberOfProduct;}
public void setNumberOfProduct(){this.numberOfProduct=numberOfProduct;}
    public  int getLine(){ return  line ;}

    public productType getType() {
        return type;
    }

    public String toString() {
    return  "\n"+ line+ "-th product " + "\nProduct - " +nameProduct+ " \nPrice - " + priceOfProduct + "\nNumber - "
            +numberOfProduct + "\nProducerFirm - " + producerFirm +
            "\nTypeOfProduct - " + type + "\nProductionYear - " + productionYear + "\nMade In - "+ madeIn + "\n-----------------------";
}


//  ----------------------------------------M A L    T R A N S F E R ------------------------------------

    public  void transfer() {
        String productAdi;
        String nameProduct;
        String accountId;
        Scanner scan = new Scanner(System.in);
        Inteface obj = new Inteface();
        Account objTransferAcc = null;
        int davamYoxsaYox;
        //  Products prObj;

        boolean transferBoolean = true;
        do {
            System.out.println("Please enter ID of account  you want to transfer");
            accountId = scan.next();


            for (Account acc : Inteface.accounts) {
                if (acc.getAccountId().equals(accountId)) {
                    objTransferAcc = acc;
                    transferBoolean = false;

                }
            }
            if (objTransferAcc == null) {
                System.out.println(" Daxil  etdiyiniz ID nomresine uygun hesab tapilmadi");
                System.out.println("Emeliyyati  sonlandirmaq isteyirsinizse  0 \n" +
                        " Id nomresini yeniden daxil etmek isteyirsinizse 1 daxil edin  ");
                davamYoxsaYox = scan.nextInt();
                if (davamYoxsaYox == 0) {
                    return;
                } else if (davamYoxsaYox != 0) {

                }


            }


        } while (transferBoolean);

        boolean AdiId = true;
        boolean ikinci = true;
        Products deyisen = null;



        do { //AdiID
            System.out.println("Please enter name of product you want to transfer");
            productAdi = scan.next();
            for (Products test : Inteface.LoginList) {
                if (test.getNameProduct().equals(productAdi)) {
                    deyisen = test;
                    System.out.println(test.getNameProduct() + "" + productAdi);
                }
            }
            int removing=0;
            if (deyisen!=null) {
                removing = deyisen.getLine();
            }
            if (deyisen != null) {
                do {   // ikinci

                    System.out.println("Please enter number  of products you want to transfer");
                    productSayi = scan.nextInt();
                    if (productSayi < deyisen.getNumberOfProduct() & productSayi >0) {
                        deyisen.numberOfProduct -= productSayi;


                        System.out.println("qalan product sayi " + deyisen.numberOfProduct + "\n Listin toStringi" + deyisen.toString());
                        Products transferMal = new Products(3, deyisen.getNameProduct(),
                                deyisen.priceOfProduct, productSayi, deyisen.producerFirm,
                                deyisen.type, deyisen.productionYear, deyisen.madeIn);

                        objTransferAcc.list.add(transferMal);
                        System.out.println(objTransferAcc.list.toString());

                        Transaction  tran = new Transaction(  productAdi ,TransactionType.DELETING,productSayi, LocalDateTime.now());
                        Transaction.transactions.add(tran);
                        ikinci = false;
                        return;


                    }
                    else if (productSayi == deyisen.getNumberOfProduct()){
                        deyisen.numberOfProduct -= productSayi;


                        System.out.println("qalan product sayi " + deyisen.numberOfProduct + "\n Listin toStringi" + deyisen.toString());
                        Products transferMal = new Products(3, deyisen.getNameProduct(),
                                deyisen.priceOfProduct, productSayi, deyisen.producerFirm,
                                deyisen.type, deyisen.productionYear, deyisen.madeIn);

                        objTransferAcc.list.add(transferMal);
                        System.out.println(objTransferAcc.list.toString());

                        Inteface.LoginList.remove(removing-=1);


                        ikinci = false;
                        return;
                    }
                    else if (productSayi > deyisen.getNumberOfProduct()) {
                        System.out.println("Anbarda  bu  mehsuldan  daxil  etdiyiniz miqdarda  yoxdur");
                        return;
                    }
                    else if (productSayi<0){

                            throw new ThisPartCantBeNegative("Trasnfer olunacaq malin sayi menfi ola bilmez") ;

                    }

                } while (ikinci);
            }
            else {
                System.out.println("Daxil  etdiyiniz adda anbarda mehsul movcud deyil \n Mehsul adini yeniden daxil etmek isteyirsinizse 1 daxil edin\n" +
                        " Eks halda 0  daxil edin");
                int yenidenAd= scan.nextInt();
                if(yenidenAd!=1){
                    return;
                }

            }

        } while (AdiId);

    }












//  ------------------------------------ M A L    S I L I N M E S I -----------------------------

        public void malSilinmesi() {
        Products  test3 = null;
            System.out.println("Silmek istediyiniz malin adini daxil edin");
            String silinenMalAdi = scan.next();
            for (Products mallar : Inteface.LoginList) {
                if (mallar.getNameProduct().equals(silinenMalAdi)) {
                    test3 = mallar;
                }
            }
            int removing=0;
            if (test3!=null) {
                 removing = test3.getLine();
            }
            if (test3!=null) {
                System.out.println("Silmek  istediyiniz  mal sayini daxil edin");
                int silinecekMalSayi = scan.nextInt();
                if (silinecekMalSayi < test3.getNumberOfProduct()) {
                    test3.numberOfProduct -= silinecekMalSayi;
                    System.out.println(test3.toString());
                    Transaction  tran = new Transaction(  silinenMalAdi ,TransactionType.DELETING,silinecekMalSayi, LocalDateTime.now());
                    Transaction.transactions.add(tran);
                }
                else if (silinecekMalSayi==test3.numberOfProduct){
                    Inteface.LoginList.remove(removing-=1);
                    System.out.println(Inteface.LoginList.toString());
                }
                else if (silinecekMalSayi>test3.getNumberOfProduct()){
                    System.out.println(" Daxil etdiyiniz sayda anbarda mehsul  yoxdur \n Emeliyyat icra olunmadi ");
                }
                else if (silinecekMalSayi<0){
                        throw new ThisPartCantBeNegative("Silinecek malin sayi menfi ola bilmez") ;

                }

            }

                else  {
                    System.out.println("Daxil etdiyiniz adda mehsul anbarda movcud deyil");
                  return;
                }
                if(test3.getNumberOfProduct()==0){
                    Inteface.LoginList.remove(removing-=1);
                }
            }


    public static void showHistory(){
        for (Transaction test : Transaction.transactions){
            System.out.println(test);
        }
    }



            }




