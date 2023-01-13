public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {

    @Override
    // setter inn elementer fra minst til storst
    public void leggTil(T x){
        Node<T> ny = new Node<>(x);

        // hvis listen er tom settes forste og siste til aa peke paa ny
        if (lengde == 0){
            this.forste = ny;
            this.siste = ny;
        }

        // hvis ny er storre eller lik det siste byttes det siste
        else if (this.siste.data.compareTo(ny.data) <= 0){
            this.siste.neste = ny;
            ny.forrige = this.siste;
            this.siste = ny;
        }

        // hvis det nyet elementet er mindre eller lik det forste
        else if (this.forste.data.compareTo(ny.data) > 0){
            Node<T> temp = this.forste;
            ny.neste = this.forste;
            this.forste = ny;
            temp.forrige = ny;
        }

        // hvis forste < ny < siste
        else {
            Node<T> teller = this.forste;
            for (int i = 0; i < lengde; i++){

                // hvis ny er mindre enn telleren
                if (teller.data.compareTo(ny.data) > 0){
                    teller.forrige.neste = ny;
                    ny.forrige = teller.forrige;
                    teller.forrige = ny;
                    ny.neste = teller;
                    
                    break;
                }
                else {
                    teller = teller.neste;
                }
            }
        }

        lengde++;
    }

    @Override
    // fjerner det storste elementet
    public T fjern() throws UgyldigListeIndeks {
        Node<T> temp = this.siste;

        if (lengde == 0){
            throw new UgyldigListeIndeks(-1);
        }

        // hvis det bare er ett element
        else if (lengde == 1){
            this.forste = null;
            this.siste = null;
        }

        // det er det siste elemntet som er storst
        else {
            this.siste = this.siste.forrige;
            this.siste.neste = null;
        }

        lengde--;
        return temp.data;
    }

    @Override
    public void sett(int pos, T x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void leggTil(int pos, T x) {
        throw new UnsupportedOperationException();
    }
}
