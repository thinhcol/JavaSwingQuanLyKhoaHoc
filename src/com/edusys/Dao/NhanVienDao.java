/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.Dao;

import com.edusys.helper.JdbcHelper;
import com.edusys.Model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienDao extends EduSys_DAO<NhanVien, String> {
    
    @Override
    public void insert(NhanVien model) {
        String sql = "INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro,email,Hinh,Gioitinh) VALUES (?,?,?, ?, ?, ?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaNV(),
                model.getMatKhau(),
                model.getHoTen(),
                model.getVaiTro(),
                model.getEmail(),
                model.getHinh(),
                model.getGioitinh());
    }
    
    @Override
    public void update(NhanVien model) {
        String sql = "UPDATE NhanVien SET MatKhau=?, HoTen=?, VaiTro=?, email=? ,Hinh = ?,gioitinh = ? WHERE MaNV=?";
        JdbcHelper.executeUpdate(sql,
                model.getMatKhau(),
                model.getHoTen(),
                model.getVaiTro(),
                model.getEmail(),
                model.getHinh(),
                model.getGioitinh(),
                model.getMaNV());
        
    }

    public void updateHinh(NhanVien model) {
        String sql = "UPDATE NhanVien SET Hinh = ? WHERE MaNV=?";
        JdbcHelper.executeUpdate(sql,
                model.getHinh(),
                model.getMaNV());
    }
    
    @Override
    public void delete(String MaNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNV=?";
        JdbcHelper.executeUpdate(sql, MaNV);
    }
    
    @Override
    public List<NhanVien> select() {
        String sql = "SELECT * FROM NhanVien";
        return SelectBySQL(sql);
    }
    
    @Override
    public NhanVien findById(String manv) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        List<NhanVien> list = SelectBySQL(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setHoTen(rs.getString("HoTen"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        model.setEmail(rs.getString("email"));
        model.setHinh(rs.getString("Hinh"));
        model.setGioitinh(rs.getBoolean("GioiTinh"));
        return model;
    }
    
    @Override
    protected List<NhanVien> SelectBySQL(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
}
