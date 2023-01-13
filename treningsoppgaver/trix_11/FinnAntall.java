import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class FinnAntall {
    public static void main(String[] args){
        String ordSomSkalFinnes = args[0];
        String filnavn = args[1];
        int antTraader = Integer.parseInt(args[2]);
        ArrayList<String> ordliste = new ArrayList<>();
        OrdTeller ordteller = new OrdTeller();

        Scanner fil = null;
        try{
            fil = new Scanner(new File(filnavn));
        }
        catch (FileNotFoundException e){
            System.out.println("Fant ikke filen.");
            System.exit(0);
        }

        int antLinjer = fil.nextInt();

        while (fil.hasNextLine()){
            ordliste.add(fil.nextLine());
        }

        CountDownLatch latch = new CountDownLatch(antTraader);
        int ordPerTraad = ordliste.size() / antTraader;
        int diff = ordliste.size() - (ordPerTraad * antTraader);
        int indeks = 0;
        for (int i = 0; i < antTraader; i++){
            if (i == 7){
                OrdFinner finner = new OrdFinner(indeks, indeks + ordPerTraad + diff, ordliste, ordSomSkalFinnes, ordteller, latch);
                Thread traad = new Thread(finner);
                traad.start();
            }
            else {
                OrdFinner finner = new OrdFinner(indeks, indeks + ordPerTraad, ordliste, ordSomSkalFinnes, ordteller, latch);
                Thread traad = new Thread(finner);
                traad.start();
                indeks += ordPerTraad;
            }
        }

        try {
            latch.await();
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(ordSomSkalFinnes + " forekom " + ordteller.hentAntForekomster() + " ganger.");
    }
}
