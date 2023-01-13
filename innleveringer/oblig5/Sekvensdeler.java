import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class Sekvensdeler implements Runnable {
    private Beholder beholder;
    private ArrayList<String> sekvenser = new ArrayList<>();
    private int subLengde;

    // konstruktoren lager sekvensene
    public Sekvensdeler(String filnavn, Beholder beholder, int subLengde) {
        this.beholder = beholder;
        this.sekvenser = lesFraFil(filnavn);
        this.subLengde = subLengde;
    }

    // lager subsekvensene og sender dem inn i en HashMap og setter den saa i beholderen
    public void run(){
        HashMap<String, SubSekvens> subsekvenser = new HashMap<>();

        while (!sekvenser.isEmpty()) {
            String sekvens = sekvenser.remove(0);
            for (int i = 0; i + subLengde <= sekvens.length(); i++) {
                String sub = sekvens.substring(i, i + subLengde);
                subsekvenser.put(sub, new SubSekvens(sub));
            }
        }
        beholder.settHashMap(subsekvenser);
        // sier at den har levert
        beholder.ferskLevering();
    }

    // leser sekvensene fra filen og gir dem saa i en ArrayList
    private ArrayList<String> lesFraFil(String filnavn) {
        ArrayList<String> ut = new ArrayList<>();
        Scanner fil = null;

        try {
            fil = new Scanner(new File(filnavn));
        }
        catch (FileNotFoundException e) {
            System.out.println("Fant ikke fil: " + filnavn + ". Avslutter.");
            System.exit(0);
        }

        while (fil.hasNextLine()) {
            String linje = fil.nextLine();

            // handterer reelle data filene
            if (linje.equals("amino_acid")) {
                continue;
            }

            ut.add(linje);
        }

        return ut;
    }
}
