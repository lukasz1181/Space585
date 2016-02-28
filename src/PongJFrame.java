import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PongJFrame extends JFrame {
    private static Field field;
    private static Image icon;

    public PongJFrame() {
        super("PONG");
        setSize(720, 480);
        setLocation(100, 100);
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        field = new Field();
        getContentPane().add(field, BorderLayout.CENTER);
        setVisible(true);
        try {
            icon = ImageIO.read(new File("icon.png"));
        }
        catch (Exception e) {
           // World explodes if this happens
        }

        setIconImage(icon);
    }

    public static void updateScreen() {
        field.repaint();
    }
}
