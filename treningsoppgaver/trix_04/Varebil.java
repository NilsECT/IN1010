public class Varebil extends Bil {
    protected double maksVekt;

    public Varebil(String registreringsnummer, String fabrikkmerke, String eier, double maksVekt){
        super(registreringsnummer, fabrikkmerke, eier);
        this.maksVekt = maksVekt;
    }

    @Override
    public void skrivInfo(){
        System.out.println("Varebil: " + registreringsnummer + "\nMerke: " + fabrikkmerke + "\nEier: " + eier);
        System.out.println("Maksimal vekt: " + maksVekt + "\n");
    }

    public double hentAarsavgift(){
        return 4 * maksVekt;
    }
}
