import java.io.*;
import java.util.Scanner;

public class Skattejakt {
    public static void main(String[] args){
        Skattekart skattekart = null;
        
        try {
            skattekart = skattekart.lesInn(new File(args[0]));
        }
        catch (FileNotFoundException e){
            System.out.println("Fant ikke filen. Avslutter.");
            System.exit(0);
        }

        skattekart.skrivUt();
        System.out.println("Finn skatten! Gjett koordinater paa formen (kol rad)! \n(a for aa avslutte)\n");

        int forsok = 0;
        Scanner brukerInput = new Scanner(System.in);
        String input = brukerInput.nextLine();
        

        while (!input.equals("a")){
            String[] koor = input.split(" ");

            try{
                int kol = Integer.parseInt(koor[0]);
                int rad = Integer.parseInt(koor[1]);

                if (skattekart.sjekk(rad, kol)){
                    System.out.println("Gratulerer, du fant skatten!");
                    System.out.println("Antall forsok: " + forsok);
                    input = "a";
                }
                else {
                    forsok++;
                    System.out.println("Skatten er ikke der, prov igjen!");
                    input = brukerInput.nextLine();
                }

                skattekart.skrivUt();
            }
            catch (NumberFormatException e){
                System.out.println("Feil format paa koordinater!");
            }
        }
    }
}
