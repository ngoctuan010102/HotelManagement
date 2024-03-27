/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Ngoc Tuan
 */
public class NhanVien {
     private String maNV;
    private String tenNv;
    private boolean gioiTinh;
    private String diaChi;
    private String sDT;
    private String chucVu;
    private double luong;
    private String taiKhoan;
    public NhanVien(){
        
    }
     public NhanVien(String maNV){
         this.maNV=maNV;
        
    }

    public NhanVien(String maNV, String tenNv, boolean gioiTinh, String diaChi, String sDT, String chucVu, double luong, String taiKhoan) {
        this.maNV = maNV;
        this.tenNv = tenNv;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sDT = sDT;
        this.chucVu = chucVu;
        this.luong = luong;
        this.taiKhoan = taiKhoan;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", tenNv=" + tenNv + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", sDT=" + sDT + ", chucVu=" + chucVu + ", luong=" + luong + ", taiKhoan=" + taiKhoan + '}';
    }
     

}
