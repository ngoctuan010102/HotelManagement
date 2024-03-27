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
public class PhongDAO {
    Connection conn= null;
    PreparedStatement stmt=null;
    public int Add(Phong p){
        try{
            String sSQL="INSERT INTO Phong VALUES (?,?,?,?)";
            conn=DatabaseHelper.getDBConnect();
            stmt = conn.prepareStatement(sSQL);
            stmt.setString(1,String.valueOf( p.getSoPhong()));
            stmt.setString(2,p.getTinhTrang());
            stmt.setString(3,p.getLoaiPhong());
            stmt.setString(4,String.valueOf( p.getGiaTien()));
            if(stmt.executeUpdate()>0){
                System.out.println("Insert thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Eror"+e.toString());
        }
        return -1;
    }
    public int Update(Phong p){
        try{
            String sSQL="UPDATE Phong set Status=?,LoaiPhong=?,GiaTien=? WHERE SoPhong=?";
            conn=DatabaseHelper.getDBConnect();
            stmt = conn.prepareStatement(sSQL);
            stmt.setString(1,p.getTinhTrang());
            stmt.setString(2,p.getLoaiPhong());
            stmt.setString(3,String.valueOf( p.getGiaTien()));
            stmt.setString(4,String.valueOf(p.getSoPhong()));
            if(stmt.executeUpdate()>0){
                System.out.println("Update thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Eror"+e.toString());
        }
        return -1;
    }
    public int UpdateFromHD(Phong p){
        try{
            String sSQL="UPDATE Phong set Status=? WHERE SoPhong=?";
            conn=DatabaseHelper.getDBConnect();
            stmt = conn.prepareStatement(sSQL);
            stmt.setString(1,p.getTinhTrang());
            stmt.setString(2,String.valueOf(p.getSoPhong()));
            if(stmt.executeUpdate()>0){
                System.out.println("Update thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Eror"+e.toString());
        }
        return -1;
    }
    public int Delete(Phong p)
    {
        try{
            String sSQL="DELETE Phong WHERE SoPhong=?";
            conn=DatabaseHelper.getDBConnect();
            stmt = conn.prepareStatement(sSQL);
            stmt.setString(1,String.valueOf(p.getSoPhong()));
            if(stmt.executeUpdate()>0){
                System.out.println("Delete thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Eror"+e.toString());
        }
        return -1;
    }
    public List<Phong> getAll(){
        List<Phong> ls= new ArrayList<>();
        ResultSet rs=null;
        Statement stmt=null;
        
        try{
            String sSQL = "SELECT * FROM Phong";
            conn = DatabaseHelper.getDBConnect();
            stmt= conn.createStatement();
            rs= stmt.executeQuery(sSQL);
            while(rs.next())
            {
                Phong p= new Phong();
                p.setSoPhong(Integer.parseInt(rs.getString(1)));
                p.setTinhTrang(rs.getString(2));
                p.setLoaiPhong(rs.getString(3));
                p.setGiaTien(Float.parseFloat(rs.getString(4)));
                ls.add(p);
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
    
    public List<Phong> getActive(){
        List<Phong> ls= new ArrayList<>();
        ResultSet rs=null;
        Statement stmt=null;
        
        try{
            String sSQL = "SELECT * FROM Phong WHERE Status LIKE 'Active'";
            conn = DatabaseHelper.getDBConnect();
            stmt= conn.createStatement();
            rs= stmt.executeQuery(sSQL);
            while(rs.next())
            {
                Phong p= new Phong();
                p.setSoPhong(Integer.parseInt(rs.getString(1)));
                p.setTinhTrang(rs.getString(2));
                p.setLoaiPhong(rs.getString(3));
                p.setGiaTien(Float.parseFloat(rs.getString(4)));
                ls.add(p);
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
    public List<Phong> findByID(int sophong){
        List<Phong> ls= new ArrayList<>();
        ResultSet rs=null;
        Statement stmt=null;
        
        try{
            String sSQL = "SELECT * FROM Phong WHERE SoPhong="+sophong+"";
            conn = DatabaseHelper.getDBConnect();
            stmt= conn.createStatement();
            rs= stmt.executeQuery(sSQL);
            while(rs.next())
            {
                Phong p= new Phong();
                p.setSoPhong(Integer.parseInt(rs.getString(1)));
                p.setTinhTrang(rs.getString(2));
                p.setLoaiPhong(rs.getString(3));
                p.setGiaTien(Float.parseFloat(rs.getString(4)));
                ls.add(p);
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

