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
public class thongkeDiemChuyenDe {
    String chuyende;
    int SoHv;
    double min,max,avg;

    public thongkeDiemChuyenDe() {
    }

    public String getChuyende() {
        return chuyende;
    }

    public void setChuyende(String chuyende) {
        this.chuyende = chuyende;
    }

    public int getSoHv() {
        return SoHv;
    }

    public void setSoHv(int SoHv) {
        this.SoHv = SoHv;
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
