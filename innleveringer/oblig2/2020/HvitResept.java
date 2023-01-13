public class HvitResept extends Resept {
    // vanlig resept

    // lik konstruktør som Resept
    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    // skal gi fargen til reseptet
    public String farge(){
        return "Hvit";
    }

    // gir prisen på en vanlig resept, her uten rabatter
    // prisen hentes fra legemiddelet som blir referert til i konstruktøren
    public double prisAaBetale(){
        return legemiddel.pris;
    }

    // gjør en override på toString() for å kunne hente ut info enkelt
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
