import java.util.concurrent.locks.*;

public class Teller {
    private int antTrue = 0;
    private int antFalse = 0;
    private Lock laas = new ReentrantLock();

    public void bleTrue(){
        laas.lock();
        try{
            antTrue++;
        }
        finally {
            laas.unlock();
        }
    }

    public void bleFalse(){
        laas.lock();
        try {
            antFalse++;
        }
        finally {
            laas.unlock();
        }
    }

    public String hentResultat(){
        if (antTrue > antFalse) {
            return "Pannekaker med " + antTrue + " stemmer av " + (antTrue + antFalse);
        }
        else if (antTrue < antFalse) {
            return "Grot med " + antFalse + " stemmer av " + (antTrue + antFalse);
        }
        else {
            return "Uavklart";
        }
    }
}
