import java.util.Arrays;

public class OrdSorterer implements Runnable {
    String[] ordFraFil;
    int start;
    int slutt;
    OrdMonitor ordmonitor;
    String[] ordliste;

    public OrdSorterer(String[] ordFraFil, int start, int slutt, OrdMonitor ordmonitor){
        this.ordFraFil = ordFraFil;
        this.start = start;
        this.slutt = slutt;
        this.ordmonitor = ordmonitor;
    }

    public void run(){
        String[] liste = Arrays.copyOfRange(this.ordFraFil, this.start, this.slutt);
        ordmonitor.sett(sortering(liste));
    }

    // sorterer listen fra minste ord til storste
    private String[] sortering(String[] liste){
        for (int i = 0; i < liste.length; i++){
            for (int ii = 0; ii < liste.length; ii++){
                if (liste[i].compareTo(liste[ii]) > 0){
                    String temp = liste[i];
                    liste[i] = liste[ii];
                    liste[ii] = temp;
                }
            }
        }
        return liste;
    }
}
