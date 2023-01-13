public class HvitResept extends Resept {
    // vanlig resept

    // lik konstruktør som Resept
    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    // skal gi fargen til reseptet
    public String farge(){
        return "hvit";
    }

    // gir prisen på en vanlig resept, her uten rabatter
    // prisen hentes fra legemiddelet som blir referert til i konstruktøren
    public int prisAaBetale(){
        return legemiddel.pris;
    }

    // gjør en override på toString() for å kunne hente ut info enkelt
    @Override
    public String toString(){
        String info = "Resept av farge: " + farge() + ".\n";
        info += "ID: " + id + ".\n";
        info += "Utskrevet for pasient med id: " + pasient.fodselsnummer + ".\n";
        info += "Resept for legemiddel: " + legemiddel.hentNavn() + ".\n";
        info += "Legen som har skrevet ut reseptet er: " + utskrivendeLege.hentNavn() + ".\n";
        info += "Har " + reit + " bruk igjen.\n";
        info += "Gir ingen rabatt.";
        return info;
    }

    // ekstra for LegeSystem, metode for aa hente ut type
    public String hentType(){
        return "hvit";
    }
}
