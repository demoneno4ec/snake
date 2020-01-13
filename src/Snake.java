import javax.swing.*;
import java.awt.*;

public class Snake {
    private int dots;
    private int[] cordX;
    private int MAX_DOTS = 400;
    private int[] cordY;

    private Image dotIcon;

    public Snake(int dotSize) {
        loadImage(dotSize);
        cordX = new int[MAX_DOTS];
        cordY = new int[MAX_DOTS];
    }

    public void setDots(int dotSize) {
        dots = 3;
        for (int i = 0; i < dots; i++) {
            cordX[i] = 48 - i * dotSize;
            cordY[i] = 48;
        }
    }

    private void loadImage(int dotSize) {

        ImageIcon iid = new ImageIcon("dot.jpg");
        dotIcon = iid.getImage();
        dotIcon = Utils.resizeImage(dotIcon, dotSize, dotSize);
    }

    public void drawImage(Graphics g, GameField gameField) {
        for (int i = 0; i < dots; ++i) {
            g.drawImage(dotIcon, cordX[i], cordY[i], gameField);
        }
    }

    public void move(String direction, int dotSize) {
        for (int i = dots; i > 0; --i) {
            cordX[i] = cordX[i - 1];
            cordY[i] = cordY[i - 1];
        }

        if (direction.equals("LEFT")) {
            cordX[0] -= dotSize;
        }
        if (direction.equals("UP")) {
            cordY[0] -= dotSize;
        }
        if (direction.equals("RIGHT")) {
            cordX[0] += dotSize;
        }
        if (direction.equals("DOWN")) {
            cordY[0] += dotSize;
        }
    }

    public boolean checkCollisions(int size) {
        for (int i = dots; i > 0; --i) {
            if (i > 4 && cordX[0] == cordX[i] && cordY[0] == cordY[i]) {
                return false;
            }
        }

        return cordX[0] <= size && cordX[0] >= 0 && cordY[0] <= size && cordY[0] >= 0;
    }

    public boolean checkApple(Apple apple) {
        if (cordX[0] == apple.appleX && cordY[0] == apple.appleX) {
            dots++;
            return true;
        }
        return false;
    }
}
