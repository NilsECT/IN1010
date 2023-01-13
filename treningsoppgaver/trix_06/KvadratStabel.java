public class KvadratStabel {
    private Node start;

    private class Node {
        Node neste = null;
        Kvadrat data;
    
        public Node(Kvadrat x) {
            data = x;
        }
    }

    public boolean erTom(){
        return start == null;
    }

    public void leggPaa(Kvadrat kvadrat){
        if (erTom()){
            start = new Node(kvadrat);
        }
        else {
            Node temp = start;
            start = new Node(kvadrat);
            start.neste = temp;
        }
    }

    public Kvadrat taAv(){
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
