interface Liste {
    int size();
    void add(??? x);
    void set(int pos, ??? x);
    ??? get(int pos);
    ??? remove(int pos);
}
/**
 * ???:
kan bruke Object classen
den kan peke på alle mulige klasser
men den har en rar notasjon x.set10, ((String) x.get(10)) + "x");

klasseparametre/generiske klasser! <T>
*/

interface Liste<T> {
    int size();
    void add(T x);
    void set(int pos, T x);
    T get(int pos);
    T remove(int pos);

