import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class Hovedprogram {
    // endret versjon
    public static void main(String[] args) {
        String filnavn = null;
        if (args.length > 0) {
            filnavn = args[0];
        } else {
            System.out.println("FEIL! Riktig bruk av programmet: "
                               +"java Oblig6 <labyrintfil>");
            return;
        }
        Labyrint labyrint = null;
        try {
            labyrint = new Labyrint(filnavn);
        } catch (FileNotFoundException e) {
            System.out.printf("FEIL: Kunne ikke lese fra '%s'\n", filnavn);
            System.exit(1);
        }
        // les start-koordinater fra standard input
        Scanner inn = new Scanner(System.in);

        // byttet om <rad> og <kolonne>
        System.out.println("Skriv inn koordinater <rad> <kolonne> ('a' for aa avslutte)");
        String[] ord = inn.nextLine().split(" ");
        while (!ord[0].equals("a")) {
            try {
                int startRad = Integer.parseInt(ord[0]);
                int startKol = Integer.parseInt(ord[1]);
                System.out.println("Utveier:");
                ArrayList<ArrayList<Tuppel>> utveier = labyrint.finnUtveiFra(startKol, startRad);

                while (!utveier.isEmpty()) {

                    // mens den henter ut losninger skal den losningen ogsaa slettes fra listen
                    ArrayList<Tuppel> lis = utveier.remove(0);
                    for(Tuppel t: lis)
                        System.out.println(t);
                    System.out.println();
                }
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Ugyldig input!");
            }         
            System.out.println("Skriv inn nye koordinater ('a' for aa avslutte)");
            ord = inn.nextLine().split(" ");
        }
    }
}

/**
 * Kjoreeksempel lik den gitt i oppgaveTeksten:
 * 
 * ~/Documents/Studies/Bachelor/IN/in1010/innleveringer/oblig6$ java Hovedprogram 7.in
Skriv inn koordinater <rad> <kolonne> ('a' for aa avslutte)
1 1
Utveier:
(1, 1)
(0, 1)

(1, 1)
(2, 1)
(2, 0)


Skriv inn nye koordinater ('a' for aa avslutte)
1 3
Utveier:

Skriv inn nye koordinater ('a' for aa avslutte)
3 3
Utveier:
(3, 3)
(3, 4)


Skriv inn nye koordinater ('a' for aa avslutte)
a

 */