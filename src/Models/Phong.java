/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Ngoc Tuan
 */
public class Phong {
    private int SoPhong;
    private String TinhTrang;
    private String LoaiPhong;
    private float GiaTien;

    public Phong() {
    }

    public Phong(int SoPhong) {
        this.SoPhong = SoPhong;
    }

    public Phong(int SoPhong, String TinhTrang, String LoaiPhong, float GiaTien) {
        this.SoPhong = SoPhong;
        this.TinhTrang = TinhTrang;
        this.LoaiPhong = LoaiPhong;
        this.GiaTien = GiaTien;
    }

    public int getSoPhong() {
        return SoPhong;
    }

    public void setSoPhong(int SoPhong) {
        this.SoPhong = SoPhong;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public void setLoaiPhong(String LoaiPhong) {
        this.LoaiPhong = LoaiPhong;
    }

    public float getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(float GiaTien) {
        this.GiaTien = GiaTien;
    }

    @Override
    public String toString() {
        return "Phong{" + "SoPhong=" + SoPhong + ", TinhTrang=" + TinhTrang + ", LoaiPhong=" + LoaiPhong + ", GiaTien=" + GiaTien + '}'+"\n";
    }
    
}
