import java.util.HashMap;
import java.util.ArrayList;
import java.util.concurrent.locks.*;

public class Beholder {
    private ArrayList<HashMap<String, SubSekvens>> liste = new ArrayList<>();
    private Lock laas = new ReentrantLock();
    private int total;
    private int leverte;

    public Beholder(int total){
        this.total = total;
    }

    public void settHashMap(HashMap<String, SubSekvens> mappe) {
        // trenger ikke laas for aa sette inn, heller for aa ta ut
        liste.add(mappe);
    }

    // returnerer hvor mange HashMap-er det er i beholderen
    public int antHashMap(){
        laas.lock();
        try {
            return liste.size();
        }
        finally {
            laas.unlock();
        }
    }

    // returnerer og sletter HashMap-en, den skal returneres flettet tilbake til beholderen etterpaa
    public ArrayList<HashMap<String, SubSekvens>> hentForFletting() {
        // laaser for sikkerhetsskyld, trengs egentlig ikke siden det laases i Fletter
        laas.lock();
        try {
            ArrayList<HashMap<String, SubSekvens>> toForFletting = new ArrayList<>();
            if (liste.size() < 2) {
                return  toForFletting;
            }
            else {
                // det er noe som  stopper koden rundt dette + run metoden til fletter
                for (int i = 0; i < 2; i++) {
                    toForFletting.add(liste.remove(0));
                }
                return toForFletting;
            }
        }
        finally {
            laas.unlock();
        }
    }

    // sjekker om det fortsatt skal bli levert noen HashMap-er fra Sekvendeler
    public boolean ferskeSubsekvenserSkalLeveres(){
        laas.lock();
        try {
            if (leverte == total){
                return false;
            }
            else if (leverte < total) {
                return true;
            }
            else {
                System.out.println("Det leveres for mye fra Sekvensdeler.");
                return false;
            }
        }
        finally {
            laas.unlock();
        }
    }

    // teller hvor mye er blitt levert av Sekvensdeler
    public void ferskLevering(){
        laas.lock();
        try {
            leverte++;
        }
        finally {
            laas.unlock();
        }
    }

    // gir totalen som denne beholderen har
    public int hentTotal(){
        return total;
    }

    // metode for aa hente ut den ferdigflettede HashMap-en for aa sjekke statisktikk
    public HashMap<String, SubSekvens> hentFerdigFlettet() {
        return liste.get(0);
    }
}
