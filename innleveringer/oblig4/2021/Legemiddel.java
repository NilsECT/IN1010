public abstract class Legemiddel{
    //superklassen for Narkotisk, Vanedannende og Vanlig

    // idTeller går opp for gang et nytt Legemiddelobjekt blir lagd
    protected static int idTeller = 1;

    // id-en er unik for hver instanse
    protected int id;

    protected String navn;
    protected int pris;             // kr
    protected double virkestoff;    // mg


    // Konstruktør, lager variabler og gir en unik id
    protected Legemiddel(String navn, int pris, double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        id = idTeller;
        idTeller++;
    }

    // henter ut id-nummeret
    public int hentId(){
        return this.id;
    }

    // henter ut navnet
    public String hentNavn(){
        return this.navn;
    }

    // henter ut prisen
    public int hentPris(){
        return this.pris;
    }

    // henter ut virkestoff
    public double hentVirkestoff(){
        return this.virkestoff;
    }

    // erstatter gammel pris med en ny en
    public void settNyPris(int pris){
        this.pris = pris;
    }
}