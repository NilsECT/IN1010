public class Lege implements Comparable<Lege>{
    // kan ikke skrive ut resept for narkotiske legemiddler

    protected String navn;

    // Lenkeliste for aa holde styr paa respeter til legen
    protected Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<>();

    // trengs for aa lage unike id-er til legene
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


    // endrer toString() for at den skal gi relevant info for objektet
    @Override
    public String toString(){
        String info = "Lege med navn: " + hentNavn() + ".\n";
        info += "ID: " + id + "\n";
        info += "Kan ikke lage resepter for narkostiske legemiddler.";
        return info;
    }

    // bruker compareTo for String som allerede finnes
    // skal jeg bruke noe annet?
    public int compareTo(Lege annen){
        return this.navn.compareTo(annen.navn);
    }

    // metode for aa hente ut reseptlisten til legen
    public Lenkeliste<Resept> hentUtsrevedeResepter(){
        return utskrevedeResepter;
    }

    // gjor oppgave D3, men den for grupper
    // lager altsaa individuelle metoder for hver type resept

    // HvitResept
    public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {

            // sjekker om legen er Spesialist
            // likt i alle skrivResept-metodene
            if (this instanceof Spesialist){
                HvitResept ny = new HvitResept(legemiddel, this, pasient, reit);
                utskrevedeResepter.leggTil(ny);
                pasient.leggTilResept(ny);
                return ny;
            }
            else {
                throw new UlovligUtskrift(this, legemiddel);
            }
        }
        else {
            HvitResept ny = new HvitResept(legemiddel, this, pasient, reit);
            utskrevedeResepter.leggTil(ny);
            pasient.leggTilResept(ny);
            return ny;
        }
    }

    // BlaaResept
    public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            if (this instanceof Spesialist){
                BlaaResept ny = new BlaaResept(legemiddel, this, pasient, reit);
                utskrevedeResepter.leggTil(ny);
                pasient.leggTilResept(ny);
                return ny;
            }
            else {
                throw new UlovligUtskrift(this, legemiddel);
            }
        }
        else {
            BlaaResept ny = new BlaaResept(legemiddel, this, pasient, reit);
            utskrevedeResepter.leggTil(ny);
            pasient.leggTilResept(ny);
            return ny;
        }
    }

    // militaerResept
    public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            if (this instanceof Spesialist){
                MilitaerResept ny = new MilitaerResept(legemiddel, this, pasient, reit);
                utskrevedeResepter.leggTil(ny);
                pasient.leggTilResept(ny);
                return ny;
            }
            else {
                throw new UlovligUtskrift(this, legemiddel);
            }
        }
        else {
            MilitaerResept ny = new MilitaerResept(legemiddel, this, pasient, reit);
            utskrevedeResepter.leggTil(ny);
            pasient.leggTilResept(ny);
            return ny;
        }
    }

    // P-Resept
    public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            if (this instanceof Spesialist){
                PResept ny = new PResept(legemiddel, this, pasient);
                utskrevedeResepter.leggTil(ny);
                pasient.leggTilResept(ny);
                return ny;
            }
            else {
                throw new UlovligUtskrift(this, legemiddel);
            }
        }
        else {
            PResept ny = new PResept(legemiddel, this, pasient);
            utskrevedeResepter.leggTil(ny);
            pasient.leggTilResept(ny);
            return ny;
        }
    }
}
