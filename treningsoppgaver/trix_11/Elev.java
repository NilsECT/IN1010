import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Elev implements Runnable {
    private Random ran = new Random();
    private Teller teller;
    private CountDownLatch nedTeller;

    public Elev(Teller teller, CountDownLatch nedTeller){
        this.teller = teller;
        this.nedTeller = nedTeller;
    }

    public void run(){
        boolean stemme = ran.nextBoolean();
        if (stemme){
            this.teller.bleTrue();
        }
        else {
            this.teller.bleFalse();
        }
        
        nedTeller.countDown();
    }
}
