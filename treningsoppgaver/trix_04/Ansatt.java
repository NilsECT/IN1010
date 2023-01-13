public abstract class Ansatt extends Person {
    protected float timelonn;

    public Ansatt(String navn, int alder, float timelonn){
        super(navn, alder);
        this.timelonn = timelonn;
    }

    public float hentTimelonn(){
        return timelonn;
    }
}
