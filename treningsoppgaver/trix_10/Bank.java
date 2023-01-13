import java.util.concurrent.locks.*;

public class Bank {
    int belop;
    Lock laas = new ReentrantLock();

    public void ta(int belop){
        laas.lock();
        try{
            this.belop -= belop;
        }
        finally {
            laas.unlock();
        }
    }

    public void gi(int belop){
        laas.lock();
        try{
            this.belop += belop;
        }
        finally {
            laas.unlock();
        }
    }

    public int saldo(){
        return this.belop;
    }
}
