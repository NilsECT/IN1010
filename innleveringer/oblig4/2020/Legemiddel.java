public abstract class Legemiddel{
    //superklassen for Preparat A, B og C

    // idTeller går opp for gang et nytt Legemiddelobjekt blir lagd
    protected static int idTeller = 1;

    // id-en er unik for hver instanse
    protected int id;

    protected String navn;
    protected double pris;
    protected double virkestoff;


    // Konstruktør, lager variabler og gir en unik id
    protected Legemiddel(String navn, double pris, double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        id = idTeller;
        idTeller++;
    }

    // henter ut id-nummeret
    public int hentId(){
        return id;
    }

    // henter ut navnet
    public String hentNavn(){
        return navn;
    }

    // henter ut prisen
    public double hentPris(){
        return pris;
    }

    // henter ut virkestoff
    public double hentVirkestoff(){
        return virkestoff;
    }

    // erstatter gammel pris med en ny en
    public void settNyPris(double pris){
        this.pris = pris;
    }
}