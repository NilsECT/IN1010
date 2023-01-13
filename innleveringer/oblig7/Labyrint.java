import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Labyrint {
    private Rute[][] rutenett;
    private int kol;
    private int rad;
    private ArrayList<ArrayList<Rute>> samlingAvUtveier = new ArrayList<>();    // det som her er Rute var Tuppel i oblig6, dette er ogsaa endret i de andre klassene

    // konstruktor som kaster unntak videre
    public Labyrint(Scanner filnavn) throws FileNotFoundException {
        Scanner fil = filnavn;  // endret linje

        // henter ut ant rad og kolonner
        String[] radOgKol = fil.nextLine().split(" ");
        this.rad = Integer.parseInt(radOgKol[0]);
        this.kol = Integer.parseInt(radOgKol[1]);

        // gir rutenettet en strorrelse
        rutenett = new Rute[rad][kol];

        // i skal telle rader
        int i = 0;
        while (fil.hasNextLine()) {
            String linje = fil.nextLine();

            // ii teller kolonner
            for (int ii = 0; ii < kol; ii++) {
                // antar at alle tegnene for hvit og sort rute er lik i alle filene som leses in
                char tegn = linje.charAt(ii);

                // SETTER IN RUTETYPE FOERST

                // hvis det er en aapning blir den tatt og lagret foer det sjekkes om den er hvit eller sort
                if ((i == 0 || ii == 0 || i == rad - 1 || ii == kol - 1) && tegn == '.') {
                    rutenett[i][ii] = new Aapning(i, ii);
                }
                // hvis det ikke er en aapning er den enten sort eller hvit
                else if (tegn == '#') {
                    rutenett[i][ii] = new SortRute(i, ii);
                }
                else {
                    rutenett[i][ii] = new HvitRute(i, ii);
                }

                // GIR NABOER
                // naboer vil bli gitt "bakover" og "oppover"
                // det gis nabo hvis en rute (1) har en rute (2) over seg, vil (1) faa (2) som nordre nabo og (2) vil faa (1) som soendre nabo
                // hvis en rute (3) har en rute (4) "vest" for seg, vil (3) faa (4) som vestlig nabo og (4) vil faa (3) som oestlig nabo
                // det blir da ingen ruter igjen som ikke har fatt tildelt nodvendig nabo

                //hvis det er den aller forste settes det ikke noen naboer
                if (i == 0 && ii == 0) {
                    continue;
                }

                // hvis det er den forste raden settes det ikke nord eller syd naboer
                else if (i == 0) {
                    rutenett[i][ii].settVestNabo(rutenett[i][ii - 1]);
                    rutenett[i][ii - 1].settOestNabo(rutenett[i][ii]);
                }

                // hvis det er den forste i kolonnen settes og det ikke er forste rad settes det kun nord-syd naboer
                else if (ii == 0) {
                    rutenett[i][ii].settNordNabo(rutenett[i - 1][ii]);
                    rutenett[i - 1][ii].settSydNabo(rutenett[i][ii]);
                }

                // ellers settes alle naboer
                else {
                    // vest - oest
                    rutenett[i][ii].settVestNabo(rutenett[i][ii - 1]);
                    rutenett[i][ii - 1].settOestNabo(rutenett[i][ii]);

                    // nord - syd
                    rutenett[i][ii].settNordNabo(rutenett[i - 1][ii]);
                    rutenett[i - 1][ii].settSydNabo(rutenett[i][ii]);
                }
            }
            i++;
        }
    }

    // metode for aa sette inn en utvei naar en vei naar en Aapning-rute
    public void settUtvei(ArrayList<Rute> utvei) {
        samlingAvUtveier.add(utvei);
    }

    // parameter rekkefolgen er her diktert av oppgaveteksten
    // bruker rad for x-posisjon og kol for y-posisjon gjennom oppgaven ellers
    public ArrayList<ArrayList<Rute>> finnUtveiFra(int kol, int rad) {
        rutenett[rad][kol].finnUtvei(this);
        return samlingAvUtveier;
    }

    @Override
    // gjor det enklere aa printe ut labyrinten
    // bruker samme char som rutene inneholder
    public String toString() {
        return rekursivToString(0, 0, rutenett);
    }

    // lager en rekursiv metode fra en nested-forloop for trening
    private String rekursivToString(int i, int ii, Rute[][] rutenett) {
        String ut = "";

        // fyller inn en rad, om raden er fyllt hoppes det til else if
        if (ii < kol) {
            ut += rutenett[i][ii].tilTegn();
            return ut + rekursivToString(i, ii + 1, rutenett);
        }

        // hopper ned en rad og gaar tilbake til aa fylle opp raden
        // gjor slikt intill alle rader er fulle
        else if (i < rad && (i + 1) != rad) {
            ut += "\n";
            return ut + rekursivToString(i + 1, 0, rutenett);
        }

        // om alt er fullt skal det returneres en tom string
        else {
            return ut;
        }
    }


    // metoder for hente ut relevant info for GUI
    public int hentRad() {
        return this.rad;
    }

    public int hentKol() {
        return this.kol;
    }

    public Rute[][] hentRutenett() {
        return rutenett;
    }
}