public class GradigBeholder<T extends Comparable<T>> {
    private T objekt;

    public T settInn(T objekt){
        if (this.objekt == null){
            this.objekt = objekt;
            return null;
        }
        else if (this.objekt.compareTo(objekt) <= 0){
            T ut = this.objekt;
            this.objekt = objekt;
            return ut;
        }
        else {
            return objekt;
        }
    }

    public T seObjekt(){
        return this.objekt;
    }
}
