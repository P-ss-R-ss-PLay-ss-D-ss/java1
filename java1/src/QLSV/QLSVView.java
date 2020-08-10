package QLSV;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class QLSVView extends javax.swing.JFrame {

    /**
     * Creates new form QLSV_Frame
     */
    public QLSVView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grGioiTinh = new javax.swing.ButtonGroup();
        maSV = new javax.swing.JLabel();
        hoTen = new javax.swing.JLabel();
        gioiTinh = new javax.swing.JLabel();
        ngaySinh = new javax.swing.JLabel();
        khoa = new javax.swing.JLabel();
        lop = new javax.swing.JLabel();
        diaChi = new javax.swing.JLabel();
        sDT = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        txt_msv = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_SV = new javax.swing.JTable();
        txt_hoTen = new javax.swing.JTextField();
        txt_Khoa = new javax.swing.JTextField();
        txt_DC = new javax.swing.JTextField();
        txt_NS = new javax.swing.JTextField();
        txt_Lop = new javax.swing.JTextField();
        txt_SDT = new javax.swing.JTextField();
        txt_Email = new javax.swing.JTextField();
        btn_Sua = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_Tim = new javax.swing.JButton();
        txt_Tim = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel1 = new javax.swing.JLabel();
        checkNam = new javax.swing.JRadioButton();
        checkNu = new javax.swing.JRadioButton();
        comboTimKiem = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnXemTatCa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Sinh Viên");
        setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setLocation(new java.awt.Point(150, 20));
        setResizable(false);

        maSV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        maSV.setText("Mã sinh viên");

        hoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hoTen.setText("Họ tên");

        gioiTinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gioiTinh.setText("Giới tính");

        ngaySinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ngaySinh.setText("Ngày sinh");

        khoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        khoa.setText("Khoa");

        lop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lop.setText("Lớp");

        diaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        diaChi.setText("Địa chỉ");

        sDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sDT.setText("SDT");

        email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        email.setText("Email");

        txt_msv.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_msv.setDisabledTextColor(java.awt.Color.darkGray);

        btn_them.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_them.setText("Thêm");

        tb_SV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_SV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Giới tính", "Ngày sinh", "Khoa", "Lớp", "Địa chỉ", "SDT", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_SV.setToolTipText("");
        tb_SV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tb_SV.setName("ghg"); // NOI18N
        tb_SV.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(tb_SV);
        if (tb_SV.getColumnModel().getColumnCount() > 0) {
            tb_SV.getColumnModel().getColumn(0).setPreferredWidth(17);
            tb_SV.getColumnModel().getColumn(2).setPreferredWidth(15);
            tb_SV.getColumnModel().getColumn(3).setPreferredWidth(30);
            tb_SV.getColumnModel().getColumn(4).setPreferredWidth(35);
            tb_SV.getColumnModel().getColumn(5).setPreferredWidth(30);
            tb_SV.getColumnModel().getColumn(7).setPreferredWidth(20);
        }

        txt_hoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_Khoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_DC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_NS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_Lop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_SDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_Email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_Sua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Sua.setText("Sửa");
        btn_Sua.setToolTipText("");

        btn_Xoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Xoa.setText("Xóa");

        btn_Tim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Tim.setText("Tìm");

        txt_Tim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        grGioiTinh.add(checkNam);
        checkNam.setSelected(true);
        checkNam.setText("Nam");
        checkNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNamActionPerformed(evt);
            }
        });

        grGioiTinh.add(checkNu);
        checkNu.setText("Nữ");

        comboTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã", "Tên", "Khoa", "Lớp" }));
        comboTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTimKiemActionPerformed(evt);
            }
        });

        jLabel2.setText("Tìm kiếm theo:");

        btnXemTatCa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXemTatCa.setText("Xem tất cả");
        btnXemTatCa.setLabel("Xem tất cả");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(gioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(maSV, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(51, 51, 51)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_msv, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(checkNam)
                                    .addGap(18, 18, 18)
                                    .addComponent(checkNu))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(khoa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Khoa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(txt_DC, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(sDT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lop, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(txt_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(hoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ngaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(51, 51, 51)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_NS, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(txt_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addGap(415, 415, 415)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(361, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXemTatCa)
                        .addGap(52, 52, 52)
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(339, 339, 339))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maSV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_msv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_hoTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hoTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ngaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_NS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lop, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkNam)
                            .addComponent(checkNu))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Khoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(khoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sDT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Tim, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(comboTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXemTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_DC, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkNamActionPerformed

    private void comboTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTimKiemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSVView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new QLSVView().setVisible(true);
        });
    }

    public JButton getBtn_Sua() {
        return btn_Sua;
    }

    public JButton getBtn_Tim() {
        return btn_Tim;
    }

    public JButton getBtn_Xoa() {
        return btn_Xoa;
    }

    public JButton getBtn_them() {
        return btn_them;
    }

    public JTable getTb_SV() {
        return tb_SV;
    }

    public JTextField getTxt_DC() {
        return txt_DC;
    }

    public JTextField getTxt_Email() {
        return txt_Email;
    }

    public JTextField getTxt_Khoa() {
        return txt_Khoa;
    }

    public JTextField getTxt_Lop() {
        return txt_Lop;
    }

    public JTextField getTxt_NS() {
        return txt_NS;
    }

    public JTextField getTxt_SDT() {
        return txt_SDT;
    }

    public JTextField getTxt_Tim() {
        return txt_Tim;
    }

    public JTextField getTxt_hoTen() {
        return txt_hoTen;
    }

    public JTextField getTxt_msv() {
        return txt_msv;
    }

    public boolean isGioiTinhNam() {
        return grGioiTinh.getSelection().equals(checkNam.getModel());
    }

    public void setTxt_DC(JTextField txt_DC) {
        this.txt_DC = txt_DC;
    }

    public void setTxt_Email(JTextField txt_Email) {
        this.txt_Email = txt_Email;
    }

    public void setTxt_Khoa(JTextField txt_Khoa) {
        this.txt_Khoa = txt_Khoa;
    }

    public void setTxt_Lop(JTextField txt_Lop) {
        this.txt_Lop = txt_Lop;
    }

    public void setTxt_NS(JTextField txt_NS) {
        this.txt_NS = txt_NS;
    }

    public void setTxt_SDT(JTextField txt_SDT) {
        this.txt_SDT = txt_SDT;
    }

    public void setTxt_Tim(JTextField txt_Tim) {
        this.txt_Tim = txt_Tim;
    }

    public void setTxt_hoTen(JTextField txt_hoTen) {
        this.txt_hoTen = txt_hoTen;
    }

    public void setTxt_msv(JTextField txt_msv) {
        this.txt_msv = txt_msv;
    }

    public ButtonGroup getGrGioiTinh() {
        return grGioiTinh;
    }

    public JComboBox<String> getComboTimKiem() {
        return comboTimKiem;
    }

    public JButton getBtnXemTatCa() {
        return btnXemTatCa;
    }

    public JRadioButton getCheckNam() {
        return checkNam;
    }

    public JRadioButton getCheckNu() {
        return checkNu;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXemTatCa;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Tim;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_them;
    private javax.swing.JRadioButton checkNam;
    private javax.swing.JRadioButton checkNu;
    private javax.swing.JComboBox<String> comboTimKiem;
    private javax.swing.JLabel diaChi;
    private javax.swing.JLabel email;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel gioiTinh;
    private javax.swing.ButtonGroup grGioiTinh;
    private javax.swing.JLabel hoTen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel khoa;
    private javax.swing.JLabel lop;
    private javax.swing.JLabel maSV;
    private javax.swing.JLabel ngaySinh;
    private javax.swing.JLabel sDT;
    private javax.swing.JTable tb_SV;
    private javax.swing.JTextField txt_DC;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_Khoa;
    private javax.swing.JTextField txt_Lop;
    private javax.swing.JTextField txt_NS;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_Tim;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_msv;
    // End of variables declaration//GEN-END:variables
}
