public class ArrayListe implements Liste<T> {
    private T[] data = new T[10];
    private int iBruk = 0;
}

/**
 * Kan ikke bruke new T[10] selv om det burde være lovlig.
 * Det er en feil i Java selv.
 * Eler... egentlig ikke:
 */

 class ArrayListe<T> implements Liste<T> {
    @SupressWarnigns("unchecked")   // vil ikke bli advart for det barbariske neste linje gjør
    private T[] data = (T[]) new Object[10];    // lol get rekt
    private int iBruk = 0;

    public void set(int pos, T x) {
        data[pos] = x;
    }

    public T get(int pos){
        return data[pos];
    }

    public int size(){
        return iBruk;
    }

    public T remove(int pos){
        T res = data[pos];
        for (int i = pos+1; i < iBruk; i++){
            data[i-1] = data[i];
        }
        iBruk--;
        return res;
    }

    public void add(T x){
        if (iBruk == data.length){
            @SuppressWarnings("unchecked")
            T[] ny = (T[]) new Object[2*iBruk];

            for ( int i = 0; i < iBruk; i++){
                ny[i] = data[i]
            }
            data = ny
        }
        data[iBruk] = x;
        iBruk++;
    }
 }
