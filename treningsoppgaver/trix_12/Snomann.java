import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Snomann {

    public static void main(String[] args) {
        JFrame vindu = new JFrame("Snomann");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        panel.add(new SnomannTegning());

        vindu.pack();
        vindu.setVisible(true);
    }
}

class SnomannTegning extends JComponent {
    SnomannTegning() {
        setPreferredSize(new Dimension(300, 600));
    }

    void tegnKule (Graphics2D g2, int centerX, int centerY, int radius) {
        g2.setColor(Color.WHITE);
        g2.fillOval(centerX - radius, centerY - radius, radius*2, radius*2);
        g2.setColor(Color.BLACK);
        g2.drawOval(centerX - radius, centerY - radius, radius*2, radius*2);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        tegnKule(g2, 150, 150, 50);
        tegnKule(g2, 150, 275, 75);
        tegnKule(g2, 150, 450, 100);

        g2.setColor(Color.RED);
        g2.fillRect(125, 50, 50, 25);
        g2.fillRect(100, 75, 100, 30);
    }
}