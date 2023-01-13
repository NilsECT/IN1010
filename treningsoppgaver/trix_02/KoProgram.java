import java.util.Scanner;

public class KoProgram {
    public static void main(String[] args){
        KoSystem kosystem = new KoSystem();
        Scanner num = new Scanner(System.in);
        int valg = 0;

        while (valg != 4){
            System.out.println("");
            printMeny();
            valg = num.nextInt();

            if (valg == 1){
                kosystem.trekkKoLapp();
                System.out.println("");

            } else if (valg == 2){
                kosystem.betjentKunde();
                System.out.println("");

            } else if (valg == 3){
                System.out.println("Det står " + kosystem.antKunder() + " personer i kø.");
                System.out.println("");

            } else if (valg == 4){
                System.out.println("Programmet avsluttes.");
                System.out.println("");

            }
            num.close();
        }
    }

    public static void printMeny(){
        String meny = "**MENY FOR BILLETTSYSTEM**\n";
        meny += "1 - Trekk ny kølapp.\n";
        meny += "2 - Betjent kunde.\n";
        meny += "3 - Print antall kunder i kø.\n";
        meny += "4 - Avslutt.";
        System.out.println(meny);
    }
}
