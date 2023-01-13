public class Spesialist extends Lege implements Godkjenningsfritak {
    // kan skrive ut resept for narkostiske legemiddler
    
    protected int kontrollId;

    // legger til id-en til spesialisten i den satiske kontrollIdListe
    public Spesialist(String navn, int kontrollId){
        super(navn);
        this.kontrollId = kontrollId;
    }

    // henter ut id-en til spesialisten
    @Override
    public int hentKontrollID(){
        return kontrollId;
    }

    // skriver ut et vanlig resept
    // sjekker kontrollId om det er et narkotisk legemiddel
    @Override
    public Resept skrivResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        return new HvitResept(legemiddel, this, pasient, reit);
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






    // lager ekstra metoder for de andre typene resepter
    // unødvendig, men gir en følelse av kompletthet

    // henter ut en ny blå resept (75% rabatt)
    // sjekker kontrollId om det er et narkotisk legemiddel
    @Override
    public Resept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) {
        return new BlaaResept(legemiddel, this, pasient, reit);
    }

    // henter ut en ny militær resept (100% rabatt)
    // sjekker kontrollId om det er et narkotisk legemiddel
    @Override
    public Resept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) {
        return new MilitaerResept(legemiddel, this, pasient, reit);
    }

    // henter ut en ny prevensjons resept (108kr rabatt og kun 3 reit)
    // sjekker kontrollId om det er et narkotisk legemiddel
    @Override
    public Resept skrivPResept(Legemiddel legemiddel, Pasient pasient) {
        return new PResept(legemiddel, this, pasient);
    }
}
