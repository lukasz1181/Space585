import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Field extends JComponent implements KeyListener{
    private Ball ball;

    private Paddle player1;
    private Paddle player2;
    private boolean wPressed;
    private boolean sPressed;
    private boolean upPressed;
    private boolean downPressed;
    private int speed;

    public Field() {
        wPressed = false;
        sPressed = false;
        upPressed = false;
        downPressed = false;
        speed = 6;

        player1 = new Paddle(20, 201);
        player2 = new Paddle(704-30, 201);
        ball = new Ball(704/2-5, 441/2-5, speed);

        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
        player1.paint(g);
        player2.paint(g);
        ball.paint(g);

        if (wPressed) {
            player1.move(-speed);
        }
        else if (sPressed) {
            player1.move(speed);
        }
        else {
            player1.move(0);
        }

        if (upPressed) {
            player2.move(-speed);
        }
        else if (downPressed) {
            player2.move(speed);
        }

        if(!ball.detectCollision(player1, player2)) {
            ball.reset();
            player1.reset();
            player2.reset();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            wPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            sPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            wPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            sPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
    }
}
