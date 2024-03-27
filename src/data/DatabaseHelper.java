/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author Ngoc Tuan
 */
public class DatabaseHelper {
    public static final String connectionUrl = "jdbc:sqlserver://localhost;DatabaseName=QLKS;user=sa;password=12345678;encrypt=true;trustServerCertificate=true;";
    public static Connection getDBConnect(){
        Connection conn=null;
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
        }catch(Exception e)
        {
            System.out.println("Chưa có Driver !"+ e.toString());
        }
        try{
            conn=DriverManager.getConnection(connectionUrl);
            return conn;
        }
        catch(Exception e)
        {
            System.out.println("Lỗi connect"+e.toString());
        }
        return null;
    }
}
