class Bil {
    private static int total = 0;
    private String eier;
    private int antForesporsler = 0;

    public Bil(String navn) {
        eier = navn;
    }
    public static int finnTotal() {
        return total;
    }
    public void foresporsel(){
        antForesporsler ++;
        total ++;
    }
    public int finnAntForesp(){
        return antForesporsler;
    }
}
