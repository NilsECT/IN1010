public class Person implements Comparable<Person>{
    protected String navn;
    protected int fnr;
    protected Person mor;
    protected Person far;

    public Person(int fnr, String navn, Person mor, Person far){
        this.navn = navn;
        this.fnr = fnr;
        this.mor = mor;
        this.far = far;
    }

    public Person finnEldsteKjenteForfader(){
        if (this.mor == null){
            if (this.far == null){
                return this;
            }
            else {
                return far.finnEldsteKjenteForfader();
            }
        }

        if (this.far == null){
            return mor.finnEldsteKjenteForfader();
        }

        Person morside = mor.finnEldsteKjenteForfader();
        Person farside = far.finnEldsteKjenteForfader();

        if (morside.compareTo(farside) < 0){
            return morside;
        }
        else {
            return farside;
        }
    }

    public String hentNavn(){
        return this.navn;
    }

    public int hentFNR(){
        return this.fnr;
    }

    public Person hentMor(){
        return this.mor;
    }

    public Person hentFar(){
        return this.far;
    }

    @Override
    public String toString(){
        return navn + " (" + fnr + ")";
    }

    @Override
    public int compareTo(Person annen){
        return this.fnr - annen.hentFNR();
    }
}
