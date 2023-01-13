public class Bil {
    private int antPas;
    private String regNum;

    public Bil(String regNum, int antPas){
        this.antPas = antPas;
        this.regNum = regNum;
    }

    public String hentREgNum(){
        return this.regNum;
    }

    public int hentAntPas(){
        return antPas;
    }
}
