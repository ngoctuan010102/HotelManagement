/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import data.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ngoc Tuan
 */
public class HoaDonDAO {
    Connection conn= null;
    PreparedStatement stmt=null;
    public int Add(HoaDon hd){
        try{
            String sSQL="INSERT INTO HoaDon VALUES (?,?,?,?,?,?)";
            conn=DatabaseHelper.getDBConnect();
            stmt = conn.prepareStatement(sSQL);
            stmt.setString(1,hd.getMaHD());
            stmt.setString(2,hd.getMaNV());
            stmt.setString(3,hd.getMaKH());
            stmt.setString(4,String.valueOf(hd.getSoPhong()));
            stmt.setString(5,hd.getGioDat());
            stmt.setString(6,hd.getGioTra());
            if(stmt.executeUpdate()>0){
                System.out.println("Insert thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Eror"+e.toString());
        }
        return -1;
    }
    public int Update(HoaDon hd){
        try{
            String sSQL="UPDATE HoaDon set MaNV=?,MaKH=?,SoPhong=?,GioDat=?,GioTra=? WHERE MaHD=?";
            conn=DatabaseHelper.getDBConnect();
            stmt = conn.prepareStatement(sSQL);
            stmt.setString(6,hd.getMaHD());
            stmt.setString(1,hd.getMaNV());
            stmt.setString(2,hd.getMaKH());
            stmt.setString(3,String.valueOf(hd.getSoPhong()));
            stmt.setString(4,hd.getGioDat());
            stmt.setString(5,hd.getGioTra());
            if(stmt.executeUpdate()>0){
                System.out.println("Update thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Eror"+e.toString());
        }
        return -1;
    }
    public int Delete(HoaDon hd)
    {
        try{
            String sSQL="DELETE HoaDon WHERE MaHD=?";
            conn=DatabaseHelper.getDBConnect();
            stmt = conn.prepareStatement(sSQL);
            stmt.setString(1,String.valueOf(hd.getMaHD()));
            if(stmt.executeUpdate()>0){
                System.out.println("Delete thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Eror"+e.toString());
        }
        return -1;
    }
    public List<HoaDon> getAll(){
        List<HoaDon> ls= new ArrayList<>();
        ResultSet rs=null;
        ResultSet r=null;
        Statement stmt=null;
        
        try{
            String sSQL = "SELECT * FROM HoaDon";
            conn = DatabaseHelper.getDBConnect();
            stmt= conn.createStatement();
            rs= stmt.executeQuery(sSQL);
            while(rs.next())
            {
                HoaDon hd= new HoaDon();
                hd.setMaHD(rs.getString(1));
                hd.setMaNV(rs.getString(2));
                hd.setMaKH(rs.getString(3));
                hd.setSoPhong(Integer.parseInt(rs.getString(4)));
                hd.setGioDat(rs.getString(5));
                hd.setGioTra(rs.getString(6));
                ls.add(hd);
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
    public List<HoaDon> getMaHD(){
        List<HoaDon> ls= new ArrayList<>();
        ResultSet rs=null;
        Statement stmt=null;
        
        try{
            String sSQL = "SELECT TOP 1 MaHD asLastMaHD FROM HoaDon ORDERBY MaHD DESC";
            conn = DatabaseHelper.getDBConnect();
            stmt= conn.createStatement();
            rs= stmt.executeQuery(sSQL);
            while(rs.next())
            {
                
                HoaDon hd= new HoaDon();
                hd.setMaHD(rs.getString(1));
                hd.setMaNV(rs.getString(2));
                hd.setMaKH(rs.getString(3));
                hd.setSoPhong(Integer.parseInt(rs.getString(4)));
                hd.setGioDat(rs.getString(5));
                hd.setGioTra(rs.getString(6));
                ls.add(hd);
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
    public List<HoaDon> findByID(String mahd){
        List<HoaDon> ls= new ArrayList<>();
        ResultSet rs=null;
        Statement stmt=null;
        
        try{
            String sSQL = "SELECT * FROM HoaDon WHERE MaHD='"+mahd+"'";
            conn = DatabaseHelper.getDBConnect();
            stmt= conn.createStatement();
            rs= stmt.executeQuery(sSQL);
            while(rs.next())
            {
                HoaDon hd= new HoaDon();
                hd.setMaHD(rs.getString(1));
                hd.setMaNV(rs.getString(2));
                hd.setMaKH(rs.getString(3));
                hd.setSoPhong(Integer.parseInt(rs.getString(4)));
                hd.setGioDat(rs.getString(5));
                hd.setGioTra(rs.getString(6));
                ls.add(hd);
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
