public class MilitaerResept extends HvitResept {
    // resept for vernepliktige i tjeneste
    // disse gir 100% rabatt

    // konstruktøren er lik som HvitResept
    public MilitaerResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    // her er det en endring på prisen
    // 100% rabatt betyr ingenting å betale
    // gjør en override for kompilatoren og oversiktlighet
    @Override
    public double prisAaBetale(){
        return 0;
    }

    // gjør en override på toString() for å kunne hente ut info enkelt
    @Override
    public String toString(){
        String info = "Resept av farge: " + farge() + ".\n";
        info += "Type " + farge() + " resept: Militæresept.\n";
        info += "ID: " + id + ".\n";
        info += "Utskrevet for pasient med id: " + pasientId + ".\n";
        info += "Resept for legemiddel: " + legemiddel.hentNavn() + ".\n";
        info += "Legen som har skrevet ut reseptet er: " + utskrivendeLege.hentNavn() + ".\n";
        info += "Har " + reit + " bruk igjen.\n";
        info += "Gir rabatt på 100%.";
        return info;
    }
}
