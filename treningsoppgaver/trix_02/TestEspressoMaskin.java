import java.util.Scanner;

public class TestEspressoMaskin {
    public static void main(String[] args)throws Exception{
        Scanner knapp = new Scanner(System.in);
        Scanner vann = new Scanner(System.in);
        int valg = 0;
        EspressoMaskin maskin = new EspressoMaskin();

        while (valg != 5){
            System.out.println("");
            meny();
            valg = knapp.nextInt();
            if (valg == 1){
                maskin.lagLungo();
            }
            else if (valg == 2){
                maskin.lagEspresso();
            }
            else if (valg == 3){
                System.out.println("Det er nå " + maskin.hentVannmengde() + "ml i tanken.");
            }
            else if (valg == 4){
                System.out.println("Hvor mye vann vil du tilsette (i ml)?\n");
                maskin.fyllvann(vann.nextInt());
            }
            else if (valg > 5){
                System.out.println("Tall må være mellom 1 og 5!\n");
            }
            else if (valg == 5){
                System.out.println("Avslutter!\n");
            }
        }
        knapp.close();
        vann.close();
    }
    public static void meny(){
        String meny = "Hei! Hva ønsker du å gjøre?\n";
        meny += "1 - En Lungo takk!\n";
        meny += "2 - En Espresso takk!\n";
        meny += "3 - Sjekke hvor mye vann det er.\n";
        meny += "4 - Fylle på med vann.\n";
        meny += "5 - Avslutt.\n";
        System.out.println(meny);
    }
}
