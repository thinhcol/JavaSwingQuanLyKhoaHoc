/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.Dao;

import com.edusys.helper.JdbcHelper;
import com.edusys.Model.thongkeNguoiHoc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class ThongKeNH {
    public ArrayList<thongkeNguoiHoc> getAllList() {
        ArrayList<thongkeNguoiHoc> nc = new ArrayList<>();
        int nam, sl;
        Date min, max;
        ResultSet rs = null;
        try {
            String sql = "{call sp_ThongKeNguoiHoc}";
            rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                thongkeNguoiHoc tk = new thongkeNguoiHoc();
                tk.setNam(rs.getInt("Nam"));
                tk.setSoluong(rs.getInt("SoLuong"));
                tk.setMin(rs.getDate("DauTien"));
                tk.setMax(rs.getDate("CuoiCung"));
                nc.add(tk);
            }
            return nc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
