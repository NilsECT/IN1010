public class Motorsykkel {
    private String regNum;
    private int kubikk;

    public Motorsykkel(String regNum, int kubikk){
        this.regNum = regNum;
        this.kubikk = kubikk;
    }

    public String hentRegNum(){
        return this.regNum;
    }

    public int hentKubikk(){
        return this.kubikk;
    }
}
