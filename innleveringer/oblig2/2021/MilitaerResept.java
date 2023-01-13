public class MilitaerResept extends HvitResept {
    // resept for vernepliktige i tjeneste
    // disse gir 100% rabatt

    // konstruktoren er lik som HvitResept
    public MilitaerResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    // her er det en endring paa prisen
    // 100% rabatt betyr ingenting aa betale
    // gjor en override for kompilatoren og oversiktlighet
    @Override
    public int prisAaBetale(){
        return 0;
    }

    // gjor en override paa toString() for aa kunne hente ut info enkelt
    @Override
    public String toString(){
        String info = "Resept av farge: " + farge() + ".\n";
        info += "Type " + farge() + " resept: Militaeresept.\n";
        info += "ID: " + id + ".\n";
        info += "Utskrevet for pasient med id: " + pasientId + ".\n";
        info += "Resept for legemiddel: " + legemiddel.hentNavn() + ".\n";
        info += "Legen som har skrevet ut reseptet er: " + utskrivendeLege.hentNavn() + ".\n";
        info += "Har " + reit + " bruk igjen.\n";
        info += "Gir rabatt paa 100%.";
        return info;
    }
}
