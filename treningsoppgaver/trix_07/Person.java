public class Person {
    public String navn;
    public String objekt;
    public Person neste;

    public Person(String navn, String objekt){
        this.navn = navn;
        this.objekt = objekt;
    }

    public void settNeste(Person neste){
        this.neste = neste;
    }

    public Person hentNeste(){
        return neste;
    }

    @Override
    public String toString(){
        return "Navn: " + navn + "\nGjenstand: " + objekt;
    }
}
