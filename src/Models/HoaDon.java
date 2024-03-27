/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ngoc Tuan
 */
public class HoaDon {
    private String MaHD;
    private String MaNV;
    private String MaKH;
    private int SoPhong;
    private String GioDat;
    private String GioTra;
    public HoaDon() {
    }

    public HoaDon(String MaHD, String MaNV, String MaKH, int SoPhong, String GioDat, String GioTra) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.SoPhong = SoPhong;
        this.GioDat = GioDat;
        this.GioTra = GioTra;
    }
    public long getSoGio() {
       long a=0;
       try{
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(GioDat);
        Date date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(GioTra);
        a= (date1.getTime()-date.getTime())/1000;
       }catch(Exception e)
       {
       }
        return a/3600;
    }
    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public int getSoPhong() {
        return SoPhong;
    }

    public void setSoPhong(int SoPhong) {
        this.SoPhong = SoPhong;
    }

    public String getGioDat() {
        return GioDat;
    }

    public void setGioDat(String GioDat) {
        this.GioDat = GioDat;
    }

    public String getGioTra() {
        return GioTra;
    }

    public void setGioTra(String GioTra) {
        this.GioTra = GioTra;
    }
    
}
