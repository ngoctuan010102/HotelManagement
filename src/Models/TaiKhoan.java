/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Ngoc Tuan
 */
public class TaiKhoan {
     private String tenTK;
    private String matKhau;
    private String quyenKS;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenTK, String matKhau, String quyenKS) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.quyenKS = quyenKS;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getQuyenKS() {
        return quyenKS;
    }

    public void setQuyenKS(String quyenKS) {
        this.quyenKS = quyenKS;
    }

}
