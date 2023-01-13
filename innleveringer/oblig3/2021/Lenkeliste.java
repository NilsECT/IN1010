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

    // setter inn noden med elementet i en gitt posisjon og erstatter det forrige
    public void sett(int pos, T x) throws UgyldigListeIndeks {
        Node<T> teller = this.forste;
        Node<T> ny = new Node<>(x);

        // behandler ikke pos == 0 og pos == lengde
        if (pos < lengde && pos > 0){
            for (int i = 0; i < lengde; i++){
                if (i == pos){
                    teller.forrige.neste = ny;
                    teller.neste.forrige = ny;
                    ny.neste = teller.neste;
                    ny.forrige = teller.forrige;

                    return;
                }
                else {
                    teller = teller.neste;
                }
            }
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

    // sniker inn noden med det nye elementet i onsket plass
    // plassene etter blir flyttet i forhold
    public void leggTil(int pos, T x) throws UgyldigListeIndeks {
        Node<T> teller = this.forste;
        Node<T> ny = new Node<>(x);

        // tar ikke med tilfellet hvis pos == 0
        // tar det i en else if
        if (pos < lengde && pos > 0){
            for (int i = 0; i < lengde; i++){
                if (i == pos){
                    Node<T> temp = teller.forrige;
                    temp.neste = ny;
                    ny.forrige = temp;
                    ny.neste = teller;
                    teller.forrige = ny;
                    

                    lengde++;
                    return;
                }
                else {
                    teller = teller.neste;
                }
            }
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

    // fjerner et element som er i en bestemt posisjon
    public T fjern(int pos) throws UgyldigListeIndeks {
        Node<T> teller = this.forste;

        // hvis elementet er ett sted mellom to elementer
        if (pos < lengde -1 && pos > 0){
            int i = 0;
            while (i < pos){
                teller = teller.neste;
                i++;
            }

            // hvorfor funker ikke dette?
            // for (int i = 0; i == pos; i++){
            //     teller = teller.neste;
            //     System.out.println("her");
            // }

            // kan hende den neste er den siste
            // da oppdaterer vi den siste
            
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

    public T hent(int pos) throws UgyldigListeIndeks {
        Node<T> teller = this.forste;
        for (int i = 0; i < lengde; i++){
            if (i == pos){
                return teller.data;
            }
            else {
                teller = teller.neste;
            }
        }

        throw new UgyldigListeIndeks(pos);
    }

    @Override
    // lager en toString()
    public String toString(){
        String liste = "";

        Node<T> teller = forste;

        // setter inn dataen fra hver node i liste
        for (int i = 0; i < lengde; i++){
            liste += teller.data + "\n";
            teller = teller.neste;
        }

        return liste;
    }
}
