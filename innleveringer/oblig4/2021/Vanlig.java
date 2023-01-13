public class Vanlig extends Legemiddel {
    // Preparat C
    
    public Vanlig(String navn, int pris, double virkestoff){
        super(navn, pris, virkestoff);
    }

    // overskriver toString metoden
    // skal nå printe ut informasjon om Preparatet
    @Override
    public String toString(){
        String info = "Vanlig legemiddel (PreparatC) med navn: " + navn + ".\n";
        info += "ID: " + id + ".\n";
        info += "Pris: " + pris + ".\n";
        info += "Virkestoff: " + virkestoff + ".";
        return info;
    }
}
