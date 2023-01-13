public class TestOrdBeholder {
    public static void main(String[] args){
        OrdBeholder ord = new OrdBeholder();


        // listen er tom, dette skal returnere null
        if (ord.pop() == null){
            System.out.println("Riktig 1");
        }
        else {
            System.out.println("Feil 1");
        }


        // setter inn et ord
        // siden listen er tom MÅ dette returnere true
        if (ord.settInn("Bil") == true){
            System.out.println("Riktig 2");
        }
        else {
            System.out.println("Feil 1");
        }

        // setter inn det samme ordet
        // burde returnere false
        if (ord.settInn("Bil") == false){
            System.out.println("Riktig 3");
        }
        else {
            System.out.println("Feil 3");
        }


        // to if-tester for to nye ord
        if (ord.settInn("Hus") == true && ord.settInn("Tre") == true){
            System.out.println("Riktig 4");
        }
        else {
            System.out.println("Feil 4");
        }

        // pop metoden skal nå returnere Tre
        if (ord.pop() == "Tre"){
            System.out.println("Riktig 5");
        }
        else {
            System.out.println("Feil 5");
        }

        // pop() burde returnere Tre igjen!
        if (ord.antallOrd() == 2){
            System.out.println("Riktig 6");
        }
        else {
            System.out.println("Feil 6");
        }
    }
}
