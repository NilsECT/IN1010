import java.util.Scanner;
import java.io.File;

class Gruppeoppmoete {
    private String[] navn = new String[14];
    private boolean[] oppmoete = new boolean[14];
    public int totalAntStudenter = 0; //teller hvor mange studenter vi har med å gjøre

    /**
     * Metode som tar inn alle studentene fra filen
     * og setter dem i en array.
     * Kan kun ta inn 14 studenter.
     */

    public void lesInnFil(String filNavn) throws Exception {
        Scanner fil = new Scanner(new File(filNavn));

        while (fil.hasNextLine() && totalAntStudenter<navn.length){
            navn[totalAntStudenter] = fil.nextLine();
            totalAntStudenter ++;
            //Så lenge det er plass i arrayen og flere studenter vil den fylle ut navn[]
        }
        fil.close();
    }

    /**
     * Metode for å registrere oppmøte.
     * Løper gjennom array for hvert gitt navn
     * setter True i boolean i deres plass om de har møtt opp
     */
    public void registrerOppmoete(String student){
        for (int i = 0; i < totalAntStudenter; i++){
            if (student.equals(navn[i])){
                oppmoete[i] = true;
            }
        }
    }

    /**
     * sjekker om posisjon i oppmoete er true eller false
     * printer meldig tilsvarende eleven om den har møtt opp eller ikke
     */
    public void skrivUtOppmoete(){
        for (int i = 0; i < totalAntStudenter; i++){
            if (oppmoete[i] == true){
                System.out.println("Student ved navn: " + navn[i]);
                System.out.print(" har møtt opp.\n");
            } else {
                System.out.println("Student ved navn: " + navn[i]);
                System.out.print(" har ikke møtt opp.\n");
            }
        }
    }
}
