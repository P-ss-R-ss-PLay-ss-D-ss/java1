package flappybird1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    private ConChim conchimT = new ConChim();
    private Ong ongnuoc1 = new Ong(1000 + 280 * 0);
    private Ong ongnuoc2 = new Ong(1000 + 280 * 1);
    private Ong ongnuoc3 = new Ong(1000 + 280 * 2);
    private Ong ongnuoc4 = new Ong(1000 + 280 * 3);
    // private KiemTra kiemtraT = new KiemTra();
    private Replay r = new Replay();
    private static int diem = 0;

    private static boolean bl1 = false;
    private static boolean bl2 = false;
    private static boolean bl3 = false;
    private static boolean bl4 = false;
    int xuathien = 0;

    public static boolean ketThuc = false;

    private Thread threadT;

    private ConMoi conMoiT = new ConMoi();

    public GamePanel() {
        threadT = new Thread(this);
        threadT.start(); // khi goi lenh nay se duoc chuyen den phuong thuc
        // run() phia duoi
    }

    // ve cac nhan vat trong game
    @Override
    public void paint(Graphics g) {
        try {
            BufferedImage img1 = ImageIO.read(new File("./res/BG.png"));
            g.drawImage(img1, 0, 0, getWidth(), getHeight(), this);
            BufferedImage img2 = ImageIO.read(new File("./res/NenDat.png"));
            g.drawImage(img2, 0, 400, getWidth(), 100, this);
        } catch (IOException e) {
        }
        // them ong nuoc vao nen game
        ongnuoc1.paint(g);
        ongnuoc2.paint(g);
        ongnuoc3.paint(g);
        ongnuoc4.paint(g);

//        g.setColor(Color.ORANGE);
//        g.fillRect(0, 400, getWidth(), getHeight());
        // them con chim vao game
        if (!ketThuc) {
            conchimT.paint(g);
            conMoiT.paint(g);
        }

        if (ketThuc) {
            try {
                BufferedImage img1 = ImageIO.read(new File("./res/GameOver.png"));
                g.drawImage(img1, getWidth() / 2 - 120, getHeight() / 2 - 80, this);
            } catch (IOException e) {
            }
        }
//        r.paint(g);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 20));
        g.drawString("Điểm: " + diem, 10, 20);
    }
    int i = 0;

    // implements Runnable thư viện để chạy game
    @Override
    public void run() {

        // 1 vong lap khong bao gio dung
        while (!ketThuc) {

            repaint(); // goi lai paint

            ongnuoc1.giamX(); // goi den phuong thuc giamX cua class OngNuoc
            ongnuoc2.giamX();
            ongnuoc3.giamX();
            ongnuoc4.giamX();

            try {
                Thread.sleep(10); // chuong trinh dung lai 20 ms
            } catch (InterruptedException e) {
            }

            // goi den phuong thuc .... cua class OngNuoc
            if (ongnuoc1.laplaiX()) {
                xuathien++;
            }

            ongnuoc2.laplaiX();
            ongnuoc3.laplaiX();
            ongnuoc4.laplaiX();
            if (xuathien >= 2) {
                ConMoi.xuatHien(ongnuoc1);
            }

            if (chet() == true && bl1) {
                ketThuc = true;
//                try {
//                    threadT.wait();
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }

            if (chet() == true) {
                bl1 = true;
            }

            conchimT.tangY(); // con chim tu roi xuong dat chet

            quaOngTangDiem(conchimT, ongnuoc1);
            quaOngTangDiem(conchimT, ongnuoc2);
            quaOngTangDiem(conchimT, ongnuoc3);
            quaOngTangDiem(conchimT, ongnuoc4);
        }

    }

    public boolean chet() {

        // khi con chim cham dat
        if (ConChim.getY() + ConChim.kichThuoc >= 400) {
            return true;
        }
        // khi con chim cham ong nuoc
        // con chim cham ong nuoc thu 1234

        return coVaCham(conchimT, ongnuoc1) || coVaCham(conchimT, ongnuoc2)
                || coVaCham(conchimT, ongnuoc3) || coVaCham(conchimT, ongnuoc4);
    }

    public boolean coVaCham(ConChim chim, Ong ong) {
        boolean c = (chim.getX() + chim.kichThuoc) >= ong.getX();//chui vô lỗ
        boolean d = chim.getY() <= ong.getH();//nằm giữa lỗ
        boolean e = chim.getX() <= (ong.getX() + Ong.PI);

        boolean a = d && c && e;

        boolean h = chim.getY() + chim.kichThuoc >= ong.getH() + Ong.TRONG;
        boolean f = (chim.getX() + chim.kichThuoc) >= ong.getX();
        boolean g = chim.getX() <= (ong.getX() + Ong.PI);

        boolean b = h && f && g;

        return a || b;
    }

    private void quaOngTangDiem(ConChim chim, Ong ong) {
        if (ConChim.getX() + ConChim.kichThuoc > ong.getX() && ConChim.getX() < ong.getX() + 65) {
            ong.setChuaQua(true);
        }
        if (ong.isChuaQua() == true && ConChim.getX() > ong.getX() + 65) {
            diem++;
            ong.setChuaQua(false);
        }
    }
}
