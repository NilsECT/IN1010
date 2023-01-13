import java.util.ArrayList;

abstract class Rute {
    protected int kol;
    protected int rad;
    protected Labyrint labyrint;

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

    // om ruten er brukt for aa finne en losning byttes dette til true i metoden brukt()
    protected boolean passert = false;

    // ArrayList som inneholder veien
    protected ArrayList<Tuppel> vei;

    // kaller paa gaa() til alle naboruter, denne endres ikke for hvite ruter
    protected void gaa(Labyrint labyrint, ArrayList<Tuppel> veiHittil){
        brukt();

        // setter in posisjonen i arrayen som blir lagret lokalt
        vei = new ArrayList<>(veiHittil);
        vei.add(new Tuppel(rad, kol));

        // gaar til en nabo som finnes og som ikke er en den har passert foer
        // den ruten den kommer fra tells som passert!
        if (nordNabo != null && !nordNabo.passert) {
            nordNabo.gaa(labyrint, vei);
        }
        if (oestNabo != null && !oestNabo.passert) {
            oestNabo.gaa(labyrint, vei);
        }
        if (sydNabo != null && !sydNabo.passert) {
            sydNabo.gaa(labyrint, vei);
        }
        if (vestNabo != null && !vestNabo.passert) {
            vestNabo.gaa(labyrint, vei);
        }
    }

    protected void finnUtvei(Labyrint labyrint){
        gaa(labyrint, new ArrayList<>());
    }

    // metode for aa si at ruten er brukt alt
    protected void brukt() {
        passert = true;
    }
}
