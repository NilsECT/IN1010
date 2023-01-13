public class PResept extends HvitResept {
    // prevensjonsresept
    // gir 108kr i rabatt, lavest mulig pris er 0

    // konstruktoren er lik HvitResept
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId){
        super(legemiddel, utskrivendeLege, pasientId, 3);
    }

    // det er en endring paa pris
    // gjor en override for kompilatoren og oversiktilighet
    @Override
    public int prisAaBetale(){
        if (legemiddel.pris > 108){
            return legemiddel.pris - 108;
        }
        else {
            return 0;
        }
    }

    // gjor en override paa toString() for aa kunne hente ut info enkelt
    @Override
    public String toString(){
        String info = "Resept av farge: " + farge() + ".\n";
        info += "Type " + farge() + " resept: P-resept.\n";
        info += "ID: " + id + ".\n";
        info += "Utskrevet for pasient med id: " + pasientId + ".\n";
        info += "Resept for legemiddel: " + legemiddel.hentNavn() + ".\n";
        info += "Legen som har skrevet ut reseptet er: " + utskrivendeLege.hentNavn() + ".\n";
        info += "Har " + reit + " bruk igjen.\n";
        info += "Gir rabatt paa 108kr.";
        return info;
    }
}
