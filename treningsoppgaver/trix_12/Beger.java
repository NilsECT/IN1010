import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Beger extends JButton {
    boolean harBall = false;
    int num;

    Beger(int num) {
        super("" + num);
        this.num = num;
    }

    class Velger implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (TreBegre.ferdig) {
                return;
            }

            Beger b = (Beger) e.getSource();

            if (b.harBall) {
                b.setForeground(Color.GREEN);
                b.setText("OK");
            }
            else {
                b.setForeground(Color.RED);
                b.setText("NOPE");
            }
            TreBegre.ferdig = true;
        }
    }

    void initGUI() {
        addActionListener(new Velger());
    }
}
