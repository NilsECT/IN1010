public class Lege {
    // kan ikke skrive ut resept for narkotiske legemiddler

    protected String navn;


    // tregns for aa lage unike id-er til legene
    protected static int idTeller = 1;
    protected int id;

    
    // konstruktoren tar bare inn navnet til legen
    public Lege(String navn){
        this.navn = navn;
        id = idTeller;
        idTeller++;
    }

    // henter ut legens navn
    public String hentNavn(){
        return navn;
    }


    // endrer toString() for at den skal gi relevant info for objektet
    @Override
    public String toString(){
        String info = "Lege med navn: " + hentNavn() + ".\n";
        info += "ID: " + id + "\n";
        info += "Kan ikke lage resepter for narkostiske legemiddler.";
        return info;
    }
}
