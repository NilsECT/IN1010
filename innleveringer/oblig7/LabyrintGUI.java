import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class LabyrintGUI {
    static JLabel antLosninger = new JLabel("      ");
    static int kol = 0;
    static int rad = 0;
    static Labyrint labyrint;
    static ArrayList<ArrayList<Rute>> losninger = new ArrayList<>();

    public static void main(String[] args) {
        JFrame vindu = new JFrame("Labyrint Oblig 7");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        vindu.add(panel);

        JPanel rutenett = new JPanel();
        labyrint = lesFil();

        // henter data fra labyrinten som ble laget
        kol = labyrint.hentKol();
        rad = labyrint.hentRad();
        Rute[][] labRutenett = labyrint.hentRutenett();

        rutenett.setLayout(new GridLayout(rad, kol));

        // kobler rutenettet med Rute-knapper
        for (int r = 0; r < rad; r++) {
            for (int k = 0; k < kol; k++) {
                labRutenett[r][k].initGUI();
                rutenett.add(labRutenett[r][k]);
            }
        }

        // lager exit og vis knapp
        JButton stoppKnapp = new JButton("EXIT");
        stoppKnapp.addActionListener(new Stopper());

        JButton vis = new JButton("Vis / Visneste");
        vis.addActionListener(new Viser());

        // setter den ekstra infoen ogknappene i et rutenett
        JPanel valgRutenett = new JPanel();
        valgRutenett.setLayout(new GridLayout(3, 1));

        valgRutenett.add(vis);
        valgRutenett.add(antLosninger);
        valgRutenett.add(stoppKnapp);

        // scrollbar for store labyrinter
        JScrollPane scroll = new JScrollPane(panel);
        panel.setAutoscrolls(true);

        // samler alt i panelet og pakker vinduet
        panel.add(rutenett);
        panel.add(valgRutenett);
        vindu.add(scroll);
        vindu.pack();
        vindu.setVisible(true);
    }

    // metode for aa velge fil og lese den
    // returnerer et Labyrint-objekt for enkelthetensskyld
    static Labyrint lesFil() {
        JFileChooser velger = new JFileChooser();
        int resultat = velger.showOpenDialog(null);
        if (resultat != JFileChooser.APPROVE_OPTION) {
            System.exit(1);
        }

        File fil = velger.getSelectedFile();
        Labyrint lab = null;

        try {
            lab = new Labyrint(new Scanner(fil));
        }
        catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen?");
            System.exit(1);
        }

        return lab;
    }
}

// klasse for knappen som stopper programmet
class Stopper implements ActionListener {
    @Override
    public void actionPerformed (ActionEvent e) {
        System.exit(0);
    }
}

// klasse for aa vise hvilken losning vi ser paa
class Viser implements ActionListener {
    static int losningNummer = 0;
    @Override
    public void actionPerformed (ActionEvent e) {
        // for aa kunne gaa fra siste til forste loesning igjen
        if (losningNummer == LabyrintGUI.losninger.size()) {
            for (Rute rute : LabyrintGUI.losninger.get(losningNummer - 1)) {
                rute.visk();
            }
            losningNummer = 0;
            for (Rute rute : LabyrintGUI.losninger.get(losningNummer)) {
                rute.utvei();
            }
            LabyrintGUI.antLosninger.setText("Viser loesning:" + (losningNummer + 1) + " av " + LabyrintGUI.losninger.size());
            LabyrintGUI.antLosninger.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
            losningNummer++;
        }

        else {
            for (Rute rute : LabyrintGUI.losninger.get(losningNummer - 1)) {
                rute.visk();
            }
            for (Rute rute : LabyrintGUI.losninger.get(losningNummer)) {
                rute.utvei();
            }
            LabyrintGUI.antLosninger.setText("Viser loesning:" + (losningNummer + 1) + " av " + LabyrintGUI.losninger.size());
            LabyrintGUI.antLosninger.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
            losningNummer++;
        }
    }
}