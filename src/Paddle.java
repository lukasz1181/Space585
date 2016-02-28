import java.awt.*;

public class Paddle {
    private int initX;
    private int initY;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Paddle(int x, int y) {
        this.initX = x;
        this.initY = y;
        reset();
    }

    public void reset() {
        x = initX;
        y = initY;

    }

    public void move(int dy) {
        y += dy;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, (int)y, 10, 38);

        if (y > 400) {
            y = 400;
        }
        else if (y < 0) {
            y = 0;
        }
    }
}

