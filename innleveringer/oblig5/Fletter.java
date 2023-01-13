import java.util.concurrent.CountDownLatch;
import java.util.ArrayList;
import java.util.HashMap;

public class Fletter implements Runnable {
    private Beholder beholder;
    private CountDownLatch latch;

    public Fletter(Beholder beholder, CountDownLatch latch) {
        this.beholder = beholder;
        this.latch = latch;
    }

    public void run(){
        // saa lengde det er mer enn to HashMap-er eller en Sekvensdeler driver aa jobber
        // while sjekker om det er mulig aa prove
        while (beholder.antHashMap() >= 2 || beholder.ferskeSubsekvenserSkalLeveres()) {
            ArrayList<HashMap<String, SubSekvens>> hentet = beholder.hentForFletting();

            if (hentet.isEmpty()) {
                continue;
            }

            HashMap<String, SubSekvens> flettet = new HashMap<>();

            HashMap<String, SubSekvens> en = hentet.get(0);
            HashMap<String, SubSekvens> to = hentet.get(1);
            // ser om de har noen like og plusser da antForekomster og legger den plussede i den nye HashMap-en
            // ellers legges de vanlig inn, men den den andre HashMap-en maa da kun sette sine unike subsekvenser
            for (String subEn : en.keySet()) {
                if (to.containsKey(subEn)) {
                    en.get(subEn).settAntForekomster(en.get(subEn).hentAntForekomster() + to.get(subEn).hentAntForekomster());
                }
                flettet.put(subEn, en.get(subEn));
            }
            for (String subTo : to.keySet()) {
                if (flettet.containsKey(subTo)){
                continue;
                }
                flettet.put(subTo, to.get(subTo));
            }
            beholder.settHashMap(flettet);
        }
        latch.countDown();
    }
}
