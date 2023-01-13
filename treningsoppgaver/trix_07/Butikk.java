import java.util.Iterator;

public class Butikk implements Iterable<Person> {
    private Person forste;
    private int antKunder = 0;

    public void entreButikk(Person person){
        Person teller = forste;
        if (this.forste == null){
            this.forste = person;
        }
        else {
            while (teller.hentNeste() != null){
                teller = teller.hentNeste();
            }
            teller.settNeste(person);
        }
        antKunder++;
    }

    public void kassa(){
        Person teller = forste;
        while (teller != null){
            System.out.println("Behandler: " + teller.navn + " som kjøper " + teller.objekt);
            System.out.println("snakkes!");
            teller = teller.hentNeste();
        }
        antKunder = 0;
    }

    public Iterator<Person> iterator(){
        return new PersonIterator();
    }

    class PersonIterator implements Iterator<Person>{
        private Person gjeldendeKunde;

        public PersonIterator(){
            gjeldendeKunde = forste;
        }

        @Override
        public boolean hasNext(){
            return gjeldendeKunde != null;
        }

        @Override
        public Person next(){
            Person mid = gjeldendeKunde;
            gjeldendeKunde = gjeldendeKunde.hentNeste();
            return mid;
        }
    }
}
