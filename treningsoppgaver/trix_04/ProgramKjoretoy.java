import java.util.HashMap;
import java.util.Scanner;

public class ProgramKjoretoy {
    HashMap<String, Kjoretoy> kjoretoyliste = new HashMap<>();

    public void system(){
        Scanner in = new Scanner(System.in);
        int valg = -1;
        
        while (valg != 0){
            System.out.println(meny());
            valg = in.nextInt();
            
            if (valg == 1){
                registrerNyttKjoreoy();
            }
            else if (valg == 2){
                skrivData();
            }
            else if (valg == 3){
                regnAarsavgiftForEier();
            }
        }
        //in.close();
    }
    
    public String meny(){
        String meny = "1 - Registrer nytt kjøretøy.\n";
        meny += "2 - Skriv ut data fra et kjøretøy.\n";
        meny += "3 - Finn total årsavgift for en eier.\n";
        meny += "0 - Avslutt\n";
        return meny;
    }

    public void registrerNyttKjoreoy(){
        Scanner input = new Scanner(System.in);
        System.out.println("Hvilken type kjørtøy vil du registrere? (buss, personbil, varebil)");
        String type = input.nextLine();
        if (type.equals("buss")){
            regBuss();
        }
        else if (type.equals("personbil")){
            regPersonbil();
        }
        else if (type.equals("varebil")){
            regVarebil();
        }
        else {
            System.out.println("skriv ordentlig er du snill");
        }
        //input.close();
    }

    public void skrivData(){
        Scanner input = new Scanner(System.in);
        System.out.println("Hva er registreringsnummeret til kjøretøyet du vil hente data fra: ");
        String regnum = input.nextLine();
        if (kjoretoyliste.containsKey(regnum)){
            kjoretoyliste.get(regnum).skrivInfo();
        }
        else {
            System.out.println("Det er ingen kjøretøy med det registreringsnummeret");
        }
        //input.close();
    }

    public void regnAarsavgiftForEier(){
        Scanner input = new Scanner(System.in);
        System.out.println("Hvem vil du regne årsavgift for?");
        String eier = input.nextLine();
        Double total = 0.0;

        for (Kjoretoy kjoretoy : kjoretoyliste.values()){
            if (kjoretoy.hentEier().equals(eier)){
                total += kjoretoy.hentAarsavgift();
            }
        }
        System.out.println("Totalen er: " + total);
        //input.close();
    }

    public void regBuss(){
        System.out.println("Skriv registreringsnummeret: ");
        Scanner annet = new Scanner(System.in);
        String reg = annet.nextLine();

        System.out.println("Skriv merke: ");
        String merke =annet.nextLine();

        System.out.println("Skriv eieren: ");
        String eier =annet.nextLine();

        System.out.println("Skriv antall plasser: ");
        int plasser = annet.nextInt();

        Buss nybuss = new Buss(reg, merke, eier, plasser);
        kjoretoyliste.put(nybuss.hentRegistreringsnummer(), nybuss);

        //annet.close();
    }

    public void regPersonbil(){
        System.out.println("Skriv registreringsnummeret: ");
        Scanner annet = new Scanner(System.in);

        String reg = annet.nextLine();

        System.out.println("Skriv merke: ");
        String merke =annet.nextLine();

        System.out.println("Skriv eieren: ");
        String eier =annet.nextLine();

        System.out.println("Skriv antall plasser: ");
        int plasser = annet.nextInt();

        Personbil nyBil = new Personbil(reg, merke, eier, plasser);
        kjoretoyliste.put(nyBil.hentRegistreringsnummer(), nyBil);
        //annet.close();
    }

    public void regVarebil(){
        System.out.println("Skriv registreringsnummeret: ");
        Scanner annet = new Scanner(System.in);

        String reg = annet.nextLine();

        System.out.println("Skriv merke: ");
        String merke =annet.nextLine();

        System.out.println("Skriv eieren: ");
        String eier =annet.nextLine();

        System.out.println("Skriv maksvekten: ");
        double maksvekt = annet.nextInt();

        Varebil nyVarebil = new Varebil(reg, merke, eier, maksvekt);
        kjoretoyliste.put(nyVarebil.hentRegistreringsnummer(), nyVarebil);
        //annet.close();
    }
}
