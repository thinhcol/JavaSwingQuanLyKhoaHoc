/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.Dao;

import com.edusys.helper.JdbcHelper;
import com.edusys.Model.thongkeDiemChuyenDe;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class ThongKeTHD {

    public ArrayList<thongkeDiemChuyenDe> getAllList() {
        ArrayList<thongkeDiemChuyenDe> nc = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "{call sp_ThongKeDiem}";
            rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                thongkeDiemChuyenDe tk = new thongkeDiemChuyenDe();
                tk.setChuyende(rs.getString("ChuyenDe"));
                tk.setSoHv(rs.getInt("SoHV"));
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
