package QLSV;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class QLSVModel {

    //danh sách lựa chọn tìm kiếm
    public static enum find {
        ma,
        ten,
        khoa,
        lop
    }

    public LinkedList<SinhVien> getDssv() {
        return getAllStudents();
    }

    public QLSVModel() {
    }

    //lấy dữ liệu sinh viên từ database
    private LinkedList<SinhVien> getAllStudents() {
        LinkedList<SinhVien> svs = new LinkedList<>();
        try {
            String sql = "select * from sinhvien";
            ResultSet rs = DataBaseUtil.getData(sql);

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String gioiTinh = rs.getString(3);
                Date d = rs.getDate(4);
                String khoa = rs.getString(5);
                String lop = rs.getString(6);
                String email = rs.getString(7);
                String sdt = rs.getString(8);
                String diaChi = rs.getString(9);
                svs.add(new SinhVien(id, name, gioiTinh, d, khoa, lop, email, sdt, diaChi));
            }
        } catch (SQLException e) {
        }

        return svs;
    }

    //thêm sinh viên
    public int add(SinhVien sinhVien) throws SQLException {
        String id = sinhVien.getMaSV();
        String name = sinhVien.getHoTen();
        String gioiTinh = sinhVien.getGioiTinh();
        Date d = sinhVien.getNgaySinh();
        String khoa = sinhVien.getKhoa();
        String lop = sinhVien.getLop();
        String email = sinhVien.getEmail();
        String sdt = sinhVien.getSDT();
        String diaChi = sinhVien.getDiaChi();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "insert into sinhvien values('" + id + "',N'" + name + "','" + gioiTinh + "','" + ft.format(d) + "','" + khoa + "','" + lop + "','" + email + "','" + sdt + "',N'" + diaChi + "')";
        return DataBaseUtil.setData(sql);
    }

    //check trùng mã
    public boolean checkTrungMa(String maSV) throws SQLException {
        String sql = "select * from sinhvien where masv = " + maSV;
        ResultSet rs = DataBaseUtil.getData(sql);
        return rs.next();
    }

    //check email
    public boolean checkEmail(String email) throws SQLException {
        String sql = "select * from sinhvien where email = '" + email + "';";
        ResultSet rs = DataBaseUtil.getData(sql);
        return rs.next();
    }

    //check sdt
    public boolean checkSDT(String sDT) throws SQLException {
        String sql = "select * from sinhvien where sdt = '" + sDT + "';";
        ResultSet rs = DataBaseUtil.getData(sql);
        return rs.next();
    }

    //Tìm theo  mã sinh viên
    public LinkedList<SinhVien> find(String name, find f) throws SQLException {
        LinkedList<SinhVien> dssvTemp = new LinkedList<>();

        String sql = "";
        switch (f) {
            case ma:
                sql = "select * from sinhvien where masv = '" + name + "'";
                break;
            case ten:
                sql = "select * from sinhvien where hoten like '%" + name + "%'";
                break;
            case khoa:
                sql = "select * from sinhvien where khoa = '" + name + "'";
                break;
            case lop:
                sql = "select * from sinhvien where lop = '" + name + "'";
                break;
        }

        ResultSet rs = DataBaseUtil.getData(sql);
        while (rs.next()) {
            String id = rs.getString(1);
            String hoten = rs.getString(2);
            String gioiTinh = rs.getString(3);
            Date d = rs.getDate(4);
            String khoa = rs.getString(5);
            String lop = rs.getString(6);
            String email = rs.getString(7);
            String sdt = rs.getString(8);
            String diaChi = rs.getString(9);
            dssvTemp.add(new SinhVien(id, hoten, gioiTinh, d, khoa, lop, email, sdt, diaChi));
        }

        return dssvTemp;
    }

    //Xoá sinh viên theo mã
    public int remove(String maSV) throws SQLException {
        String sql = "delete from sinhvien where masv='" + maSV + "'";
        return DataBaseUtil.setData(sql);
    }

    //Cập nhật sinh viên 
    public int update(SinhVien sv) throws SQLException {
        String sql;
        if (checkTrungMa(sv.getMaSV())) {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            sql = String.format("update sinhvien set masv='%s',hoten='%s',gioitinh='%s',ngaysinh='%s',khoa='%s',lop='%s',email='%s',sdt='%s',diachi='%s' where masv='%s'", sv.getMaSV(), sv.getHoTen(), sv.getGioiTinh(), ft.format(sv.getNgaySinh()), sv.getKhoa(), sv.getLop(), sv.getEmail(), sv.getSDT(), sv.getDiaChi(), sv.getMaSV());
            return DataBaseUtil.setData(sql);
        }
        return -1;
    }
}
