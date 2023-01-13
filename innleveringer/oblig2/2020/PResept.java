public class PResept extends HvitResept {
    // prevensjonsresept
    // gir 108kr i rabatt, lavest mulig pris er 0

    // konstruktøren er lik HvitResept
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId){
        super(legemiddel, utskrivendeLege, pasientId, 3);
    }

    // det er en endring på pris
    // gjør en override for kompilatoren og oversiktilighet
    @Override
    public double prisAaBetale(){
        if (legemiddel.pris > 108){
            return legemiddel.pris - 108;
        }
        else {
            return 0;
        }
    }

    // gjør en override på toString() for å kunne hente ut info enkelt
    @Override
    public String toString(){
        String info = "Resept av farge: " + farge() + ".\n";
        info += "Type " + farge() + " resept: P-resept.\n";
        info += "ID: " + id + ".\n";
        info += "Utskrevet for pasient med id: " + pasientId + ".\n";
        info += "Resept for legemiddel: " + legemiddel.hentNavn() + ".\n";
        info += "Legen som har skrevet ut reseptet er: " + utskrivendeLege.hentNavn() + ".\n";
        info += "Har " + reit + " bruk igjen.\n";
        info += "Gir rabatt på 108kr.";
        return info;
    }
}
