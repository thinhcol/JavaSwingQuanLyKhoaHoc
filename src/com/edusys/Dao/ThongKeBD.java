/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.Dao;

import com.edusys.helper.JdbcHelper;
import com.edusys.Model.thongkeBangDiem;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class ThongKeBD {

    public ArrayList<thongkeBangDiem> getAllList(int makh) {
        ArrayList<thongkeBangDiem> nc = new ArrayList<>();
        int nam, sl;
        Date min, max;
        ResultSet rs = null;
        try {
            String sql = "{call sp_BangDiem (?)}";
            rs = JdbcHelper.executeQuery(sql, makh);
            while (rs.next()) {
                String manh, hoten;
                double diem = rs.getDouble("Diem");
                String xepLoai = "Xuất sắc";
                if (diem < 0) {
                    xepLoai = "Chưa nhập";
                } else if (diem < 3) {
                    xepLoai = "Kém";
                } else if (diem < 5) {
                    xepLoai = "Yếu";
                } else if (diem < 6.5) {
                    xepLoai = "Trung bình";
                } else if (diem < 7.5) {
                    xepLoai = "Khá";
                } else if (diem < 9) {
                    xepLoai = "Giỏi";
                }
                thongkeBangDiem tk = new thongkeBangDiem();
                tk.setManh(rs.getString("MaNH"));
                tk.setHoten(rs.getString("HoTen"));
                tk.setDiem(diem);
                tk.setXeploai(xepLoai);
                nc.add(tk);
            }
            return nc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
