/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.Model;

/**
 *
 * @author Admin
 */
public class thongkeDoanhThu {
    String ChuyenDe;
    int sokh,sohv;
    double doanhthu,min,max,avg;

    public thongkeDoanhThu() {
    }

    public String getChuyenDe() {
        return ChuyenDe;
    }

    public void setChuyenDe(String chuyenDe) {
        this.ChuyenDe = chuyenDe;
    }

    public int getSokh() {
        return sokh;
    }

    public void setSokh(int sokh) {
        this.sokh = sokh;
    }

    public int getSohv() {
        return sohv;
    }

    public void setSohv(int sohv) {
        this.sohv = sohv;
    }

    public double getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(double doanhthu) {
        this.doanhthu = doanhthu;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
    
}
