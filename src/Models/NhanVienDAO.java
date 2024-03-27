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
public class NhanVienDAO {
     Connection conn= null;
    PreparedStatement stmt=null;
    public int Add(NhanVien nv){
        try{
            String sSQL="INSERT INTO NhanVien VALUES (?,?,?,?,?,?,?,?)";
            conn=DatabaseHelper.getDBConnect();
            stmt = conn.prepareStatement(sSQL);
            stmt.setString(1,nv.getMaNV());
            stmt.setString(2,nv.getTenNv());
            stmt.setString(3,String.valueOf(nv.isGioiTinh()));
            stmt.setString(4,nv.getDiaChi());
            stmt.setString(5,nv.getsDT());
            stmt.setString(6,nv.getChucVu());
            stmt.setString(7,String.valueOf(nv.getLuong()));
            stmt.setString(8,nv.getTaiKhoan());
            if(stmt.executeUpdate()>0){
                System.out.println("Insert thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Eror"+e.toString());
        }
        return -1;
    }
    public int Update(NhanVien nv){
        try{
            String sSQL="UPDATE NhanVien set TenNV=?,GioiTinh=?,DiaChi=?,SoDT=?,ChucVu=?,Luong=?,TenDN=? WHERE MaNV=?";
            conn=DatabaseHelper.getDBConnect();
            stmt = conn.prepareStatement(sSQL);
            stmt.setString(8,nv.getMaNV());
            stmt.setString(1,nv.getTenNv());
            stmt.setString(2,String.valueOf(nv.isGioiTinh()));
            stmt.setString(3,nv.getDiaChi());
            stmt.setString(4,nv.getsDT());
            stmt.setString(5,nv.getChucVu());
            stmt.setString(6,String.valueOf(nv.getLuong()));
            stmt.setString(7,nv.getTaiKhoan());
            if(stmt.executeUpdate()>0){
                System.out.println("Update thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Eror"+e.toString());
        }
        return -1;
        }
    public int Delete(NhanVien nv){
        try{
            String sSQL="DELETE NhanVien WHERE MaNV=?";
            conn=DatabaseHelper.getDBConnect();
            stmt = conn.prepareStatement(sSQL);
            stmt.setString(1,nv.getMaNV());
            if(stmt.executeUpdate()>0){
                System.out.println("Delete thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Eror"+e.toString());
        }
        return -1;
        }
    public List<NhanVien> getAll(){
        List<NhanVien> ls=new ArrayList<>();
        ResultSet rs=null;
        Statement stmt=null;
        try{
            String sSQL = "SELECT * FROM NhanVien";
            conn = DatabaseHelper.getDBConnect();
            stmt= conn.createStatement();
            rs= stmt.executeQuery(sSQL);
            while(rs.next())
            {
                NhanVien nv= new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setTenNv(rs.getString(2));
                nv.setGioiTinh(rs.getBoolean(3));
                nv.setDiaChi(rs.getString(4));
                nv.setsDT(rs.getString(5));
                nv.setChucVu(rs.getString(6));
                nv.setLuong(Double.parseDouble(rs.getString(7)));
                nv.setTaiKhoan(rs.getString(8));
                ls.add(nv);
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
    public List<NhanVien> findByID(String MaNV){
        List<NhanVien> ls= new ArrayList<>();
        ResultSet rs=null;
        Statement stmt=null;
        
        try{
            String sSQL = "SELECT * FROM NhanVien WHERE MaNV='"+MaNV+"'";
            conn = DatabaseHelper.getDBConnect();
            stmt= conn.createStatement();
            rs= stmt.executeQuery(sSQL);
            while(rs.next())
            {
                NhanVien nv= new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setTenNv(rs.getString(2));
                nv.setGioiTinh(rs.getBoolean(3));
                nv.setDiaChi(rs.getString(4));
                nv.setsDT(rs.getString(5));
                nv.setChucVu(rs.getString(6));
                nv.setLuong(Double.parseDouble(rs.getString(7)));
                nv.setTaiKhoan(rs.getString(8));
                ls.add(nv);
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
