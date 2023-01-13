public class Pasient{
    protected String navn;
    protected String fodselsnummer;
    protected Stabel<Resept> reseptStabel = new Stabel<>();

    // trengs for aa lage unike id-er til pasienten
    // alle andre klasser har saa legger till her og
    protected static int idTeller = 1;
    protected int id;

    // konstruktoer skal bare ta inn navn og fodselsnummer
    public Pasient(String navn, String fodselsnummer){
        this.navn = navn;
        this.fodselsnummer = fodselsnummer;
        id = idTeller;
        idTeller++;
    }

    // legge til en resept
    public void leggTilResept(Resept resept){
        reseptStabel.leggPaa(resept);
    }

    // henter ut hele reseptlisten
    public Stabel<Resept> hentReseptStabel(){
        return reseptStabel;
    }

    // metode for aa hente navn
    public String hentNavn(){
        return this.navn;
    }

    // metode for aa hente fdnr
    public String hentFdr(){
        return this.fodselsnummer;
    }

    // henter ut id-en
    public int hentId(){
        return id;
    }

    @Override
    //vil ha enkel utskrift av info
    public String toString(){
        return "Pasient ved navn: " + this.navn + " med fnr(" + this.fodselsnummer + ")";
    }
}