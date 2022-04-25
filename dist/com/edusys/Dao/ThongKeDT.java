/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.Dao;

import com.edusys.helper.JdbcHelper;
import com.edusys.Model.thongkeDoanhThu;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ThongKeDT {

    public ArrayList<thongkeDoanhThu> getAllList(int nam) {
        ArrayList<thongkeDoanhThu> nc = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "{call sp_ThongKeDoanhThu (?)}";
            rs = JdbcHelper.executeQuery(sql,nam);
            while (rs.next()) {
                thongkeDoanhThu tk = new thongkeDoanhThu();
                tk.setChuyenDe(rs.getString("ChuyenDe"));
                tk.setSokh(rs.getInt("SoKH"));
                tk.setSohv(rs.getInt("SoHV"));
                tk.setDoanhthu(rs.getDouble("DoanhThu"));
                tk.setMin(rs.getDouble("ThapNhat"));
                tk.setMax(rs.getDouble("CaoNhat"));
                tk.setAvg(rs.getDouble("TrungBinh"));
                nc.add(tk);
            }
            return nc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
