public class Vanedannende extends Legemiddel {
    // Preparat B

    // styrke er et tall for hvor vanedannende preparatet er
    protected int styrke;

    // konstruktøren skal også få inn styrken
    public Vanedannende(String navn, double pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    // gir ut tallet på hvor vanedannende det er
    public int hentVanedannendeStyrke(){
        return styrke;
    }

    // overskriver toString metoden
    // skal nå printe ut informasjon om Preparatet
    @Override
    public String toString(){
        String info = "Vanedannende (PreparatB) med navn: " + navn + ".\n";
        info += "ID: " + id + ".\n";
        info += "Pris: " + pris + ".\n";
        info += "Virkestoff: " + virkestoff + ".\n";
        info += "Vanedannende styrke: " + styrke + ".";
        return info;
    }
}
