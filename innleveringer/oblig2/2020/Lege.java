public class Lege {
    // kan ikke skrive ut resept for narkotiske legemiddler

    protected String navn;


    // tregns for å lage unike id-er til legene
    protected static int idTeller = 1;
    protected int id;

    
    // konstruktøren tar bare inn navnet til legen
    public Lege(String navn){
        this.navn = navn;
        id = idTeller;
        idTeller++;
    }

    // henter ut legens navn
    public String hentNavn(){
        return navn;
    }

    // skriver ut et vanlig resept
    // sjekker kontrollId om det er et narkotisk legemiddel
    public Resept skrivResept(Legemiddel legemiddel, int pasientId, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this, legemiddel);
        }
        else {
            return new HvitResept(legemiddel, this, pasientId, reit);
        }
    }


    // endrer toString() for at den skal gi relevant info for objektet
    @Override
    public String toString(){
        String info = "Lege med navn: " + hentNavn() + ".\n";
        info += "ID: " + id + "\n";
        info += "Kan ikke lage resepter for narkostiske legemiddler.";
        return info;
    }








    // lager ekstra metoder for de andre typene resepter
    // unødvendig, men gir en følelse av kompletthet

    // henter ut en ny blå resept (75% rabatt)
    // sjekker kontrollId om det er et narkotisk legemiddel
    public Resept skrivBlaaResept(Legemiddel legemiddel, int pasientId, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this, legemiddel);
        }
        else {
            return new BlaaResept(legemiddel, this, pasientId, reit);
        }
    }

    // henter ut en ny militær resept (100% rabatt)
    // sjekker kontrollId om det er et narkotisk legemiddel
    public Resept skrivMilitaerResept(Legemiddel legemiddel, int pasientId, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this, legemiddel);
        }
        else {
            return new MilitaerResept(legemiddel, this, pasientId, reit);
        }
    }

    // henter ut en ny prevensjons resept (108kr rabatt og kun 3 reit)
    // sjekker kontrollId om det er et narkotisk legemiddel
    public Resept skrivPResept(Legemiddel legemiddel, int pasientId) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this, legemiddel);
        }
        else {
            return new PResept(legemiddel, this, pasientId);
        }
    }
}
