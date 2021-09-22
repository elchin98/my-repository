package Bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Yoxlama  {
    LocalDateTime vaxt;
    DateTimeFormatter esas;

   public  static String zaman() {

        LocalDateTime vaxt = LocalDateTime.now();
        DateTimeFormatter esas = DateTimeFormatter.ofPattern("dd-MM-YY   hh:mm") ;
        //String vaxt1 =esas;
        return  esas.format(vaxt);
    }




    public static void main(String[] args) {
            LocalDateTime vaxt = LocalDateTime.now();
            DateTimeFormatter esas = DateTimeFormatter.ofPattern("dd-MM-YY   hh:mm") ;
            Yoxlama cons = new Yoxlama();
            System.out.println(zaman ());
            //System.out.println(esas.format(vaxt));
        }
    }

