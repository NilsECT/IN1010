public class HvitResept extends Resept {
    // vanlig resept

    // lik konstruktor som Resept
    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    // skal gi fargen til reseptet
    public String farge(){
        return "hvit";
    }

    // gir prisen paa en vanlig resept, her uten rabatter
    // prisen hentes fra legemiddelet som blir referert til i konstruktoren
    public int prisAaBetale(){
        return legemiddel.pris;
    }

    // gjor en override paa toString() for aa kunne hente ut info enkelt
    @Override
    public String toString(){
        String info = "Resept av farge: " + farge() + ".\n";
        info += "ID: " + id + ".\n";
        info += "Utskrevet for pasient med id: " + pasientId + ".\n";
        info += "Resept for legemiddel: " + legemiddel.hentNavn() + ".\n";
        info += "Legen som har skrevet ut reseptet er: " + utskrivendeLege.hentNavn() + ".\n";
        info += "Har " + reit + " bruk igjen.\n";
        info += "Gir ingen rabatt.";
        return info;
    }
}
