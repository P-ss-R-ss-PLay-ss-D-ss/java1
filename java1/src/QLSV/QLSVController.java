package QLSV;

import java.awt.Color;
import java.sql.SQLException;
import javax.swing.border.Border;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QLSVController {

    //fields
    private QLSVModel model;
    private QLSVView view;

    Border nhapSai = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
    Border nhapDung = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);

    //properties
    public QLSVModel getModel() {
        return model;
    }

    public QLSVView getView() {
        return view;
    }

    //constructors
    public QLSVController() {
        model = new QLSVModel();
        view = new QLSVView();
    }

    public QLSVController(QLSVModel model, QLSVView view) {
        this.model = model;
        this.view = view;
        this.view.setVisible(true);

        init();

        this.view.setVisible(true);
    }

    //bắt sự kiện nút chức năng
    public void init() {
        ShowTable(model.getDssv());
        ///Nút thêm
        view.getBtn_them().addActionListener((x) -> {
            try {
                SinhVien sv = AddSV(view);//Thêm sinh viên vào bảng jframe
                if (sv == null) {
                    return;
                }
                //check số đt
                if (model.checkSDT(sv.getSDT())) {
                    view.getTxt_SDT().setBorder(nhapSai);
                }
                //check trùng mã
                if (model.checkTrungMa(sv.getMaSV())) {
                    view.getTxt_msv().setBorder(nhapSai);
                }

                if (model.checkEmail(sv.getEmail())) {
                    view.getTxt_Email().setBorder(nhapSai);

                }

                if (model.checkSDT(sv.getSDT()) || model.checkTrungMa(sv.getMaSV()) || model.checkEmail(sv.getEmail())) {
                    return;
                }
                // thêm sinh viên vào database
                setSuccess(nhapDung);
                model.add(sv);
                JOptionPane.showMessageDialog(null, "         Thêm thành công", "", JOptionPane.DEFAULT_OPTION, DocIMG.greenTick());

                //hiện dữ liệu trên bảng
                ShowTable(model.getDssv());
            } catch (SQLException ex) {
                Logger.getLogger(QLSVController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //Nút Tìm
        view.getBtn_Tim().addActionListener((e) -> {
            QLSVModel.find f = QLSVModel.find.ma;
            //Tạo trường hợp lựa chọn cho việc tìm kiếm sinh viên
            switch (view.getComboTimKiem().getSelectedItem().toString()) {
                case "Mã":
                    f = QLSVModel.find.ma;
                    break;
                case "Khoa":
                    f = QLSVModel.find.khoa;
                    break;
                case "Lớp":
                    f = QLSVModel.find.lop;
                    break;
                case "Tên":
                    f = QLSVModel.find.ten;
                    break;
            }

            String maCanTim = view.getTxt_Tim().getText();
            // Mã rỗng
            if (maCanTim.equals("")) {
                JOptionPane.showMessageDialog(null, "               Nhập mã", "", JOptionPane.DEFAULT_OPTION, DocIMG.error());
                return;
            }

            LinkedList<SinhVien> dssv = new LinkedList<>();
            try {
                //tìm mã trong database 
                dssv = model.find(maCanTim, f);
            } catch (SQLException ex) {
                Logger.getLogger(QLSVController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Danh sách rỗng
            if (dssv.isEmpty()) {
                JOptionPane.showMessageDialog(null, "               Không tìm thấy", "", JOptionPane.DEFAULT_OPTION, DocIMG.error());
                return;
            }
            //hiện dữ liêu tìm kiếm trên table
            ShowTable(dssv);
        });

        //Nút xem tất cả dữ liệu trong database
        view.getBtnXemTatCa().addActionListener((x) -> {
            ShowTable(model.getDssv());
        });

        //Nút sửa trong bảng jframe
        view.getBtn_Sua().addActionListener((x) -> {
            //Lấy vị trí dòng đang chọn
            int row = view.getTb_SV().getSelectedRow();
            SinhVien s = new SinhVien();
            if (row != -1) {
                setSuccess(nhapDung);
                try {
                    s = model.find(view.getTb_SV().getValueAt(row, 0).toString(), QLSVModel.find.ma).getFirst();
                } catch (SQLException ex) {
                    Logger.getLogger(QLSVController.class.getName()).log(Level.SEVERE, null, ex);
                }
                SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");

                view.getTxt_msv().setText(s.getMaSV());
                view.getTxt_hoTen().setText(s.getHoTen());
                view.getTxt_DC().setText(s.getDiaChi());
                view.getTxt_Email().setText(s.getEmail());
                view.getTxt_Khoa().setText(s.getKhoa());
                view.getTxt_Lop().setText(s.getLop());
                view.getTxt_NS().setText(ft.format(s.getNgaySinh()));
                view.getTxt_SDT().setText(s.getSDT());
                if (s.getGioiTinh().equals("Nam")) {
                    view.getGrGioiTinh().setSelected(view.getCheckNam().getModel(), true);
                } else {
                    view.getGrGioiTinh().setSelected(view.getCheckNu().getModel(), true);
                }
                view.getTxt_msv().setEnabled(false);
                view.getTb_SV().clearSelection();
            } else {
                SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    SinhVien s1 = model.find(view.getTxt_msv().getText(), QLSVModel.find.ma).getFirst();
                    SinhVien s2 = AddSV(view);
                    boolean bl1 = true;
                    boolean bl2 = true;

                    view.getTxt_msv().setBorder(nhapDung);

                    if ((bl1 = model.checkEmail(s2.getEmail()) && !s2.getEmail().equals(s1.getEmail()))) {
                        view.getTxt_Email().setBorder(nhapSai);
                    } else {
                        view.getTxt_Email().setBorder(nhapDung);
                    }
                    if ((bl2 = model.checkSDT(s2.getSDT()) && !s2.getSDT().equals(s1.getSDT()))) {
                        view.getTxt_SDT().setBorder(nhapSai);
                    } else {
                        view.getTxt_SDT().setBorder(nhapDung);
                    }

                    if (bl2 || bl1) {
                        return;
                    }

                    model.update(AddSV(view));
                } catch (SQLException ex) {
                    Logger.getLogger(QLSVController.class.getName()).log(Level.SEVERE, null, ex);
                }
                setSuccess(nhapDung);
                JOptionPane.showMessageDialog(null, "               Sửa thành công", "", JOptionPane.DEFAULT_OPTION, DocIMG.greenTick());

                view.getTxt_msv().setEnabled(true);
                ShowTable(model.getDssv());
            }
        });

        //Nút xóa
        view.getBtn_Xoa().addActionListener((e) -> {
            int[] rows = view.getTb_SV().getSelectedRows();
            if (rows != null) {
                try {
                    for (int row : rows) {
                        model.remove(view.getTb_SV().getValueAt(row, 0).toString());
                    }
                    JOptionPane.showMessageDialog(null, "               Xoá thành công", "", JOptionPane.DEFAULT_OPTION, DocIMG.greenTick());
                } catch (SQLException ex) {
                    Logger.getLogger(QLSVController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ShowTable(model.getDssv());
        });
    }

    //Cập nhật lại bảng sinh viên
    public void ShowTable(LinkedList<SinhVien> dssv) {
        DefaultTableModel table = (DefaultTableModel) view.getTb_SV().getModel();

        table.setColumnCount(9);
        table.setRowCount(0);

        dssv.forEach((sv) -> {
            SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
            table.addRow(new Object[]{sv.getMaSV(), sv.getHoTen(), sv.getGioiTinh(),
                ft.format(sv.getNgaySinh()), sv.getKhoa(), sv.getLop(),
                sv.getDiaChi(), sv.getSDT(), sv.getEmail()});
        });

        view.getTb_SV().setModel(table);
    }

    //Thêm sinh viên vào bảng
    public SinhVien AddSV(QLSVView view) throws SQLException {

        String maSV = view.getTxt_msv().getText();
        String tenSV = view.getTxt_hoTen().getText();
        String gioiTinh = view.isGioiTinhNam() ? "Nam" : "Nữ";
        String ngaySinh = view.getTxt_NS().getText();
        String diaChi = view.getTxt_DC().getText();
        String email = view.getTxt_Email().getText();
        String khoa = view.getTxt_Khoa().getText();
        String lop = view.getTxt_Lop().getText();
        String sDT = view.getTxt_SDT().getText();

        //điều kiện-------------
        if (maSV.equals("") || model.checkTrungMa(maSV)) {
            view.getTxt_msv().setBorder(nhapSai);
        } else {
            view.getTxt_msv().setBorder(nhapDung);
        }
        if (tenSV.equals("")) {
            view.getTxt_hoTen().setBorder(nhapSai);
        } else {
            view.getTxt_hoTen().setBorder(nhapDung);
        }
        //NgaySinh
        if (ngaySinh.equals("") || checkNgaySinh(ngaySinh) == false) {
            view.getTxt_NS().setBorder(nhapSai);
        } else {
            view.getTxt_NS().setBorder(nhapDung);
        }
        if (diaChi.equals("")) {
            view.getTxt_DC().setBorder(nhapSai);
        } else {
            view.getTxt_DC().setBorder(nhapDung);
        }
        if (model.checkEmail(email) || !validate_email(email)) {
            view.getTxt_Email().setBorder(nhapSai);
        } else {
            view.getTxt_Email().setBorder(nhapDung);
        }
        if (khoa.equals("")) {
            view.getTxt_Khoa().setBorder(nhapSai);
        } else {
            view.getTxt_Khoa().setBorder(nhapDung);
        }
        if (lop.equals("")) {
            view.getTxt_Lop().setBorder(nhapSai);
        } else {
            view.getTxt_Lop().setBorder(nhapDung);
        }
        if (!validate_SDT(sDT) || (sDT.length() != 10 && sDT.length() != 11) || model.checkSDT(sDT)) {
            view.getTxt_SDT().setBorder(nhapSai);
        } else {
            view.getTxt_SDT().setBorder(nhapDung);
        }
        // kiểm tra điều kiện thêm sinh viên
        boolean bl1 = !maSV.equals("") && !tenSV.equals("") && !ngaySinh.equals("") && checkNgaySinh(ngaySinh);
        boolean bl2 = validate_SDT(sDT) && (sDT.length() == 10 || sDT.length() == 11);
        boolean bl3 = !diaChi.equals("") && !khoa.equals("") && !lop.equals("") && validate_email(email);
        if (bl1 && bl2 && bl3) {
            Date d = new Date(ngaySinh);
            return new SinhVien(maSV, tenSV, gioiTinh, d, khoa, lop, email, sDT, diaChi);
        } else {
            return null;
        }
    }

    //chỉnh lại bình thường khi thêm thành công
    private void setSuccess(Border b) {
        view.getTxt_msv().setText("");
        view.getTxt_DC().setText("");
        view.getTxt_Email().setText("");
        view.getTxt_Khoa().setText("");
        view.getTxt_Lop().setText("");
        view.getTxt_NS().setText("");
        view.getTxt_SDT().setText("");
        view.getTxt_Tim().setText("");
        view.getTxt_hoTen().setText("");

        view.getTxt_msv().setBorder(b);
        view.getTxt_DC().setBorder(b);
        view.getTxt_Email().setBorder(b);
        view.getTxt_Khoa().setBorder(b);
        view.getTxt_Lop().setBorder(b);
        view.getTxt_NS().setBorder(b);
        view.getTxt_SDT().setBorder(b);
        view.getTxt_Tim().setBorder(b);
        view.getTxt_hoTen().setBorder(b);
    }

    //Định dạng chuỗi số điện thoại
    private static final Pattern VALID_SDT_REGEX
            = Pattern.compile("^[0-9]+$", Pattern.CASE_INSENSITIVE);

    //Định dạng chuỗi email
    private static final Pattern VALID_EMAIL_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    //check email
    public static boolean validate_email(String emailStr) {
        Matcher matcher = VALID_EMAIL_REGEX.matcher(emailStr);
        return matcher.find();
    }

    //check số điện thoại
    public static boolean validate_SDT(String sDT) {
        Matcher matcher = VALID_SDT_REGEX.matcher(sDT);
        return matcher.find();
    }

    //check ngày sinh
    public static boolean checkNgaySinh(String ngaySinh) {
        try {
            Date d = new Date(ngaySinh);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) throws SQLException {
        QLSVController qlsvController = new QLSVController(new QLSVModel(), new QLSVView());
    }
}
/**
 * Chưa tối ưu Chức năng sửa trùng email,sđt,khác mã
 *
 */
