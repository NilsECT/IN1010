public class DobbelLenke<T> {
    private Node<T> forste;
    protected int antElement = 0;
    
    private class Node<T>{
        private Node<T> neste = null;
        private Node<T> forrige = null;
        private T data = null;

        public Node(T data){
            this.data = data;
        }
    }

    public void settInn(T element){
        Node<T> ny = new Node<>(element);
        if (antElement == 0){
            forste = ny;
        }
        else {
            Node<T> teller = forste;
            for (int i = 0; i < antElement; i++){
                if (teller.neste == null){
                    teller.neste = ny;
                    ny.forrige = teller;
                }
                else {
                    teller = teller.neste;
                }
            }
        }
        antElement++;
    }
}

