public abstract class Kjoretoy {
    protected String registreringsnummer;
    protected String fabrikkmerke;
    protected String eier;

    public Kjoretoy(String registreringsnummer, String fabrikkmerke, String eier){
        this.registreringsnummer = registreringsnummer;
        this.fabrikkmerke = fabrikkmerke;
        this.eier = eier;
    }

    public void skrivInfo(){
        System.out.println("Kjoretoy: " + registreringsnummer + "\nMerke: " + fabrikkmerke + "\nEier: " + eier + "\n");
    }

    public String hentRegistreringsnummer(){
        return registreringsnummer;
    }

    public String hentFabrikkmerke(){
        return fabrikkmerke;
    }

    public String hentEier(){
        return eier;
    }

    public abstract double hentAarsavgift();
}
