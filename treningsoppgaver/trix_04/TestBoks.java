public class TestBoks {
    public static void main(String[] args){
        Boks en = new Boks(10, 10, 10);
        Boks to = new Boks(10, 10, 0);

        if (en.beregnAreal() == 600){
            System.out.println("Riktig 1.1");
        }
        else {
            System.out.println("Feil 1.1");
        }

        if (en.beregnVolum() == 1000){
            System.out.println("Riktig 1.2");
        }
        else {
            System.out.println("Feil 1.2");
        }

        if (to.beregnAreal() == 200){
            System.out.println("Riktig 2.1");
        }
        else {
            System.out.println("Feil 2.1");
        }

        if (to.beregnVolum() == 0){
            System.out.println("Riktig 2.2");
        }
        else {
            System.out.println("Feil 2.2");
        }
    }
}
