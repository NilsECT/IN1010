public class GeneriskStabel<E> {
    private Node start;

    private class Node {
        Node neste = null;
        E data;
    
        public Node(E x) {
            data = x;
        }
    }

    public boolean erTom(){
        return start == null;
    }

    public void leggPaa(E noe){
        if (erTom()){
            start = new Node(noe);
        }
        else {
            Node temp = start;
            start = new Node(noe);
            start.neste = temp;
        }
    }

    public E taAv(){
        if (erTom()){
            return null;
        }
        else {
            Node temp = start;
            start = start.neste;
            return temp.data;
        }
    }
}
