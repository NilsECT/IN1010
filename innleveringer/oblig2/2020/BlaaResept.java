public class BlaaResept extends Resept {
    // spesiell resept


    // samme konstruktør som Resept
    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    // gir fargen på reseptet
    public String farge(){
        return "Blå";
    }

    // gir prisen å betale
    // rabatten er en konstant 75% kan da returnere prisen ganget med 0.25
    // prisen hentes ut av legemiddelet som er referert til i konstruktøren
    public double prisAaBetale(){
        return legemiddel.hentPris() * 0.25;
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
        info += "Gir rabatt på 75%.";
        return info;
    }
}
