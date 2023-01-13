import java.util.concurrent.locks.*;

public class OrdTeller {
    private Lock laas = new ReentrantLock();
    private int antForekomster = 0;

    public int hentAntForekomster(){
        return this.antForekomster;
    }

    public void fantOrd(){
        laas.lock();
        try {
            antForekomster++;
        }
        finally {
            laas.unlock();
        }
    }
}
