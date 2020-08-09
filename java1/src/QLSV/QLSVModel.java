package QLSV;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class QLSVModel {

    public LinkedList<SinhVien> getDssv() {
        return getAllStudents();
    }

    public QLSVModel() {
    }

    public LinkedList<SinhVien> getAllStudents() {
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
        String sdt = sinhVien.getsDT();
        String diaChi = sinhVien.getDiaChi();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "insert into sinhvien values('" + id + "','" + name + "','" + gioiTinh + "','" + ft.format(d) + "','" + khoa + "','" + lop + "','" + email + "','" + sdt + "','" + diaChi + "')";
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
        String sql = "select * from sinhvien where email = '" + email+"';";
        ResultSet rs = DataBaseUtil.getData(sql);
        return rs.next();
    }
    //check sdt
     public boolean checkSDT(String sDT) throws SQLException {
        String sql = "select * from sinhvien where sdt = '" + sDT+"';";
        ResultSet rs = DataBaseUtil.getData(sql);
        return rs.next();
    }
    //Tìm theo  mã sinh viên
    public LinkedList<SinhVien> find(String maSV) throws SQLException {
        LinkedList<SinhVien> dssvTemp = new LinkedList<>();

        String sql = "select * from sinhvien where maSV = " + maSV;
        ResultSet rs = DataBaseUtil.getData(sql);
        rs.next();
        String id = rs.getString(1);
        String name = rs.getString(2);
        String gioiTinh = rs.getString(3);
        Date d = rs.getDate(4);
        String khoa = rs.getString(5);
        String lop = rs.getString(6);
        String email = rs.getString(7);
        String sdt = rs.getString(8);
        String diaChi = rs.getString(9);
        dssvTemp.add(new SinhVien(id, name, gioiTinh, d, khoa, lop, email, sdt, diaChi));

        return dssvTemp;
    }
    
    public void remove(String maSV) throws SQLException{
        String sql = "delete from sinhvien where id=" + maSV;
        DataBaseUtil.setData(sql);
    }
}
