public class Narkotisk extends Legemiddel {
    // Preparat A

    // styrke er et tall for hvor narkotisk preparatet er
    protected int styrke;

    // konstruktoren skal ogsaa faa inn styrken
    public Narkotisk(String navn, int pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    // gir ut den narkotiske styrken paa preparatet
    public int hentNarkotiskStyrke(){
        return styrke;
    }


    // overskriver toString metoden
    // skal naa printe ut informasjon om Preparatet
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
