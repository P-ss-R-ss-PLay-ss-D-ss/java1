package QLSV;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class DocIMG {

    public static ImageIcon greenTick() {
        try {
            Image i = ImageIO.read(new File("./src/QLSV/check.png"));
            Image i2 = i.getScaledInstance(35, 35, 0);
            return new ImageIcon(i2);
        } catch (IOException e) {
        }
        return null;
    }

    public static ImageIcon error() {
        try {
            Image i = ImageIO.read(new File("./src/QLSV/error.png"));
            Image i2 = i.getScaledInstance(35, 35, 0);
            return new ImageIcon(i2);
        } catch (IOException e) {
        }
        return null;
    }
}
