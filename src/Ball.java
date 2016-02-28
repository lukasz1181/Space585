import java.awt.*;

public class Ball {
    private double x;
    private double y;
    private int initX;
    private int initY;
    private double dx;
    private double dy;
    private double speed;

    public Ball(int x, int y, double speed) {
        this.x = x;
        this.y = y;
        this.initX = x;
        this.initY = y;
        this.speed = speed;

        reset();
    }

    private void calculateDx() {
        dx = Math.sqrt(1-dy*dy);
    }

    public void reset() {
        x = initX;
        y = initY;
        dy = 0;
        if(Math.random() > 0.5){
            dx = -1;
        }
        else {
            dx = 1;
        }
    }

    public void paint(Graphics g) {
        g.fillOval((int)x, (int)y, 10, 10);
        x += dx * speed;
        y += dy * speed;
    }

    public boolean detectCollision(Paddle left, Paddle right) {
        if (x < left.getX()+10 && x+10 > left.getX() && y+5 >= left.getY() && y+5 <= left.getY() + 40) {
            x = left.getX()+10;
            dy = (y+5 - left.getY()-19)/20;
            calculateDx();
            return true;
        }
        else if (x+10 > right.getX() && x < right.getX()+10 && y+5 >= right.getY() && y+5 <= right.getY() + 38) {
            x = right.getX() - 10;
            dy = (y+5 - right.getY()-19)/20;
            calculateDx();
            dx *= -1;
            return true;
        }
        else if (x < 0 || x+10 > 704) {
            return false;
        }
        else if (y < 0 || y+10 > 441) {
            dy *= -1;
            return true;
        }
        return true;
    }
}
