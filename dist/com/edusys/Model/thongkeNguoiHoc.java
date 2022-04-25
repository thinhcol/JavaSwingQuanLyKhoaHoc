/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class thongkeNguoiHoc {
    private int nam,soluong;
    private Date min,max;

    public thongkeNguoiHoc() {
    }
    
    public thongkeNguoiHoc(int nam, int soluong, Date min, Date max) {
        this.nam = nam;
        this.soluong = soluong;
        this.min = min;
        this.max = max;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Date getMin() {
        return min;
    }

    public void setMin(Date min) {
        this.min = min;
    }

    public Date getMax() {
        return max;
    }

    public void setMax(Date max) {
        this.max = max;
    }
    
}
