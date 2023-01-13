import java.util.*;
import java.io.*;

public class Legesystem{
    // Opprett lister som lagrer objektene i legesystemet
    static Lenkeliste<Pasient> pasienter = new Lenkeliste<>();
    static Lenkeliste<Legemiddel> legemiddler = new Lenkeliste<>();
    static SortertLenkeliste<Lege> leger = new SortertLenkeliste<>();
    static Lenkeliste<Resept> resepter = new Lenkeliste<>();

    public static void main(String[] args){
        
        Scanner tastatur = new Scanner(System.in);
        lesFraFil(new File("Vedlegg2.txt"));

        int input = -1;

        while (input != 0){
            System.out.println(meny());

            try {
                input = tastatur.nextInt();

                if (input == 1){
                    faaOversikt();
                }
                else if (input == 2){
                    leggeTilISystem();
                }
                else if (input == 3){
                    brukResept();
                }
                else if (input == 4){
                    skrivStatistikk();
                }
                else if (input == 5){
                    skrivTilFil();
                }
                else if (input == 6){
                    skrivSpesiellResept();
                }
            }
            catch (InputMismatchException e){
                e.getMessage();
            }
        }

    }

    // lager en meny metode
    private static String meny(){
        String meny = "";
        meny += "1 - Oversikt\n";
        meny += "2 - Legge til element i systemet\n";
        meny += "3 - Bruke resept\n";
        meny += "4 - Statistikk\n";
        meny += "5 - Skriv til fil\n";
        meny += "6 - Skriv spesiell Respet.\n";
        meny += "0 - Avslutt";
        return meny;
    }

    private static void lesFraFil(File fil){
        Scanner scanner = null;
        try{
            scanner = new Scanner(fil);
        }catch(FileNotFoundException e){
            System.out.println("Fant ikke filen, starter opp som et tomt Legesystem");
            return;
        }

        String innlest = scanner.nextLine();


        while(scanner.hasNextLine()){

            String[] info = innlest.split(", ");

            // Legger til alle pasientene i filen
            if(info[1].compareTo("Pasienter") == 0){
                while(scanner.hasNextLine()) {
                    innlest = scanner.nextLine();

                    //Om vi er ferdig med å legge til pasienter, bryt whileløkken,
                    //slik at vi fortsetter til koden for å legge til legemiddler
                    if(innlest.charAt(0) == '#'){
                        break;
                    }

                    // legger til pasient i lenkeliste pasienter
                    pasienter.leggTil(new Pasient(info[0], info[1]));
                }

            }
            //Legger inn Legemiddlene
            else if(info[1].compareTo("Legemidler") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    //Om vi er ferdig med å legge til legemidler, bryt whileløkken,
                    //slik at vi fortsetter til koden for å legge til leger
                    if(innlest.charAt(0) == '#'){
                        break;
                    }

                    String[] legemiddel = innlest.split(", ");

                    if(legemiddel[1].compareTo("a") == 0){
                        
                        // legger inn Narkostisk legemiddel i lenkelisten legemiddler
                        legemiddler.leggTil(new Narkotisk(legemiddel[0], Double.parseDouble(legemiddel[2]),Double.parseDouble(legemiddel[3]),Integer.parseInt(legemiddel[4])));
                    }
                    else if (legemiddel[1].compareTo("b") == 0){
                        
                        // legger inn Vanedannende legemiddel i lenkelisten legemiddler
                        legemiddler.leggTil(new Vanedannende(legemiddel[0], Double.parseDouble(legemiddel[2]),Double.parseDouble(legemiddel[3]),Integer.parseInt(legemiddel[4])));
                    }
                    else if (legemiddel[1].compareTo("c") == 0){
                        
                        // legger til Vanlig legemiddel i lenkelisten legemiddler
                        legemiddler.leggTil(new Vanlig(legemiddel[0], Double.parseDouble(legemiddel[2]),Double.parseDouble(legemiddel[3])));
                    }

                }
            }
            //Legger inn leger
            else if(info[1].compareTo("Leger") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    //Om vi er ferdig med å legge til leger, bryt whileløkken,
                    //slik at vi fortsetter til koden for å legge til resepter
                    if(innlest.charAt(0) == '#'){
                        break;
                    }
                    info = innlest.split(", ");
                    int kontrollid = Integer.parseInt(info[1]);
                    if(kontrollid == 0){

                        // legger til lege i den sortertlenkelisten leger
                        leger.leggTil(new Lege(info[0]));
                    }
                    else{
                        
                        // legger til lege i den sortertlenkelisten leger
                        leger.leggTil(new Spesialist(info[0], Integer.parseInt(info[1])));
                    }
                }
            }
            //Legger inn Resepter
            else if(info[1].compareTo("Resepter") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    info = innlest.split(", ");

                    Legemiddel legemiddel = null;
                    Lege lege = null;
                    Pasient pasient = null;
                    int reit = Integer.parseInt(info[3]);

                    // henter ut legemiddelet
                    for (Legemiddel i : legemiddler){
                        if (i.hentId() == Integer.parseInt(info[0])){
                            legemiddel = i;
                            break;
                        }
                    }

                    // henter ut legen
                    for (Lege ii : leger){
                        if (ii.hentNavn().equals(info[1])){
                            lege = ii;
                            break;
                        }
                    }

                    // henter ut pasienten
                    for (Pasient iii : pasienter){
                        if (iii.fodselsnummer.equals(info[2])){
                            pasient = iii;
                            break;
                        }
                    }

                    // lager de vanlige (hvite) reseptene med en try catch
                    // kan være at det er en vanlig lege som vil lage et ulovlig reseptet
                    // setter reseptet inn i lenkelisten resepter

                    try {
                        Resept nyResept = lege.skrivResept(legemiddel, pasient, reit);
                        resepter.leggTil(nyResept);
                    }
                    catch (UlovligUtskrift e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    // VALG 1 AV MENY

    // metode for å få oversikten
    // Leger skal være i ordnet rekkefølge
    // bruker toString!
    private static void faaOversikt(){
        String linjedeler = "###########################################";

        System.out.println("LEGER:\n");
        for (Lege i : leger){
            System.out.println(i.toString());
            System.out.println();
        }

        System.out.println(linjedeler);
        System.out.println();

        System.out.println("PASIENTER:\n");
        for (Pasient ii : pasienter){
            System.out.println(ii.toString());
            System.out.println();
        }

        System.out.println(linjedeler);
        System.out.println();

        System.out.println("LEGEMIDDLER:\n");
        for (Legemiddel iii : legemiddler){
            System.out.println(iii.toString());
            System.out.println();
        }

        System.out.println(linjedeler);
        System.out.println();

        System.out.println("RESEPTER:\n");
        for (Resept iv : resepter){
            System.out.println(iv.toString());
            System.out.println();
        }
    }

    // VALG 2 AV MENY

    // metode for aa legge til elementer i systemet
    private static void leggeTilISystem(){
        String muligeValg = "1 - Legge til en Lege/Spesialist.\n";
        muligeValg += "2 - Legge til en pasient.\n";
        muligeValg += "3 - Legge til et legemiddel.\n";
        muligeValg += "4 - Legge til en resept.\n";
        muligeValg += "0 - Ut.";

        int valg = -1;

        try {
            Scanner input = new Scanner(System.in);

            while (valg != 0){
                System.out.println(muligeValg);
                valg = input.nextInt();

                if (valg == 1){
                    leggTilLege();
                }
                else if (valg == 2){
                    leggTilPasient();
                }
                else if (valg == 3){
                    leggTilLegemiddel();
                }
                else if (valg == 4){
                    leggTilResept();
                }
            }
        }
        catch (InputMismatchException e){
            e.getMessage();
        }
    }

    // metode for aa legge til en lege
    private static void leggTilLege(){
        System.out.println("Ønsket format er: Navn, kontrollId.");
        System.out.println("Hvis du ikke har en kontrollId sett 0.");
        Scanner in = new Scanner(System.in);

        String[] info = in.nextLine().split(", ");

        try {
            if (info[1].compareTo("0") == 0){
                leger.leggTil(new Lege(info[0]));
            }
            else {
                leger.leggTil(new Spesialist(info[0], Integer.parseInt(info[1])));
            }
        }
        catch (NumberFormatException e){
            e.getMessage();
        }
    }

    // metode for aa legge til en pasient
    private static void leggTilPasient(){
        System.out.println("Ønsket format er: Navn, fnr.");

        Scanner in = new Scanner(System.in);

        String[] info = in.nextLine().split(", ");

        pasienter.leggTil(new Pasient(info[0], info[1]));
    }

    // metode for aa legge til et legemiddel
    private static void leggTilLegemiddel(){
        System.out.println("Ønsket format er: navn, preparat-type, pris, virkestoff, styrke(bare for preparat a og b)");

        Scanner in = new Scanner(System.in);

        String[] info = in.nextLine().split(", ");

        try{
            if (info[1].compareTo("a") == 0){
                legemiddler.leggTil(new Narkotisk(info[0], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4])));
            }
            else if (info[1].compareTo("b") == 0){
                legemiddler.leggTil(new Vanedannende(info[0], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4])));
            }
            else {
                legemiddler.leggTil(new Vanlig(info[0], Double.parseDouble(info[2]), Double.parseDouble(info[3])));
            }
        }
        catch (NumberFormatException e){
            e.getMessage();
        }
    }

    // metode for aa legge til et vanlig resept
    // veldig likt det som er i fillesemetoden
    private static void leggTilResept(){
        System.out.println("Ønsket format er: legemiddelNavn, legeNavn, pasientID, reit");

        Scanner in = new Scanner(System.in);

        String[] info = in.nextLine().split(", ");

        Legemiddel legemiddel = null;
        Lege lege = null;
        Pasient pasient = null;
        int reit = Integer.parseInt(info[3]);

        // henter ut legemiddelet
        for (Legemiddel i : legemiddler){
            // kan man forvente at en kan ID-en?
            if (i.hentNavn().compareTo(info[0]) == 0){
                legemiddel = i;
                break;
            }
        }
        if (legemiddel == null){
            System.out.println("Fant ikke legemiddelet");
            return;
        }

        // henter ut legen
        for (Lege ii : leger){
            if (ii.hentNavn().equals(info[1])){
                lege = ii;
                break;
            }
        }
        if (lege == null){
            System.out.println("Fant ikke legen");
            return;
        }

        // henter ut pasienten
        for (Pasient iii : pasienter){
            if (iii.fodselsnummer.equals(info[2])){
                pasient = iii;
                break;
            }
        }
        if (pasient == null){
            System.out.println("Fant ikke pasienten");
            return;
        }

        // lager de vanlige (hvite) reseptene med en try catch
        // kan være at det er en vanlig lege som vil lage et ulovlig reseptet
        // setter reseptet inn i lenkelisten resepter

        try {
            Resept nyResept = lege.skrivResept(legemiddel, pasient, reit);
            resepter.leggTil(nyResept);
        }
        catch (UlovligUtskrift e){
            System.out.println(e.getMessage());
        }
    }

    // VALG 3 AV MENY

    private static void brukResept(){
        System.out.print("Hvilken pasient vil du se resepter for?");

        int i = 0;

        for (Pasient pasient : pasienter){
            System.out.println(i + ": " + pasient.hentNavn() + "(" + pasient.hentFdr() + ")");
            i++;
        }

        System.out.println();

        Scanner input = new Scanner(System.in);

        try {
            int valg = input.nextInt();
            Pasient valgtPasient = pasienter.hent(valg);
            
            System.out.println("Valgt pasient: " + valgtPasient.toString());
            System.out.println("Hvilken resept vil du bruke?");
            i = 0;

            for (Resept resept : valgtPasient.hentReseptStabel()){
                System.out.println(i + ": " + resept.hentLegemiddel().hentNavn() + "(" + resept.hentReit() + " reit)");
                i++;
            }

            valg = input.nextInt();
            // henter reseptet fra pasientens liste
            Resept valgtResept = valgtPasient.hentReseptStabel().hent(valg);

            // se Resept sin metode bruk
            if (valgtResept.bruk()){
                System.out.println("Brukte resept på " + valgtResept.hentLegemiddel().hentNavn() + ". Antall gjenværende reit: " + valgtResept.hentReit());
            }
            else {
                System.out.println("Kunne ikke bruke resept på " + valgtResept.hentLegemiddel().hentNavn() + "(ingen gjenværende reit");
            }
        }
        catch (InputMismatchException e){
            e.getMessage();
        }
    }

    // VALG 4 AV MENY

    private static void skrivStatistikk(){
        int antVanedannende = 0;
        int antNarkotisk = 0;

        HashMap<Spesialist, Integer> narkotiskeLeger = new HashMap<>();
        HashMap<Pasient, Integer> narkotiskePasienter = new HashMap<>();

        // lokke for aa hente ut dataen
        for (Resept resept : resepter){
            if (resept.hentLegemiddel() instanceof Vanedannende){
                antVanedannende++;
            }

            // behandler ogsaa mulig misbruk
            else if (resept.hentLegemiddel() instanceof Narkotisk){
                antNarkotisk++;

                // oppdaterer lege-hashmapen
                Spesialist lege = (Spesialist) resept.hentLege();
                if (narkotiskeLeger.containsKey(lege)){
                    narkotiskeLeger.put(lege, narkotiskeLeger.get(lege) + 1);
                }
                else {
                    narkotiskeLeger.put(lege, 1);
                }

                // oppdaterer pasient-hashmapen
                Pasient pasient = resept.hentPasient();
                if (narkotiskePasienter.containsKey(pasient)){
                    narkotiskePasienter.put(pasient, narkotiskePasienter.get(pasient) + 1);
                }
                else {
                    narkotiskePasienter.put(pasient, 1);
                }
            }

            // printer ut statistikken
            String stat = "Antall utskrevede Vanendannende resepter: " + antVanedannende + "\n";
            stat += "Antall utskrevede Narkotiske resepter: " + antNarkotisk + "\n";
            stat += "Leger som har skrevet ut Narkotiske resepter: \n";
            stat += "\n";
            for (Spesialist lege : narkotiskeLeger.keySet(){
                stat += lege.hentNavn() + " har skrevet ut " + narkotiskeLeger.get(lege) + " narkotiske resepter.\n";
            }
            stat += "\n";
            for (Pasient pasient : narkotiskePasienter.keySet()){
                stat += pasient.hentNavn() + "(fdr " + pasient.hentFdr() + ") har " + narkotiskePasienter.get(pasient) + " narkotiske resepter.\n";
            }

            System.out.println(stat);
        }
    }

    // VALG 5 AV MENY

    
}
