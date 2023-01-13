public class Professor extends Forsker{
    protected String kurs;

    public Professor(String navn, int alder, float timelonn, String fagomraade, String kurs){
        super(navn, alder, timelonn, fagomraade);
        this.kurs = kurs;
    }

    public void skrivInformasjon(){
        System.out.println("Professor:");
        System.out.println("Navn: " + navn + "\nAlder: " + alder);
        System.out.println("Timelønn: " + timelonn + "\nFagområde: " + fagomraade);
        System.out.println("Kurs: " + kurs);
    }
}
