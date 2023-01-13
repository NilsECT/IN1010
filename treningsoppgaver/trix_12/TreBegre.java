import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class TreBegre {
    static boolean ferdig = false;
    static Beger[] beger = new Beger[3];

    public static void main(String[] args) {
        JFrame vindu = new JFrame("Tre Begre");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        for (int i = 0; i < 3; i++) {
            beger[i] = new Beger(i);
            beger[i].initGUI();
            panel.add(beger[i]);
        }
        beger[new Random().nextInt(3)].harBall = true;

        vindu.pack();
        vindu.setVisible(true);
    }
}
