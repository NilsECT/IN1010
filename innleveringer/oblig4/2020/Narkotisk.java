public class Narkotisk extends Legemiddel {
    // Preparat A

    // styrke er et tall for hvor narkotisk preparatet er
    protected int styrke;

    // konstruktøren skal også få inn styrken
    public Narkotisk(String navn, double pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    // gir ut den narkotiske styrken på preparatet
    public int hentNarkotiskStyrke(){
        return styrke;
    }


    // overskriver toString metoden
    // skal nå printe ut informasjon om Preparatet
    @Override
    public String toString(){
        String info = "Narkotisk (PreparatA) med navn: " + navn + ".\n";
        info += "ID: " + id + ".\n";
        info += "Pris: " + pris + ".\n";
        info += "Virkestoff: " + virkestoff + ".\n";
        info += "Narkotisk styrke: " + styrke + ".";
        return info;
    }
}
