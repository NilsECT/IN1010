import java.util.ArrayList;
import java.util.concurrent.locks.*;

public class BokstavMonitor {
    private ArrayList<String> ordListe;
    private char bokstav;
    private Lock laas = new ReentrantLock();

    public BokstavMonitor (ArrayList<String> ordListe, char bokstav) {
        this.ordListe = ordListe;
        this.bokstav = bokstav;
    }

    public String hentOrd(){
        laas.lock();
        try{
            if (ordListe.isEmpty()){
                return null;
            }
            else {
                return ordListe.remove(ordListe.size() - 1);
            }
        }
        finally {
            laas.unlock();
        }
    }

    public char hentBokstav(){
        return bokstav;
    }
}
