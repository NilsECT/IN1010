public abstract class Resept {
    
    // statisk teller for antall resepter som blir laget
    protected static int idTeller = 1;

    // id skal vaere unik for hver instans av Resept
    protected int id;

    protected Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    protected int pasientId;
    protected int reit;


    // konstruktor lager variabler og setter en unik id
    protected Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        id = idTeller;
        idTeller++;
    }

    // henter ut int id
    public int hentId(){
        return id;
    }

    // henter legemiddelet reseptet refererer til
    public Legemiddel hentLegemiddel(){
        return legemiddel;
    }

    // henter ut referansen til utskriftslegen
    public Lege hentLege(){
        return utskrivendeLege;
    }

    // henter ut int pasientid
    public int hentPasientId(){
        return pasientId;
    }

    // henter ut reit
    public int hentReit(){
        return reit;
    }

    // bruker reseptet én gang, returnerer true om den er brukt
    // om det ikke er flere bruk returnerer den false
    public boolean bruk(){
        if (reit > 0) {
            reit--;
            return true;
        }
        else {
            return false;
        }
    }

    // metode som skal defineres i de direkte subklassene
    // skal returnere fargen paa reseptet
    public abstract String farge();

    // metode som skal defineres i de direkte subklassene
    // skal returnere prisen som skal betales etter evt. rabatter
    public abstract int prisAaBetale();
}
