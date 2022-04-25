/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.Dao;

import com.edusys.helper.JdbcHelper;
import com.edusys.Model.NguoiHoc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NguoiHocDao extends EduSys_DAO<NguoiHoc, String>{

    @Override
    public void insert(NguoiHoc model) {
        String sql
                = "INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV,NgayDk,Hinh) VALUES( ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?, ?)  ";
        JdbcHelper.executeUpdate(sql,
                model.getMaNH(),
                model.getHoTen(),
                model.getNgaySinh(),
                model.getGioiTinh(),
                model.getDienThoai(),
                model.getEmail(),
                model.getGhiChu(),
                model.getMaNV(),
                model.getNgayDK(),
                model.getHinh());
    }

   
 
    @Override
 public void update(NguoiHoc model) {
        String sql
                = "UPDATE NguoiHoc SET HoTen=?, NgaySinh=?, GioiTinh=?, DienThoai=?, Email=?, GhiChu=?, MaNV =  ?,Hinh = ? WHERE  MaNH =  ?";
        JdbcHelper.executeUpdate(sql,
                model.getHoTen(),
                model.getNgaySinh(),
                model.getGioiTinh(),
                model.getDienThoai(),
                model.getEmail(),
                model.getGhiChu(),
                model.getMaNV(),
                model.getHinh(),
                model.getMaNH());
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM NguoiHoc WHERE MaNH=?";
        JdbcHelper.executeUpdate(sql, id);
    }


    public List<NguoiHoc> selectByKeyword(String keyword,String keyword1,String keyword2,String keyword3,String keyword4) {
        String sql = "SELECT * FROM NguoiHoc WHERE HoTen LIKE  ? OR MANH LIKE ? OR DIENTHOAI LIKE ? OR NgaySinh LIKE ? OR MaNV = ?";
        return SelectBySQL(sql, "%"+keyword+"%","%"+keyword1+"%","%"+keyword2+"%","%"+keyword3+"%","%"+keyword4+"%");
    }

    public List<NguoiHoc> selectByCourse(Integer makh) {
        String sql = "SELECT * FROM NguoiHoc WHERE MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH=?)";
        return SelectBySQL(sql, makh);
    }


    private NguoiHoc readFromResultSet(ResultSet rs) throws SQLException {
        NguoiHoc model = new NguoiHoc();
        model.setMaNH(rs.getString("MaNH"));
        model.setHoTen(rs.getString("HoTen"));
        model.setNgaySinh(rs.getDate("NgaySinh"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setDienThoai(rs.getString("DienThoai"));
        model.setEmail(rs.getString("Email"));
        model.setGhiChu(rs.getString("GhiChu"));
        model.setMaNV(rs.getString("MaNV"));
        model.setNgayDK(rs.getDate("NgayDK"));
        model.setHinh(rs.getString("Hinh"));
        return model;
    }

    @Override
    public NguoiHoc findById(String manh) {
         String sql = "SELECT * FROM NguoiHoc WHERE MaNH=?";
        List<NguoiHoc> list = SelectBySQL(sql, manh);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NguoiHoc> select() {
           String sql = "SELECT * FROM NguoiHoc";
        return SelectBySQL(sql);
    }

    @Override
    protected List<NguoiHoc> SelectBySQL(String sql, Object... args) {
        List<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NguoiHoc model = readFromResultSet(rs);
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
