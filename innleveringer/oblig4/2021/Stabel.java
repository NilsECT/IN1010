public class Stabel<T> extends Lenkeliste<T> {

    // legger på elementet på slutten
    // ved bruk av metodene av superklassen
    public void leggPaa(T x){
        if (lengde == 0){
            leggTil(x);
        }
        else {
            leggTil(this.lengde, x);
        }
    }

    // tar vekk siste elementet og returnerer det
    public T taAv() throws UgyldigListeIndeks {
        if (lengde == 0) {
            throw new UgyldigListeIndeks(-1);
        }
        else {
            return fjern(this.lengde - 1);
        }
    }
}
