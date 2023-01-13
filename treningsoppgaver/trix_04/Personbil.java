public class Personbil extends Bil {
    protected int antPlasser;
    protected double aarsavgift = 3000;

    public Personbil(String registreringsnummer, String fabrikkmerke, String eier, int antPlasser){
        super(registreringsnummer, fabrikkmerke, eier);
        this.antPlasser = antPlasser;
    }

    @Override
    public void skrivInfo(){
        System.out.println("Personbil: " + registreringsnummer + "\nMerke: " + fabrikkmerke + "\nEier: " + eier);
        System.out.println("Antall plasser: " + antPlasser + "\n");
    }

    public double hentAarsavgift(){
        return aarsavgift;
    }
}
