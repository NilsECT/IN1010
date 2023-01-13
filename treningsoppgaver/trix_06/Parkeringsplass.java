public class Parkeringsplass<E> {
    private E objekt;

    public void parker(E objekt){
        this.objekt = objekt;
    }

    public E ut(){
        E holder = this.objekt;
        objekt = null;
        return holder;
    }
}
