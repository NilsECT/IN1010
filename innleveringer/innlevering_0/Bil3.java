public class Bil3 {
    private String bilNummer;

    public Bil3(String bilNummer){
        this.bilNummer = bilNummer;
    }

    public void erBil(){
        System.out.println("Bilnummer: " + bilNummer);
    }

    public String hentNummer(){
        return bilNummer;
    }
}
