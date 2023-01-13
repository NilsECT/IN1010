public class Buss extends Kjoretoy {
    protected int antPlasser;

    public Buss(String registreringsnummer, String fabrikkmerke, String eier, int antPlasser){
        super(registreringsnummer, fabrikkmerke, eier);
        this.antPlasser = antPlasser;
    }

    @Override
    public void skrivInfo(){
        System.out.println("Buss: " + registreringsnummer + "\nMerke: " + fabrikkmerke + "\nEier: " + eier);
        System.out.println("Plasser: " + antPlasser + "\n");
    }

    public double hentAarsavgift(){
        return 0.0;
    }
}
