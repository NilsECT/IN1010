public class Stabel<T> extends Lenkeliste<T> {

    // legger på elementet på slutten
    public void leggPaa(T x){
        if (lengde == 0){
            leggTil(x);
        }
        else {
            Node<T> ny = new Node<>(x);
            ny.forrige = this.siste;
            this.siste.neste = ny;
            this.siste = ny;
            lengde++;
        }
    }

    // tar vekk siste elementet og returnerer det
    public T taAv() throws UgyldigListeIndeks {
        if (lengde == 0) {
            throw new UgyldigListeIndeks(-1);
        }
        else if (lengde == 1){
            Node<T> temp = this.siste;
            this.siste = null;
            this.forste = null;
            lengde--;
            return temp.data;
        }
        else {
            Node<T> temp = this.siste;
            this.siste = this.siste.forrige;
            this.siste.neste = null;
            lengde--;
            return temp.data;
        }
    }
}
