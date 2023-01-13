public class Bokstaver {
    public static void main(String[] args){
        X x1 = (X) new Y();
        Y y1 = new Y();
        // Y y2 = new X();
        Y y3 = new Z();
        Z z1 = new Z();
        Z z2 = (Z) new X();
    }
}
