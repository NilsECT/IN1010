import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.*;

public class OrdMonitor implements Runnable {
    String[] sortertListe;
    int antLister = 0;
    Lock laas = new ReentrantLock();
    Condition klarTilFletting = laas.newCondition();
    int antTraader;
    CountDownLatch nedTeller;
    int antOrd;

    public OrdMonitor(int antOrd, int antTraader, CountDownLatch nedTeller){
        this.sortertListe = new String[antOrd];
        this.antTraader = antTraader;
        this.nedTeller = nedTeller;
        this.antOrd = antOrd;
    }

    public void sett(String[] sortertListeDel){
        laas.lock();
        try {
            if (sortertListe[0] == null){
                for (int i = 0; i < sortertListeDel.length; i++){
                    sortertListe[i] = sortertListeDel[i];
                }
            }
            else {
                int i = 0;
                while (sortertListe[i] != null){
                    i++;
                }
                for (int ii = 0; ii < sortertListeDel.length; ii++){
                    sortertListe[ii + i] = sortertListeDel[ii];
                }
            }
            antLister++;
            if (antLister > 1){
                klarTilFletting.signal();
            }
        }
        finally {
            laas.unlock();
        }
    }

    public void run(){
        laas.lock();
        try{
            for (int teller = 0; teller < antTraader; teller++){
                if (antLister <= 1){
                    klarTilFletting.await();
                }
                if (sortertListe.length != antOrd){
                    int i = 0;
                    while (sortertListe[i] != null){
                        i++;
                    }
                    for (int ii = 0; ii < i; ii++){
                        for (int iii = 0; iii < i; iii++){
                            if (sortertListe[ii].compareTo(sortertListe[iii]) > 0){
                                String temp = sortertListe[ii];
                                sortertListe[ii] = sortertListe[iii];
                                sortertListe[iii] = temp;
                            }
                        }
                    }
                }
                else {
                    for (int ii = 0; ii < sortertListe.length; ii++){
                        for (int iii = 0; iii < sortertListe.length; iii++){
                            if (sortertListe[ii].compareTo(sortertListe[iii]) > 0){
                                String temp = sortertListe[ii];
                                sortertListe[ii] = sortertListe[iii];
                                sortertListe[iii] = temp;
                            }
                        }
                    }
                }
            }
            nedTeller.countDown();
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        finally {
            laas.unlock();
        }
    }

    public String[] hentListe(){
        return this.sortertListe;
    }
}
