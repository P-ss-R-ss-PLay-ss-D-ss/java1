package flappybird1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Ong {

    public static int caoMax = 400;
    public static int rongMax = 1000;
    public static int PI = 65;
    public static int TRONG = 100;// khoang trong giua 2 ong nuoc
    private int x;//what the hell
    
    public void reset(){
        caoMax = 400;
        rongMax = 1000;
    }
    
    private static boolean sieuNangLuc = false;

    public static boolean isSieuNangLuc() {
        return sieuNangLuc;
    }

    public static void setSieuNangLuc(boolean sieuNangLuc) {
        Ong.sieuNangLuc = sieuNangLuc;
    }

    private int h;

    private boolean chuaQua = false;

    public Ong() {
        ngaunhien();
    }

    public Ong(int x) {
        ngaunhien();
        this.x = x;
    }

    public int getX() {
        if (sieuNangLuc) {
            return 0;
        }
        return x;
    }
//

    public int getH() {
        if (sieuNangLuc) {
            return 0;
        }
        return h;
    }

    public boolean isChuaQua() {
        return chuaQua;
    }

    public void setChuaQua(boolean chuaQua) {
        this.chuaQua = chuaQua;
    }

    // chieu dai ngau nhien cua 1 ong nuoc
    public void ngaunhien() {
        Random rd = new Random();
        h = 50 + rd.nextInt(200); // h1 se bang 1 so ngau nhien trong khoang 0
        // - 199

    }

    // ve ong nuoc
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);

        try {
            BufferedImage img1 = ImageIO.read(new File("./res/OngnuocTren.png"));
            g.drawImage(img1, x, 0, PI, h, null);
            BufferedImage img2 = ImageIO.read(new File("./res/OngnuocDuoi.png"));
            g.drawImage(img2,x, h + TRONG, PI, caoMax - h - TRONG, null);
        } catch (IOException e) {
        }
    }

    // ong nuoc di chuyen giam theo chieu X
    public void giamX() {
        x -= 2;
    }

    // ong nuoc lap lai theo chieu X
    public boolean laplaiX() {
        if (x <= -PI) {
            x = rongMax;
            return true;
        }
        return false;
    }
}
