import com.sun.media.sound.FFT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameField extends JPanel implements ActionListener {
    private Apple apple;
    private Snake snake;
    private final int SIZE = 320;
    private final int DOT_SIZE = 16;
    private boolean inGame = true;
    public enum Direction {LEFT, UP, DOWN, RIGHT};
    private String direction = "RIGHT";




    public GameField() {
        setBackground(Color.green);

        apple = new Apple(DOT_SIZE);
        snake = new Snake(DOT_SIZE);

        initGame(snake, apple);
        addKeyListener(new FieldKeyListenere());
        setFocusable(true);

    }

    public void initGame(Snake snake, Apple apple) {
        snake.setDots(DOT_SIZE);

        Timer timer = new Timer(250, this);
        timer.start();

        apple.create(DOT_SIZE);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            apple.drawImage(g, this);
            snake.drawImage(g, this);
        } else {
            String gameOver = "Game Over";
//            Font f = new Font("Arial", 14, Font.BOLD);
            g.setColor(Color.white);
//            g.setFont(f);
            g.drawString(gameOver, 125, SIZE/2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            if(snake.checkApple(apple)){
                apple.create(DOT_SIZE);
            }
            inGame = snake.checkCollisions(SIZE);

            snake.move(direction, DOT_SIZE);
        }

        repaint();
    }

    class FieldKeyListenere extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT && !direction.equals("RIGHT")){
                direction = Direction.LEFT.toString();
            }else if (key == KeyEvent.VK_UP && !direction.equals("DOWN")){
                direction = Direction.UP.toString();
            }else if (key == KeyEvent.VK_RIGHT && !direction.equals("LEFT")){
                direction = Direction.RIGHT.toString();
            }else if (key == KeyEvent.VK_DOWN && !direction.equals("UP")){
                direction = Direction.DOWN.toString();
            }
        }
    }
}
