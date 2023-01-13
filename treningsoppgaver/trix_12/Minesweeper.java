import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class Minesweeper {
    static final double prosentMiner = 0.15;
    static int minerLagt = 0;
    static int minerFunnet = 0;
    static final int antKol = 16;
    static final int antRad = 16;
    static boolean harVunnet = false;
    static boolean harTapt = false;
    static JLabel info = new JLabel("      ");
    static MineRute[][] ruter = new MineRute[antKol][antRad];

    public static void main(String[] args) {
        JFrame vindu = new JFrame("MINESWEEPER");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        JPanel rutenett = new JPanel();
        rutenett.setLayout(new GridLayout(antRad, antKol));

        for (int k = 0; k < antKol; k++) {
            for (int r = antRad - 1; r >= 0; r--) {
                MineRute rute = new MineRute(k, r);
                rute.initGUI();
                ruter[k][r] = rute;
                rutenett.add(rute);
            }
        }
        panel.add(rutenett);
        panel.add(info);

        JButton stoppKnapp = new JButton("EXIT");

        class Stopper implements ActionListener {
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        }

        stoppKnapp.addActionListener(new Stopper());

        panel.add(stoppKnapp);

        vindu.pack();
        vindu.setVisible(true);
    }

    static void sjekkOmVunnet () {
        boolean vunnet = true;
        for (int r = 0; r < antRad; r++) {
            for (int k = 0; k <antKol; k++) {
                MineRute rute = ruter[k][r];
                if (!rute.aapnet && !rute.harMine) {
                    vunnet = false;
                }
            }
        }

        if (vunnet) {
            harVunnet = true;
            info.setText("Swiped all the mines bby");
        }
    }
}







class MineRute extends JButton implements ActionListener {
    static Random random = new Random();

    int kol;
    int rad;
    boolean harMine;
    boolean aapnet = false;

    MineRute (int kol, int rad) {
        this.kol = kol;
        this.rad = rad;
        harMine = random.nextDouble() < Minesweeper.prosentMiner;
        if (harMine) {
            Minesweeper.minerLagt++;
        }
    }

    int antNaboMiner() {
        int n = 0;
        if (finnesMine(kol -1, rad -1)) {
            n++;
        }
        if (finnesMine(kol -1, rad)) {
            n++;
        }
        if (finnesMine(kol, rad -1)) {
            n++;
        }
        if (finnesMine(kol +1, rad +1)) {
            n++;
        }
        if (finnesMine(kol +1, rad)) {
            n++;
        }
        if (finnesMine(kol, rad +1)) {
            n++;
        }
        if (finnesMine(kol +1, rad -1)) {
            n++;
        }
        if (finnesMine(kol -1, rad +1)) {
            n++;
        }
        return n;
    }

    boolean finnesMine(int kol, int rad) {
        return kol >= 0 && kol < Minesweeper.antKol && rad >= 0 &&
        rad < Minesweeper.antRad && Minesweeper.ruter[kol][rad].harMine;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (aapnet || Minesweeper.harVunnet || Minesweeper.harTapt) {
            return;
        }

        if (harMine) {
            setForeground(Color.RED);
            setText("O");
            setFont(new Font(Font.SANS_SERIF, Font.BOLD, 70));
            Minesweeper.info.setText("isded");
            Minesweeper.info.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 70));
            Minesweeper.harTapt = true;
        }
        else {
            setText("" + antNaboMiner());
            setFont(new Font(Font.SANS_SERIF, Font.BOLD, 70));
            aapnet = true;
            Minesweeper.sjekkOmVunnet();
        }
    }

    void initGUI () {
        setPreferredSize(new Dimension(100, 100));
        addActionListener(this);
    }
}
