public class Vanedannende extends Legemiddel {
    // Preparat B

    // styrke er et tall for hvor vanedannende preparatet er
    protected int styrke;

    // konstruktoren skal ogsaa faa inn styrken
    public Vanedannende(String navn, int pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    // gir ut tallet paa hvor vanedannende det er
    public int hentVanedannendeStyrke(){
        return styrke;
    }

    // overskriver toString metoden
    // skal naa printe ut informasjon om Preparatet
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
