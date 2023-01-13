public class Pasient{
    protected String navn;
    protected String fodselsnummer;
    protected Stabel<Resept> reseptStabel;

    // konstruktoer skal bare ta inn navn og fodselsnummer
    public Pasient(String navn, String fodselsnummer){
        this.navn = navn;
        this.fodselsnummer = fodselsnummer;
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

    @Override
    //vil ha enkel utskrift av info
    public String toString(){
        return "Pasient ved navn: " + this.navn + "fnr(" + this.fodselsnummer + ")";
    }
}