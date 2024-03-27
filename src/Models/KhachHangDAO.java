/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.sql.Connection;
import data.DatabaseHelper;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ngoc Tuan
 */
public class KhachHangDAO {
    Connection conn= null;
    PreparedStatement stmt=null;
    public int Add(KhachHang kh){
        try{
            String sSQL="INSERT INTO KhachHang VALUES (?,?,?,?,?)";
            conn=DatabaseHelper.getDBConnect();
            stmt = conn.prepareStatement(sSQL);
            stmt.setString(1,kh.getMaKH());
            stmt.setString(2,kh.getTenKH());
            stmt.setString(3,kh.getcCCD());
            stmt.setBoolean(4,kh.isGioiTinh());
            stmt.setString(5,kh.getsDT());
            if(stmt.executeUpdate()>0){
                System.out.println("Insert thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Eror"+e.toString());
        }
        return -1;
    }
    public int Update(KhachHang kh){
        try{
            String sSQL="UPDATE KhachHang set TenKH=?,CCCD=?,GioiTinh=? ,SoDT=? WHERE MaKH=?";
            conn=DatabaseHelper.getDBConnect();
            stmt = conn.prepareStatement(sSQL);
            stmt.setString(5,kh.getMaKH());
            stmt.setString(1,kh.getTenKH());
            stmt.setString(2,kh.getcCCD());
            stmt.setBoolean(3,kh.isGioiTinh());
            stmt.setString(4,kh.getsDT());
            if(stmt.executeUpdate()>0){
                System.out.println("Update thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Eror"+e.toString());
        }
        return -1;
    }
    public int Delete(KhachHang kh)
    {
        try{
            String sSQL="DELETE KhachHang WHERE MaKH=?";
            conn=DatabaseHelper.getDBConnect();
            stmt = conn.prepareStatement(sSQL);
            stmt.setString(1,kh.getMaKH());
            if(stmt.executeUpdate()>0){
                System.out.println("Delete thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Eror"+e.toString());
        }
        return -1;
    }
    public List<KhachHang> getAll(){
        List<KhachHang> ls= new ArrayList<>();
        ResultSet rs=null;
        Statement stmt=null;
        
        try{
            String sSQL = "SELECT * FROM KhachHang";
            conn = DatabaseHelper.getDBConnect();
            stmt= conn.createStatement();
            rs= stmt.executeQuery(sSQL);
            while(rs.next())
            {
                KhachHang kh= new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setcCCD(rs.getString(3));
                kh.setGioiTinh(rs.getBoolean(4));
                kh.setsDT(rs.getString(5));
                ls.add(kh);
            }
        }
        catch(Exception e){
            System.out.println("Loi"+e.toString());
        }
        finally{
            try{
                rs.close(); stmt.close(); conn.close();
            }
            catch(Exception e){
                
            }
        }
    return ls;
    }
    public List<KhachHang> findByID(String maKH){
        List<KhachHang> ls= new ArrayList<>();
        ResultSet rs=null;
        Statement stmt=null;
        
        try{
            String sSQL = "SELECT * FROM KhachHang WHERE MaKH='"+maKH+"'";
            conn = DatabaseHelper.getDBConnect();
            stmt= conn.createStatement();
            rs= stmt.executeQuery(sSQL);
            while(rs.next())
            {
                KhachHang kh= new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setcCCD(rs.getString(3));
                kh.setGioiTinh(rs.getBoolean(4));
                kh.setsDT(rs.getString(5));
                ls.add(kh);
            }
        }
        catch(Exception e){
            System.out.println("Loi"+e.toString());
        }
        finally{
            try{
                rs.close(); stmt.close(); conn.close();
            }
            catch(Exception e){
                
            }
        }
    return ls;
    }

}
