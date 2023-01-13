import java.util.*;
import java.io.*;

public class LegeSystem {
    // Opprett lister som lagrer objektene i legesystemet
    static Lenkeliste<Pasient> pasienter = new Lenkeliste<>();
    static Lenkeliste<Legemiddel> legemiddler = new Lenkeliste<>();
    static SortertLenkeliste<Lege> leger = new SortertLenkeliste<>();
    static Lenkeliste<Resept> resepter = new Lenkeliste<>();

    public static void main(String[] args){
        
        Scanner tastatur = new Scanner(System.in);
        lesFraFil(new File("stoooorfil.txt"));

        int input = -1;

        // bruker en do-while lokke for aa ta haand om InputMismatchException og ikke haappe ut av programmet
        // maa taste inn noe ekstra for aa gaa helt ut av programmet derimot
        do {
            try{
                while (input != 0) {
                    System.out.println(meny());
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
                }
            }
            catch (InputMismatchException e){
                System.out.println("Skriv et av viste heltall.");
            }
            tastatur.next();
        } while (input != 0);
    }

    // metode for presentasjon av valgmenyen
    private static String meny(){
        String meny = "";
        meny += "1 - Oversikt\n";
        meny += "2 - Legge til element i systemet\n";
        meny += "3 - Bruke resept\n";
        meny += "4 - Statistikk\n";
        meny += "5 - Skriv til fil\n";
        meny += "0 - Avslutt (maa taste inn 0 to ganger)";
        return meny;
    }

    // VALG 1 AV MENY

    // metode for aa faa oversikten
    // Leger skal vaere i ordnet rekkefolge
    // bruker toString!
    private static void faaOversikt(){
        String linjedeler = "---------------";

        System.out.println("LEGER:\n");
        // leger er en SortertLenkeliste
        // dermed vil de allerede vaere i en sortert rekkefolge
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
        // letter aa ha en meny her ogsaa
        // kan anta at en vil legge til flere ting en etter en
        String muligeValg = "1 - Legge til en Lege/Spesialist.\n";
        muligeValg += "2 - Legge til en pasient.\n";
        muligeValg += "3 - Legge til et legemiddel.\n";
        muligeValg += "4 - Legge til en resept.\n";
        muligeValg += "0 - Ut.";

        int valg = -1;

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

    // metode for aa legge til en lege
    private static void leggTilLege(){
        System.out.println("Onsket format er: \"Navn,kontrollId\"");
        System.out.println("Hvis du ikke har en kontrollId sett 0.");
        Scanner in = new Scanner(System.in);

        // kan vaere mulig at en ikke skriver som en er bedt om aa gjore
        try{
            String[] info = in.nextLine().split(",");

            if (info[1].compareTo("0") == 0){
                leger.leggTil(new Lege(info[0]));
            }
            else {
                leger.leggTil(new Spesialist(info[0], info[1]));
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Skriv det slik det er presentert mellom anforselstegnene.");
        }
    }

    // metode for aa legge til en pasient
    private static void leggTilPasient(){
        System.out.println("Onsket format er: \"Navn,fnr\"");

        try{
            Scanner in = new Scanner(System.in);

            String[] info = in.nextLine().split(",");

            pasienter.leggTil(new Pasient(info[0], info[1]));
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Skriv det slik det er presentert mellom anforselstegnene.");
        }
    }

    // metode for aa legge til et legemiddel
    private static void leggTilLegemiddel(){
        System.out.println("Onsket format er: \"navn,preparat-type(a, b eller c),pris,virkestoff,styrke(bare for preparat a og b)\"");

        Scanner in = new Scanner(System.in);

        try{
            String[] info = in.nextLine().split(",");

            if (info[1].compareTo("a") == 0){
                legemiddler.leggTil(new Narkotisk(info[0], Integer.parseInt(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4])));
            }
            else if (info[1].compareTo("b") == 0){
                legemiddler.leggTil(new Vanedannende(info[0], Integer.parseInt(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4])));
            }
            else {
                legemiddler.leggTil(new Vanlig(info[0], Integer.parseInt(info[2]), Double.parseDouble(info[3])));
            }
        }
        catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
            System.out.println("Skriv det slik det er presentert mellom anforselstegnene.");
            System.out.println("Pris og styrke skal vaere heltall.");
        }
    }

    // metode for aa legge til et vanlig resept
    // veldig likt det som er i fil-lesemetoden
    private static void leggTilResept(){
        System.out.println("Onsket format er: \"legemiddelNavn,legeNavn,pasientID(fnr),reit\"");

        try{
            Scanner in = new Scanner(System.in);

            String[] info = in.nextLine().split(",");

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

            // kan vaere at det er en vanlig lege som vil lage et ulovlig reseptet
            // setter reseptet inn i lenkelisten resepter

            System.out.println("Hvilken type resept vil du skrive: vanlig(\"v\"),blaa(\"b\"),militaer(\"m\") eller P(\"p\")");
            System.out.println("P-Resept vil ha reit = 3.");

            String reseptValg = in.nextLine();
            if (reseptValg.compareTo("v") == 0){
                HvitResept nyResept = lege.skrivHvitResept(legemiddel, pasient, reit);
                resepter.leggTil(nyResept);
            }
            else if (reseptValg.compareTo("b") == 0){
                BlaaResept nyResept = lege.skrivBlaaResept(legemiddel, pasient, reit);
                resepter.leggTil(nyResept);
            }
            else if (reseptValg.compareTo("m") == 0){
                MilitaerResept nyResept = lege.skrivMilitaerResept(legemiddel, pasient, reit);
                resepter.leggTil(nyResept);
            }
            else if (reseptValg.compareTo("p") == 0){
                PResept nyResept = lege.skrivPResept(legemiddel, pasient);
                resepter.leggTil(nyResept);
            }
            else {
                System.out.println("Skrev ikke noen av valgene");
            }
        }
        catch (UlovligUtskrift | ArrayIndexOutOfBoundsException | NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }

    // VALG 3 AV MENY

    private static void brukResept(){
        System.out.println("Hvilken pasient vil du se resepter for?");

        int i = 0;

        for (Pasient pasient : pasienter){
            System.out.println(i + ": " + pasient.hentNavn() + "(" + pasient.hentFdr() + ")");
            i++;
        }

        System.out.println();

        Scanner input = new Scanner(System.in);

        int valg = input.nextInt();
        try{
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
                System.out.println("Brukte resept paa " + valgtResept.hentLegemiddel().hentNavn() + ". Antall gjenvaerende reit: " + valgtResept.hentReit());
            }
            else {
                System.out.println("Kunne ikke bruke resept paa " + valgtResept.hentLegemiddel().hentNavn() + "(ingen gjenvaerende reit");
            }
        }
        catch (UgyldigListeIndeks e){
            System.out.println(e.getMessage());
        }
    }

    // VALG 4 AV MENY

    private static void skrivStatistikk(){
        int antVanedannende = 0;
        int antNarkotisk = 0;

        // velger aa jobbe med hashmap her, mer oversiktlig
        HashMap<Spesialist, Integer> narkotiskeLeger = new HashMap<>();
        HashMap<Pasient, Integer> narkotiskePasienter = new HashMap<>();

        // lokke for aa hente ut dataen
        for (Resept resept : resepter){
            if (resept.hentLegemiddel() instanceof Vanedannende){
                antVanedannende++;
            }

            // behandler ogsaa mulig misbruk av nark
            else if (resept.hentLegemiddel() instanceof Narkotisk){
                antNarkotisk++;

                // oppdaterer lege-hashmapen
                Spesialist lege = (Spesialist) resept.hentLege();
                // legger til verdien til en lege hvis den allerede har skrevet ut narkResept
                if (narkotiskeLeger.containsKey(lege)){
                    narkotiskeLeger.put(lege, narkotiskeLeger.get(lege) + 1);
                }
                // ellers legger til helt ny med verdi 1
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
        }
        // printer ut statistikken
        String stat = "Antall utskrevede Vanedannende resepter: " + antVanedannende + "\n";
        stat += "Antall utskrevede Narkotiske resepter: " + antNarkotisk + "\n";
        stat += "Leger som har skrevet ut Narkotiske resepter: \n";
        stat += "\n";

        for (Spesialist lege : narkotiskeLeger.keySet()){
            stat += lege.hentNavn() + " har skrevet ut " + narkotiskeLeger.get(lege) + " narkotiske resepter.\n";
        }
        stat += "\n";
        for (Pasient pasient : narkotiskePasienter.keySet()){
            stat += pasient.hentNavn() + " (fdr " + pasient.hentFdr() + ") har " + narkotiskePasienter.get(pasient) + " narkotiske resepter.\n";
        }

        System.out.println(stat);
    }

    // VALG 5 AV MENY

    // skriver ut til fil med samme format som eksempelfilen
    private static void skrivTilFil(){
        String komma = ",";
        try{
            PrintWriter fil = new PrintWriter("LegesystemFil.txt");

            // legger in pasienter forst
            fil.println("# Pasienter (navn,fnr)");
            for (Pasient pasient : pasienter){
                fil.println(pasient.hentNavn() + komma + pasient.hentFdr());
            }

            // legemiddler
            fil.println("# Legemidler (navn,type,pris,virkestoff,[styrke])");
            for (Legemiddel legemiddel : legemiddler){
                String type;
                if (legemiddel instanceof Narkotisk){
                    type = "narkotisk";
                    Narkotisk middel = (Narkotisk) legemiddel;
                    fil.println(middel.hentNavn() + komma + type + komma + middel.hentPris() + komma + middel.hentVirkestoff() + komma + middel.hentNarkotiskStyrke());
                }
                else if (legemiddel instanceof Vanedannende){
                    type = "vanedannende";
                    Vanedannende middel = (Vanedannende) legemiddel;
                    fil.println(middel.hentNavn() + komma + type + komma + middel.hentPris() + komma + middel.hentVirkestoff() + komma + middel.hentVanedannendeStyrke());
                }
                else {
                    type = "vanlig";
                    fil.println(legemiddel.hentNavn() + komma + type + komma + legemiddel.hentPris() + komma + legemiddel.hentVirkestoff());
                }
            }

            // leger
            fil.println("# Leger (navn,kontrollid / 0 hvis vanlig lege)");
            for (Lege lege : leger){
                if (lege instanceof Spesialist){
                    Spesialist spes = (Spesialist) lege;
                    fil.println(spes.hentNavn() + komma + spes.hentKontrollID());
                }
                else {
                    fil.println(lege.hentNavn() + komma + 0);
                }
            }

            // Resepter
            // elementene i legemiddler og pasienter skal vaere ordnet per default med okende id siden vi ikke har mulighet til aa fjerne noen
            fil.println("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])");
            for (Resept resept : resepter){
                if (resept instanceof PResept){
                    fil.println(resept.hentLegemiddel().hentId() - 1 + komma + resept.hentLege().hentNavn() + komma + resept.hentPasient().hentId() + komma + resept.hentType());
                }
                else {
                    fil.println(resept.hentLegemiddel().hentId() - 1 + komma + resept.hentLege().hentNavn() + komma + resept.hentPasient().hentId() + komma + resept.hentType() + resept.hentReit());
                }
            }
            fil.close();
        }
        catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    // INNLESNING AV FIL

    // metode for aa lese fra fil
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
            String[] typeBytte = innlest.split(" ");

            // Legger til alle pasientene i filen
            if(typeBytte[1].equals("Pasienter")){
                while(scanner.hasNextLine()) {
                    innlest = scanner.nextLine();
                    String[] info = innlest.split(",");


                    //Om vi er ferdig med å legge til pasienter, bryt whileløkken,
                    //slik at vi fortsetter til koden for å legge til legemiddler
                    if(innlest.charAt(0) == '#'){
                        break;
                    }

                    // handterer feilformat av navn
                    // MAA ha lengde 2
                    if (info.length != 2){
                        continue;
                    }

                    // legger til pasient i lenkeliste pasienter
                    pasienter.leggTil(new Pasient(info[0], info[1]));
                }

            }
            //Legger inn Legemiddlene
            else if(typeBytte[1].compareTo("Legemidler") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    //Om vi er ferdig med å legge til legemidler, bryt whileløkken,
                    //slik at vi fortsetter til koden for å legge til leger
                    if(innlest.charAt(0) == '#'){
                        break;
                    }

                    String[] legemiddel = innlest.split(",");

                    // kan ikke vaere lengre enn 5 uannsett eller mindre 3
                    if (legemiddel.length > 5 || legemiddel.length < 3){
                        continue;
                    }

                    // hvis lengden er 4 eller 5 kan det hende det er feil info noen steder
                    // prover forste med aa sjekke plassen til enten "narkotisk" eller "vanedannende" eller "vanlig"
                    if ((legemiddel.length == 4 || legemiddel.length == 5) && (legemiddel[1].compareTo("vanedannende") != 0 && legemiddel[1].compareTo("narkotisk") != 0 && legemiddel[1].compareTo("vanlig") != 0)){
                        continue;
                    }

                    try {
                        double prisDouble = Double.parseDouble(legemiddel[2]);
                        int pris = (int) Math.round(prisDouble);

                        if(legemiddel[1].compareTo("narkotisk") == 0){
                            // legger inn Narkostisk legemiddel i lenkelisten legemiddler
                            legemiddler.leggTil(new Narkotisk(legemiddel[0], pris,Double.parseDouble(legemiddel[3]),Integer.parseInt(legemiddel[4])));
                        }
                        else if (legemiddel[1].compareTo("vanedannende") == 0){
                            
                            // legger inn Vanedannende legemiddel i lenkelisten legemiddler
                            legemiddler.leggTil(new Vanedannende(legemiddel[0], pris,Double.parseDouble(legemiddel[3]),Integer.parseInt(legemiddel[4])));
                        }
                        else if (legemiddel[1].compareTo("vanlig") == 0){

                            // legger til Vanlig legemiddel i lenkelisten legemiddler
                            legemiddler.leggTil(new Vanlig(legemiddel[0], pris,Double.parseDouble(legemiddel[3])));
                        }
                    }
                    // kan hende det ikke er tall der det blir parset til double eller int
                    catch (NumberFormatException e){
                        continue;
                    }
                }
            }
            //Legger inn leger
            else if(typeBytte[1].compareTo("Leger") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();

                    //Om vi er ferdig med å legge til leger, bryt whileløkken,
                    //slik at vi fortsetter til koden for å legge til resepter
                    if(innlest.charAt(0) == '#'){
                        break;
                    }
                    String[] info = innlest.split(",");

                    // lengden MAA vaere 2
                    if (info.length != 2){
                        continue;
                    }

                    String kontrollid = info[1];
                    if(kontrollid.compareTo("0") == 0){

                        // legger til lege i den sortertlenkelisten leger
                        leger.leggTil(new Lege(info[0]));
                    }
                    else{
                        
                        // legger til lege i den sortertlenkelisten leger
                        leger.leggTil(new Spesialist(info[0], info[1]));
                    }
                }
            }
            //Legger inn Resepter
            else if(typeBytte[1].compareTo("Resepter") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();

                    String[] info = innlest.split(",");

                    Legemiddel legemiddel = null;
                    Lege lege = null;
                    Pasient pasient = null;

                    // henter ut legemiddelet
                    for (Legemiddel i : legemiddler){
                        // antar her at legemiddelNummer er Id-en som starter paa 1
                        if (i.hentId() - 1 == Integer.parseInt(info[0])){
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
                        if (iii.hentId() == Integer.parseInt(info[2])){
                            pasient = iii;
                            break;
                        }
                    }

                    if (legemiddel == null || lege == null || pasient == null){
                        // if (legemiddel == null){System.out.println("Legemiddel er null" + info[0]);}
                        // if (lege == null){System.out.println("lege er null" + info[1]);}
                        // if (pasient == null){System.out.println("pasient er null" + info[2]);}
                        continue;
                    }

                    try{
                        if (info[3].compareTo("hvit") == 0){
                            HvitResept ny = lege.skrivHvitResept(legemiddel, pasient, Integer.parseInt(info[4]));
                            resepter.leggTil(ny);
                        }
                        else if (info[3].compareTo("blaa") == 0){
                            BlaaResept ny = lege.skrivBlaaResept(legemiddel, pasient, Integer.parseInt(info[4]));
                            resepter.leggTil(ny);
                        }
                        else if (info[3].compareTo("millitaer") == 0){
                            MilitaerResept ny = lege.skrivMilitaerResept(legemiddel, pasient, Integer.parseInt(info[4]));
                            resepter.leggTil(ny);
                        }
                        else if(info[3].compareTo("p") == 0){
                            PResept ny = lege.skrivPResept(legemiddel, pasient);
                            resepter.leggTil(ny);
                        }
                    }
                    catch (UlovligUtskrift e){
                        e.getMessage();
                    }
                }
            }
            else {
                return;
            }
        }
    }
}

/**
 * Kjoreeksempel med utskrift i reseptlaging med bruk av den store filen der det ikke kunne bli laget en resept.
 * Det staar enten legen sitt navn, pasienten sin id eller legemiddelnummeret som ikke ble funnet.
 * 
 * Programmet fungerer som det skal naa. Etter litt mer testing er den i orden.
 * 
 * 
 * ~/Documents/Studies/Bachelor/IN/in1010/innleveringer/oblig4/2021$ java LegeSystem 
Legemiddel er null141
Legemiddel er null151
Legemiddel er null139
Legemiddel er null150
Legemiddel er null134
Legemiddel er null150
Legemiddel er null152
Legemiddel er null154
Legemiddel er null154
pasient er null91
Legemiddel er null153
Legemiddel er null156
Legemiddel er null136
Legemiddel er null152
Legemiddel er null156
Legemiddel er null152
Legemiddel er null134
Legemiddel er null137
pasient er null90
Legemiddel er null137
pasient er null93
Legemiddel er null145
Legemiddel er null147
Legemiddel er null153
1 - Oversikt
2 - Legge til element i systemet
3 - Bruke resept
4 - Statistikk
5 - Skriv til fil
0 - Avslutt (maa taste inn 0 to ganger)

*/
