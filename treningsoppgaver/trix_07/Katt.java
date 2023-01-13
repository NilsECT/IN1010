public class Katt implements Comparable<Katt>{
    protected String navn;
    protected int alder;

    public Katt(String navn, int alder){
        this.navn = navn;
        this.alder = alder;
    }

    @Override
    public int compareTo(Katt andre) {
        /**
        if (this.alder < andre.alder){
            return -1;
        }
        else if (this.alder > andre.alder){
            return 1;
        }
        else {
            return 0;
        }
        */
        return this.alder - andre.alder;
    }

    @Override
    public String toString(){
        return "Navn: " + navn + ". Alder: " + alder;
    }
}