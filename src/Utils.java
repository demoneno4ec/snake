import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Utils {

    public static Image resizeImage(Image img, int width, int height) {
        BufferedImage bi = new BufferedImage (img.getWidth (null), img.getHeight (null), BufferedImage.TYPE_INT_ARGB);

        Graphics g = bi.createGraphics ();
        g.drawImage (img, 0, 0, width, height, null);
        ImageIcon resizeImage = new ImageIcon (bi);

        return resizeImage.getImage();
    }
}
