public class BlaaResept extends Resept {
    // spesiell resept


    // samme konstruktor som Resept
    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    // gir fargen paa reseptet
    public String farge(){
        return "blaa";
    }

    // gir prisen aa betale
    // rabatten er en konstant 75% kan da returnere prisen ganget med 0.25
    // prisen hentes ut av legemiddelet som er referert til i konstruktoren
    public int prisAaBetale(){
        return (int) Math.round(legemiddel.hentPris() * 0.25);
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
        info += "Gir rabatt paa 75%.";
        return info;
    }
}
