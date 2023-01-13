import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MinRun implements Runnable {
    private final int slutt;
    private final int hopp;
    private int teller;
    private final Lock lock = new ReentrantLock();

    public MinRun(int start, int slutt, int hopp){
        this.slutt = slutt;
        this.hopp = hopp;
        this.teller = start;
    }
    public void run(){
        lock.lock();
        try{
            while (teller < slutt){
                System.out.println(teller);
                teller = teller + hopp;
            }
        }
        finally {
            lock.unlock();
        }
    }
}
