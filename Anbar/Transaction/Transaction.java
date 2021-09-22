package Transaction;

import Products.Products;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private TransactionType type ;
    private int numberOfProduct ;
    private String  nameProduct;
    private LocalDateTime date;

    public static  List<Transaction> transactions = new ArrayList<>();



     public Transaction (
             String nameProduct
             ,TransactionType type
             , int numberOfProduct
             , LocalDateTime date )
     {


         this.nameProduct=nameProduct;
         this.type= type;
         this.numberOfProduct= numberOfProduct;
         this.date=date;


     }




     public String toString (){
         return  "\n Name of product  " + nameProduct + "  Transactions type : " + type
                 +"  Number of products : "+ numberOfProduct + "  Date : " + date  ;

     }
}
