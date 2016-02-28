
public class Pong {

    final static int TICKS_PER_SECONDS = 60;
    final static long SKIP_TICKS = 1000/TICKS_PER_SECONDS;

    public static void main(String[] args) {
        new PongJFrame();

        long nextTick = System.currentTimeMillis();
        while (true) {
            while (System.currentTimeMillis() > nextTick) {
                PongJFrame.updateScreen();
                nextTick += SKIP_TICKS;
            }
        }
    }
}
