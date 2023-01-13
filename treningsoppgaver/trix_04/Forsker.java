public class Forsker extends Ansatt {
    protected String fagomraade;

    public Forsker(String navn, int alder, float timelonn, String fagomraade){
        super(navn, alder, timelonn);
        this.fagomraade = fagomraade;
    }

    public void skrivInformasjon(){
        System.out.println("Forsker:");
        System.out.println("Navn: " + navn + "\nAlder: " + alder);
        System.out.println("Timelønn: " + timelonn + "\nFagområde: " + fagomraade);
    }


}
