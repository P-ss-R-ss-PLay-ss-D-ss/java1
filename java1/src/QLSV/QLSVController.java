package QLSV;

import java.awt.Color;
import java.text.ParseException;
import javax.swing.border.Border;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;

public class QLSVController {

    private enum ERROR {
        MASV,
        HOTEN,
        GIOITINH,
        NGAYSINH,
        KHOA,
        LOP,
        MAIL,
        SDT,
        DIACHI
    }
    //fields
    private QLSVModel model;
    private QLSVView view;

    //properties
    public QLSVModel getModel() {
        return model;
    }

    public void setModel(QLSVModel model) {
        this.model = model;
    }

    public QLSVView getView() {
        return view;
    }

    public void setView(QLSVView view) {
        this.view = view;
    }

    //ocnstructor
    public QLSVController() {
        model = new QLSVModel();
        view = new QLSVView();
    }

    public QLSVController(QLSVModel model, QLSVView view) {
        this.model = model;
        this.view = view;

        init();

        this.view.setVisible(true);
    }

    //bắt sự kiện nút chức năng
    public void init() {
        ///Nút thêm
        view.getBtn_them().addActionListener((x) -> {
            try {
                //view.setTxtAlert("", Color.red);
                SinhVien sv = AddSV(view);
                if (sv == null) {
                    System.out.println("bạn đã nhập sai");
                    //view.setTxtAlert("Error: bạn đã nhập sai!!!", Color.red);
                    return;
                }

                model.add(sv);
                ShowTable(model.getDssv());
            } catch (Exception ex) {
                Logger.getLogger(QLSVController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //Nút Tìm
        view.getBtn_Tim().addActionListener((e) -> {
            String maCanTim = view.getTxt_Tim().getText();
            System.out.println(maCanTim);
            if (maCanTim.equals("")) {
                System.out.println("nhập mã môn học cần tim");
                //view.setTxtAlert("Error: nhập mã môn học cần tim!!!", Color.red);
                return;
            }

            LinkedList<SinhVien> mhs = model.Find(maCanTim);
            if (mhs.isEmpty()) {
                System.out.println("không tìm thấy mã môn học cần tim");
                //view.setTxtAlert("Warning: không tìm thấy mã môn học cần tim!!!", Color.orange);
                return;
            }

            ShowTable(mhs);
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
                sv.getDiaChi(), sv.getsDT(), sv.getEmail()});
        });

        view.getTb_SV().setModel(table);
    }

    //Thêm sinh viên
    public SinhVien AddSV(QLSVView view) {
        Border nhapSai = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
          Border nhapDung = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
        String maSV = view.getTxt_msv().getText();
        String tenSV = view.getTxt_hoTen().getText();
        String gioiTinh = view.isGioiTinhNam() ? "Nam" : "Nu";
        String ngaySinh = view.getTxt_NS().getText();
        String diaChi = view.getTxt_DC().getText();
        String email = view.getTxt_Email().getText();
        String khoa = view.getTxt_Khoa().getText();
        String lop = view.getTxt_Lop().getText();
        String sDT = view.getTxt_SDT().getText();

        //điều kiện-------------
        if (maSV.equals("")) {
            //code chỉnh border
            view.getTxt_msv().setBorder(nhapSai);
        }
        if (tenSV.equals("")) {
            view.getTxt_hoTen().setBorder(nhapSai);
        }
        //NgaySinh
        if (ngaySinh.equals("") || checkNgaySinh(ngaySinh) == false) {
            view.getTxt_NS().setBorder(nhapSai);
        }
        if (diaChi.equals("")) {
            view.getTxt_DC().setBorder(nhapSai);
        }
        if ("".equals(email)) {
            view.getTxt_Email().setText("");
        } else {
            if (validate_email(email) == false) {
                view.getTxt_Email().setBorder(nhapSai);
            }
        }
        if (khoa.equals("")) {
            view.getTxt_Khoa().setBorder(nhapSai);
        }
        if (lop.equals("")) {
            view.getTxt_Lop().setBorder(nhapSai);
        }
        if (!validate_SDT(sDT) || (sDT.length() != 10 && sDT.length() != 11)) {
            view.getTxt_SDT().setBorder(nhapSai);
        }
        if (model.CheckTrungMa(model, maSV)) {
            view.getTxt_msv().setBorder(nhapSai);

        }
        //ghi code vô đây
        //
        boolean bl1 = maSV.equals("") || tenSV.equals("") || ngaySinh.equals("") || checkNgaySinh(ngaySinh) == false || diaChi.equals("") || khoa.equals("") || lop.equals("");
        boolean bl2 = validate_SDT(sDT) == false || (sDT.length() != 10 && sDT.length() != 11) || model.CheckTrungMa(model, maSV);
        if (!(bl1 || bl2)) {
            Date d = new Date(ngaySinh);

            return new SinhVien(maSV, tenSV, gioiTinh, d, khoa, lop, email, sDT, diaChi);

        } else {
            return null;
        }
    }

    private void setSuccess() {
        view.getTxt_msv().setText("");
        view.getTxt_DC().setText("");
        view.getTxt_Email().setText("");
        view.getTxt_Khoa().setText("");
        view.getTxt_Lop().setText("");
        view.getTxt_NS().setText("");
        view.getTxt_SDT().setText("");
        view.getTxt_Tim().setText("");
        view.getTxt_hoTen().setText("");
        
    }

    private static final Pattern VALID_SDT_REGEX
            = Pattern.compile("^[0-9]+$", Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate_email(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean validate_SDT(String sDT) {
        Matcher matcher = VALID_SDT_REGEX.matcher(sDT);
        return matcher.find();
    }

    public static boolean checkNgaySinh(String ngaySinh) {
        try {
            Date d = new Date(ngaySinh);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        QLSVController qlsvController = new QLSVController(new QLSVModel(), new QLSVView());
    }
}
