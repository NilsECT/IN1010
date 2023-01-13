public class Lege implements Comparable<Lege> {
    // kan ikke skrive ut resept for narkotiske legemiddler

    protected String navn;

    // utvidder klassen med en instans
    // for aa holde styr paa hvilke respeter legen har skrevet ut
    protected Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<>();

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

    // else{} setter reseptet som ble skrevet ut i utskrevedeResepter
    // setter det ogsaa i resept-stabelen til pasienten

    public Resept skrivResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this, legemiddel);
        }
        else {
            Resept ny = new HvitResept(legemiddel, this, pasient, reit);
            utskrevedeResepter.leggTil(ny);
            pasient.leggTilResept(ny);
            return ny;
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

    // alle else{} setter reseptet som ble skrevet ut i utskrevedeResepter
    // setter det ogsaa i resept-stabelen til pasienten

    // henter ut en ny blå resept (75% rabatt)
    // sjekker kontrollId om det er et narkotisk legemiddel
    public Resept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this, legemiddel);
        }
        else {
            Resept ny = new BlaaResept(legemiddel, this, pasient, reit);
            utskrevedeResepter.leggTil(ny);
            pasient.leggTilResept(ny);
            return ny;
        }
    }

    // henter ut en ny militær resept (100% rabatt)
    // sjekker kontrollId om det er et narkotisk legemiddel
    public Resept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this, legemiddel);
        }
        else {
            Resept ny = new MilitaerResept(legemiddel, this, pasient, reit);
            utskrevedeResepter.leggTil(ny);
            pasient.leggTilResept(ny);
            return ny;
        }
    }

    // henter ut en ny prevensjons resept (108kr rabatt og kun 3 reit)
    // sjekker kontrollId om det er et narkotisk legemiddel
    public Resept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this, legemiddel);
        }
        else {
            Resept ny = new PResept(legemiddel, this, pasient);
            utskrevedeResepter.leggTil(ny);
            pasient.leggTilResept(ny);
            return ny;
        }
    }

    // jobber nå med Comparable<Lege>
    // skal sorteres i alfabetisk rekkefølge

    // bruker comparTo for String som allerede finnes
    // skal jeg bruke noe annet?
    public int compareTo(Lege annen){
        return this.navn.compareTo(annen.navn);
    }

    // legger til en metode for aa hente ut listen av utskrevedeResepter
    public Lenkeliste<Resept> hentUtsrevedeResepter(){
        return utskrevedeResepter;
    }
}
