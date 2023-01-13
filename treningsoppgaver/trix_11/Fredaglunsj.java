import java.util.concurrent.CountDownLatch;

public class Fredaglunsj {

    public static void main(String[] args){
        Teller teller = new Teller();
        int antElever = Integer.parseInt(args[0]);
        CountDownLatch nedTeller = new CountDownLatch(antElever);

        for (int i = 0; i < antElever; i++){
            Thread traad = new Thread(new Elev(teller, nedTeller));
            traad.start();
        }

        try {
            nedTeller.await();
        }
        catch (InterruptedException e){
            e.getMessage();
        }

        System.out.println(teller.hentResultat());
    }
}