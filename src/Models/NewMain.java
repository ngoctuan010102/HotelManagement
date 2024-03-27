/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ngoc Tuan
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HoaDon hd= new HoaDon();
        Date date = new Date("2023/5/6 15:00:00");  
        Date date1= new Date("2023/5/7 14:00:00");
        //tinh gio 
        long a=(date1.getTime()-date.getTime())/1000;
        //3600s = 1h
        System.out.println(a/3600);
        //tinh ngay
       /* long b=date1.getDate()-date.getDate();
        System.out.println("b "+b);
        long c=0;
                if(b>0)
                {
                    c=b*24+a;
                }
                else if(b==0)
                    c=a;
        System.out.println("Tong "+ c);
*/
            
        //if()
      //  SimpleDateFormat  formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
      //   String strDate = formatter.format(date);  
        //System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+strDate);  
    }
    
}
