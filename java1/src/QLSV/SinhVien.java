package QLSV;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class SinhVien {
    //fields
    private String maSV;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String khoa;
    private String lop;
    private String email;
    private String sDT;
    private String diaChi;
    //properties

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    //constructors
    public SinhVien() {
        
    }

    public SinhVien(String maSV, String hoTen, String gioiTinh, Date ngaySinh, String khoa, String lop, String email, String sDT, String diaChi) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.khoa = khoa;
        this.lop = lop;
        this.email = email;
        this.sDT = sDT;
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "maSV=" + maSV + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", khoa=" + khoa + ", lop=" + lop + ", email=" + email + ", sDT=" + sDT + ", diaChi=" + diaChi + '}';
    }
    
    
}
