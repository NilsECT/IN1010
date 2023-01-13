import java.util.concurrent.CountDownLatch;
import java.util.ArrayList;

public class OrdFinner implements Runnable {
    private CountDownLatch latch;
    private int start;
    private int slutt;
    private ArrayList<String> ordliste;
    private String ordSomSkalFinnes;
    private OrdTeller ordteller;

    public OrdFinner(int start, int slutt, ArrayList<String> ordliste, String ordSomSkalFinnes, OrdTeller ordteller, CountDownLatch latch){
        this.start = start;
        this.slutt = slutt;
        this.ordliste = ordliste;
        this.ordSomSkalFinnes = ordSomSkalFinnes;
        this.ordteller = ordteller;
        this.latch = latch;
    }

    public void run(){
        for (int i = this.start; i < this.slutt; i++){
            if (ordliste.get(i).equals(ordSomSkalFinnes)){
                ordteller.fantOrd();
            }
        }
        this.latch.countDown();
    }
}
