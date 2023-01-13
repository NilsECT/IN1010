class TestBaathus {
    public static void main(String[] args){

        Baathus baathus = new Baathus(3);

        Baat b1 = new Baat("Neptune");
        Baat b2 = new Baat("Unsincable");
        Baat b3 = new Baat("Unsincable 2");
        Baat b4 = new Baat("Submarine");

        baathus.settInn(b1);
        baathus.settInn(b2);
        baathus.settInn(b3);
        baathus.settInn(b4);

        baathus.skrivInfo();
    }
}
