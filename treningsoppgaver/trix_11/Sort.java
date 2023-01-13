import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Sort {
    public static void main(String[] args){
        int antTraader = 0;
        File in = new File(args[1]);
        File ut = new File(args[2]);

        try {
            antTraader = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e){
            System.out.println("Forste argument maa vaere et heltall.");
            System.exit(0);
        }

        Scanner infil = null;

        try {
            infil = new Scanner(in);
        }
        catch (FileNotFoundException e){
            System.out.println("Fant ikke filen.");
            System.exit(0);
        }

        // oppretter array med lengde paa antOrd
        int antOrd = 0;
        try {
            antOrd = infil.nextInt();
        }
        catch (NumberFormatException e) {
            System.out.println("Filen har feil format.");
            System.exit(0);
        }
        String[] ordFraFil = new String[antOrd];

        // setter in ordene i arrayen
        int indeks = 0;
        while (infil.hasNextLine()){
            ordFraFil[indeks] = infil.nextLine();
            indeks++;
            if (indeks == antOrd){
                break;
            }
        }

        // sjekker om antall ord stemmer med den siste brukte indeksen
        if (indeks != antOrd){
            System.out.println("Det er feil antall ord oppgitt i filen.");
            System.exit(0);
        }

        // sjekker hvordan fordelingen av ord inn i traader skal vaere
        int n = antOrd / antTraader;
        int diff = antOrd - (n * antTraader);
        int start = 0;


        CountDownLatch nedTeller = new CountDownLatch(1);
        OrdMonitor ordmonitor = new OrdMonitor(antOrd, antTraader, nedTeller);



        for (int i = 0; i < antTraader; i++){
            int slutt;
            if (diff == 0){
                slutt = start + n;
            }
            else {
                slutt = start + n + 1;
                diff--;
            }
            Thread traad = new Thread(new OrdSorterer(ordFraFil, start, slutt, ordmonitor));
            traad.start();
        }
        Thread monitorTraad = new Thread(ordmonitor);
        monitorTraad.start();

        try {
            nedTeller.await();
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        String[] sortertListe =  ordmonitor.hentListe();

        try {
            PrintWriter utfil = new PrintWriter(ut);
            for (int i = 0; i < sortertListe.length; i++){
                utfil.println(sortertListe[i]);
            }
            utfil.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
    }
}
