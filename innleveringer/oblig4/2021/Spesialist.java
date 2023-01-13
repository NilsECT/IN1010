public class Spesialist extends Lege implements Godkjenningsfritak {
    // kan skrive ut resept for narkostiske legemiddler
    
    protected String kontrollId;

    // legger til id-en til spesialisten i den satiske kontrollIdListe
    public Spesialist(String navn, String kontrollId){
        super(navn);
        this.kontrollId = kontrollId;
    }

    // henter ut id-en til spesialisten
    @Override
    public String hentKontrollID(){
        return kontrollId;
    }

    // endrer toString() for at den skal gi relevant info for objektet
    @Override
    public String toString(){
        String info = "Spesialist (Lege) med navn: " + hentNavn() + ".\n";
        info += "ID: " + id + ".\n";
        info += "KontrollID: " + hentKontrollID() + ".\n";
        info += "Kan lage resepter for narkostiske legemiddler.";
        return info;
    }
}
