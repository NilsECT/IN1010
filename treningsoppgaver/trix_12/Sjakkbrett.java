import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sjakkbrett {
    
    public static void main(String[] args) {
        JFrame vindu = new JFrame("Sjakkbrett");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        JPanel sjakkbrett = new JPanel();
        sjakkbrett.setLayout(new GridLayout(8, 8));

        for (int i = 8; i >= 1; i--) {  // rad
            for (int ii = 8; ii >= 1; ii--) {   // kol
                Rute rute;
                if ((i + ii) % 2 != 0) {
                    rute = new SortRute();
                }
                else {
                    rute = new HvitRute();
                }
                rute.initGUI();
                sjakkbrett.add(rute);
            }
        }

        panel.add(sjakkbrett);

        vindu.pack();
        vindu.setVisible(true);
    }
}

abstract class Rute extends JLabel {
    void initGUI() {
        setPreferredSize(new Dimension(100, 100));
        setOpaque(true);
    }
}

class HvitRute extends Rute {
    @Override
    void initGUI() {
        super.initGUI();
        setBackground(Color.WHITE);
    }
}

class SortRute extends Rute {
    @Override
    void initGUI() {
        super.initGUI();
        setBackground(Color.BLACK);
    }
}