import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LesGeometri {
    
    public static void main(String[] args) {
        JFrame vindu = new JFrame("Lese Grometri");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        ArrayList<Geometrisk> tegninger = lesFil();
        Grafisk tegning = new Grafisk(tegninger);
        panel.add(tegning);

        vindu.pack();
        vindu.setVisible(true);
    }

    static ArrayList<Geometrisk> lesFil() {
        JFileChooser velger = new JFileChooser();
        int resultat = velger.showOpenDialog(null);
        if (resultat != JFileChooser.APPROVE_OPTION) {
            System.exit(1);
        }

        File fil = velger.getSelectedFile();
        Scanner leser = null;

        try {
            leser = new Scanner(fil);
        }
        catch (FileNotFoundException e){
            System.exit(1);
        }

        ArrayList<Geometrisk> ting = new ArrayList<>();

        String form = "";
        while (leser.hasNextLine()) {
            String linje = leser.nextLine();
            if (linje.equals("# Rectangles") || linje.equals("# Circles")) {
                form = linje;
            }
            else if (form.equals("# Rectangles")) {
                ting.add(new Rektangel(linje));
            }
            else {
                ting.add(new Sirkel(linje));
            }
        }

        return ting;
    }
}

class Grafisk extends JComponent {
    ArrayList<Geometrisk> elementer;

    Grafisk(ArrayList<Geometrisk> elem) {
        elementer = elem;
        setPreferredSize(new Dimension(Geometrisk.maxX+10, Geometrisk.maxY+10));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Geometrisk e : elementer) {
            e.tegn(g2);
        }
    }
}

class Sirkel extends Geometrisk {
    int xPos;
    int yPos;
    int radius;

    Sirkel(String s) {
        String[] info = s.split(" ");
        xPos = Integer.parseInt(info[0]);
        yPos = Integer.parseInt(info[1]);
        radius = Integer.parseInt(info[2]);

        maxX = Math.max(maxX, xPos + (2*radius));
        maxY = Math.max(maxY, yPos + (2*radius));

        if (info.length > 3) {
            farge = info[3];
        }
    }

    @Override
    void tegn(Graphics2D g2) {
        velgFarge(g2);
        g2.drawOval(xPos, yPos, 2*radius, 2*radius);
    }
}

class Rektangel extends Geometrisk {
    int xPos;
    int yPos;
    int bredde;
    int hoyde;

    Rektangel (String s) {
        String[] info = s.split(" ");
        xPos = Integer.parseInt(info[0]);
        yPos = Integer.parseInt(info[1]);
        bredde = Integer.parseInt(info[2]);
        hoyde = Integer.parseInt(info[3]);

        maxX = Math.max(maxX, xPos + bredde);
        maxY = Math.max(maxY, yPos + hoyde);

        if (info.length > 4) {
            farge = info[4];
        }
    }

    @Override
    void tegn(Graphics2D g2) {
        velgFarge(g2);
        g2.drawRect(xPos, yPos, bredde, hoyde);
    }
}

abstract class Geometrisk {
    static int maxX = 0;
    static int maxY = 0;

    String farge = "";

    abstract void tegn(Graphics2D g2);

    void velgFarge (Graphics g2) {
        if (farge.equals("BLUE")) {
            g2.setColor(Color.BLUE);
        }
        else if (farge.equals("RED")) {
            g2.setColor(Color.RED);
        }
        else {
            g2.setColor(Color.BLACK);
        }
    }
}