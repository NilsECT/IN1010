import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tallmonitor{
    private int detMinste = Integer.MIN_VALUE;
    private int detStorste = Integer.MAX_VALUE;
    private Lock laas = new ReentrantLock();

    public boolean settMinste(int minste){
        laas.lock();
        try{
            if (minste >= detStorste){
                return false;
            }
            else {
                detMinste = minste;
                return true;
            }
        }
        finally {
            laas.unlock();
        }
    }

    public boolean settStorste(int storste){
        laas.lock();
        try{
            if (storste <= detMinste){
                return false;
            }
            else {
                detStorste = storste;
                return true;
            }
        }
        finally {
            laas.unlock();
        }
    }
}