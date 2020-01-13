import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Apple {
    public int appleX;
    public int appleY;

    private Image icon;


    public Apple(int dotSize){
        loadImage(dotSize);
    }

    private void loadImage(int dotSize) {
        ImageIcon iia = new ImageIcon("apple.png");
        icon = iia.getImage();
        icon = Utils.resizeImage(icon, dotSize, dotSize);
    }

    public void create(int dotSize) {
        appleX = new Random().nextInt(20) * dotSize;
        appleY = new Random().nextInt(20) * dotSize;
    }


    public void drawImage(Graphics g, GameField gameField) {
        g.drawImage(icon, appleX, appleY, gameField);
    }
}
