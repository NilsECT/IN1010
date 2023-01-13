import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// gjor slik at Rutene til labyrinten blir JButtons og kan da enklere printe utveier og slikt

abstract class Rute extends JButton implements ActionListener {
    protected int kol;
    protected int rad;
    protected Labyrint labyrint;
    protected boolean besokt = false;

    // om ruten er paa randen kan den mangle noen naboer, disse manglende naboene skal vaere null
    protected Rute nordNabo = null;
    protected Rute oestNabo = null;
    protected Rute sydNabo = null;
    protected Rute vestNabo = null;

    // abstrakt metode for aa faa tegne innehold i ruten
    abstract char tilTegn();

    // abstrakt metode for aa sette naboer
    abstract void settNordNabo(Rute nordNabo);    
    abstract void settOestNabo(Rute oestNabo);
    abstract void settSydNabo(Rute sydNabo);
    abstract void settVestNabo(Rute vestNabo);

    // metoder for aa hente posisjonen
    // trengs kanskje ikke, men i tilfellet
    abstract int hentKol();
    abstract int hentRad();

    // ArrayList som inneholder veien
    protected ArrayList<Rute> vei;

    // kaller paa gaa() til alle naboruter, denne endres ikke for hvite ruter
    protected void gaa(Labyrint labyrint, ArrayList<Rute> veiHittil){
        besokt = true;

        // setter in posisjonen i arrayen som blir lagret lokalt
        vei = new ArrayList<>(veiHittil);
        vei.add(this);

        // gaar til en nabo som finnes og som ikke er en den har besokt foer
        // den ruten den kommer fra tells som besokt!
        if (nordNabo != null && !nordNabo.besokt) {
            nordNabo.gaa(labyrint, vei);
        }
        if (oestNabo != null && !oestNabo.besokt) {
            oestNabo.gaa(labyrint, vei);
        }
        if (sydNabo != null && !sydNabo.besokt) {
            sydNabo.gaa(labyrint, vei);
        }
        if (vestNabo != null && !vestNabo.besokt) {
            vestNabo.gaa(labyrint, vei);
        }
        besokt = false;
    }

    protected void finnUtvei(Labyrint labyrint){
        gaa(labyrint, new ArrayList<>());
    }


    // GUI relevante metoder kommer her

    @Override
    // loeser labyrinten for hvert trykk (og sletter de gamle losningene)
    // sender loesningene til main og viser hvor mange losninger den fant
    // viser forste losning med en gang, kan vise neste via Viser
    public void actionPerformed (ActionEvent e) {

        // denne delen er for nytt trykk
        if (!LabyrintGUI.losninger.isEmpty()) {
            for (Rute rute : LabyrintGUI.losninger.get(Viser.losningNummer - 1)) {
                rute.visk();
            }
        }
        LabyrintGUI.losninger.clear();
        Viser.losningNummer = 0;

        // denne delen loser labyrinten og viser forste loesning
        ArrayList<ArrayList<Rute>> utveier = LabyrintGUI.labyrint.finnUtveiFra(this.kol, this.rad);
        LabyrintGUI.losninger = utveier;
        for (Rute rute : utveier.get(Viser.losningNummer)) {
            rute.utvei();
        }
        LabyrintGUI.antLosninger.setText("Viser loesning:" + (Viser.losningNummer + 1) + " av " + LabyrintGUI.losninger.size());
        LabyrintGUI.antLosninger.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        Viser.losningNummer++;
    }

    void initGUI () {
        setPreferredSize(new Dimension(50, 50));
        addActionListener(this);
    }

    // metode for aa male utveien
    // her blir det en sort X og groenn bakgrunn, kan kommentere ut en av de to
    void utvei() {
        setText("X");
        setOpaque(true);
        setBackground(Color.GREEN);
        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 10));
    }

    // metode for aa viske utveien
    void visk() {
        setText("");
        setOpaque(false);
    }
}
