package Accounts;

import Products.Products;
import java.util.List;
import java.util.Scanner;

public class Account {
        Scanner scan = new Scanner(System.in);

        private final String accountId  ;
        private  String username ;
        private String password  ;
        private double  balance ;
        public  List<Products> list ;



        public Account (String accountId ,
                        String username,
                        String password ,
                        double balance ,
                        List<Products> list){
                this.accountId= accountId;
                this.username =username;
                this.password = password;
                this.balance = balance;
                this.list=list;


        }





        public String getAccountId(){ return  accountId; }
        public String getUsername(){ return username ;}
        public void setUsername (String username ){ this.username=username ;}
        public String getPassword (){ return  password ;}
        public void setPassword (String password){ this.password = password;}
        public double getBalance (){ return  balance ;}
        public List<Products> getList() { return  list ;}


        public String toString(){
                return  " Username " + username+"  Password - " + password +" AccountId - "+ accountId+ "  Balance " + balance;
        }

}





