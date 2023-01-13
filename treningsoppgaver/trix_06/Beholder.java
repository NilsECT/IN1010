public class Beholder<E> {
    private E figur;

    public void sett(E figur){
        this.figur = figur;
    }

    public E taUt(){
        return this.figur;
    }
}