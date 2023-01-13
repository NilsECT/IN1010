public class HvitRute extends Rute {
    
    public HvitRute(int rad, int kol) {
        this.rad = rad;
        this.kol = kol;
    }

    public char tilTegn() {
        return '.';
    }

    public int hentKol() {
        return kol;
    }

    public int hentRad() {
        return rad;
    }

    // metoder for aa sette naboer
    public void settNordNabo(Rute nordNabo) {
        this.nordNabo = nordNabo;
    }

    public void settOestNabo(Rute oestNabo) {
        this.oestNabo = oestNabo;
    }

    public void settSydNabo(Rute sydNabo) {
        this.sydNabo = sydNabo;
    }

    public void settVestNabo(Rute vestNabo) {
        this.vestNabo = vestNabo;
    }

    @Override
    // skriver toString til aa returnere posisjonen og farge paa ruten
    public String toString() {
        return rad + " " + kol + " er hvit.";
    }
}
