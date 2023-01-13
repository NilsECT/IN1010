import java.util.Iterator;

public class EnkelArrayListe implements Iterable<String> {
    private String[] array;
    private int antall = 0; 

    public EnkelArrayListe(int storrelse){
        array = new String[storrelse];
    }

    public void settInn(String element){
        if (antall == array.length){
            throw new IllegalStateException("Ikke plass til flere");
        }
        array[antall] = element;
        antall++;
    }

    public Iterator<String> iterator(){
        return new ListeIterator();
    }

    private class ListeIterator implements Iterator<String>{
        private int indeks = 0;

        @Override
        public boolean hasNext(){
            return indeks < antall;
        }

        @Override
        public String next(){
            return array[indeks++];
        }
    }
}
