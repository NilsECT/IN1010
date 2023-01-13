public class Lenkeliste<T> implements Liste<T> {
    protected Node<T> forste;
    protected int lengde = 0;
    protected Node<T> siste;

    protected class Node<T> {
        protected Node<T> neste = null;
        protected Node<T> forrige = null;
        protected T data = null;
    
        public Node(T x) {
            this.data = x;
        }
    }

    // legger til på slutten av listen og setter siste til å peke direkte på den
    public void leggTil(T x){

        // lager noden som skal settes inn
        Node<T> ny = new Node<>(x);

        // hvis det ikke er noen element
        if (lengde == 0){
            this.forste = ny;
            this.siste = ny;
        }
        else {
            // setter siste til aa peke paa den nye noden
            // og faar den som var sist til aa peke paa siste
            // for den nest siste til aa bli forrige til siste
            ny.forrige = this.siste;
            this.siste.neste = ny;
            this.siste = ny;
        }

        this.lengde++;
    }

    // fjerner det siste elementet som ble lagt til
    public T fjern() throws UgyldigListeIndeks {
        if (lengde > 0){
            Node<T> temp = this.forste;
            this.forste = temp.neste;
            this.forste.forrige = null;

            this.lengde--;

            return temp.data;
        }
        else {
            throw new UgyldigListeIndeks(-1);
        }
    }

    public void rekursivSett(int pos, int teller, Node<T> node, Node<T> ny){
        if (pos == teller){
            node.forrige.neste = ny;
            node.neste.forrige = ny;
            ny.neste = node.neste;
            ny.forrige = node.forrige;
        }
        else {
            rekursivSett(pos, teller + 1, node.neste, ny);
        }
    }


    // setter inn noden med elementet i en gitt posisjon og erstatter det forrige
    public void sett(int pos, T x) throws UgyldigListeIndeks {
        Node<T> teller = this.forste;
        Node<T> ny = new Node<>(x);

        // behandler ikke pos == 0 og pos == lengde
        if (pos < lengde && pos > 0){
            rekursivSett(pos, 0, teller, ny);
        }
        
        else if (pos == lengde){
            throw new UgyldigListeIndeks(pos);
        }

        else if (pos == 0){
            ny.neste = this.forste.neste;
            this.forste.neste.forrige = ny;
            this.forste = ny;
        }

        else {
            throw new UgyldigListeIndeks(pos);
        }
    }

    public void rekursivLeggTil(int pos, int teller, Node<T> node, Node<T> ny){
        if (pos == teller){
            Node<T> temp = node.forrige;
                    temp.neste = ny;
                    ny.forrige = temp;
                    ny.neste = node;
                    node.forrige = ny;
                    
                    lengde++;
        }
        else {
            rekursivLeggTil(pos, teller + 1, node.neste, ny);
        }
    }

    // sniker inn noden med det nye elementet i onsket plass
    // plassene etter blir flyttet i forhold
    public void leggTil(int pos, T x) throws UgyldigListeIndeks {
        Node<T> teller = this.forste;
        Node<T> ny = new Node<>(x);

        // tar ikke med tilfellet hvis pos == 0
        // tar det i en else if
        if (pos < lengde && pos > 0){
            rekursivLeggTil(pos, 0, teller, ny);

        }

        // hvis listen er tom og onsket er aa sette iinn data i pos = 0
        // kan vi legge til paa begynnelsen
        else if (pos == lengde){

            // hvis lengde er 0 bruker vi leggtil(x)
            // hvis ikke betyr det at det er den siste plassen
            if (lengde == 0){
                leggTil(x);
            }
            else {
                this.siste.neste = ny;
                ny.forrige = this.siste;
                this.siste = ny;
                lengde++;
            }
        }

        // hvis pos == 0 kan vi ikke arbeide som om vi var i mellom to plasser
        else if (pos == 0) {
            this.forste.forrige = ny;
            ny.neste = this.forste;
            this.forste = ny;
            lengde++;
        }
        else {
        throw new UgyldigListeIndeks(pos);
        }
    }

    public Node<T> rekursivFjern(int pos, int teller, Node<T> node){
        if (teller == pos){
            return node;
        }
        else {
            return rekursivFjern(pos, teller + 1, node.neste);
        }
    }

    // fjerner et element som er i en bestemt posisjon
    public T fjern(int pos) throws UgyldigListeIndeks {
        Node<T> teller = this.forste;

        // hvis elementet er ett sted mellom to elementer
        if (pos < lengde -1 && pos > 0){

            teller = rekursivFjern(pos, 0, teller);
            
            Node<T> temp = teller.forrige;
            temp.neste = teller.neste;
            temp.neste.forrige = temp;

            lengde--;
            return teller.data;
        }

        // hvis det er snakk om forste element
        else if (pos == 0){

            // hvis lengden har mer enn ett element
            if (lengde > 1){
                this.forste = this.forste.neste;
                this.forste.forrige = null;
            }

            // hvis lengden bare har ett element
            else if (lengde == 1){
                this.forste = null;
                this.siste = null;
            }

            // hvis listen er tom
            else if (lengde == 0) {
                throw new UgyldigListeIndeks(pos);
            }
            lengde--;
            return teller.data;
        }

        // hvis det er snakk om siste element
        else if (pos == lengde -1){
            Node<T> temp = this.siste;
            this.siste = this.siste.forrige;
            this.siste.neste = null;
            lengde--;
            return temp.data;
        }
        else {
            throw new UgyldigListeIndeks(pos);
        }
    }

    // gir lengden paa listen
    public int stoerrelse(){
        return lengde;
    }

    public T rekursivHent(int pos, int teller, Node<T> node){
        if (pos == teller){
            return node.data;
        }
        else {
            return rekursivHent(pos, teller + 1, node.neste);
        }
    }

    public T hent(int pos) throws UgyldigListeIndeks {
        Node<T> teller = this.forste;

        if (pos < lengde && lengde > 0 && pos >= 0){
            return rekursivHent(pos, 0, teller);
        }
        else {
            throw new UgyldigListeIndeks(pos);
        }
    }

    public String rekursivToString(int pos, int maks, String liste, Node<T> node){
        if (pos == maks){
            String nyListe = liste;
            nyListe += node.data + "\n";
            return nyListe;
        }
        else {
            String nyliste = liste;
            nyliste += node.data + "\n";
            return rekursivToString(pos, maks, nyliste, node.neste);
        }
    }

    @Override
    // lager en toString()
    public String toString(){
        String liste = "";

        Node<T> teller = forste;

        liste = rekursivToString(0, lengde, liste, teller);
        
        // // setter inn dataen fra hver node i liste
        // for (int i = 0; i < lengde; i++){
        //     liste += teller.data + "\n";
        //     teller = teller.neste;
        // }

        return liste;
    }
}
