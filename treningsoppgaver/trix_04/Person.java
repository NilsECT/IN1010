public abstract class Person {
    protected String navn;
    protected int alder;

    public Person(String navn, int alder){
        this.navn = navn;
        this.alder = alder;
    }

    public abstract void skrivInformasjon();
}
