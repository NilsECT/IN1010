import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Hoved {
    static int antSyke;
    static int antFriske;
    static int subLengde = 3;

    public static void main(String[] args){

        HashMap<String, Boolean> filListe = lesMetadata("reellemetadata.csv");

        Beholder syk = new Beholder(antSyke);
        Beholder frisk = new Beholder(antFriske);

        int subing = 1;
        // finner subsekvenser og setter dem i beholderen via run metoden til Sekvensdeler
        for (String filnavn : filListe.keySet()) {
            Thread traad;
            // oppretter traad for syke sekvenser
            if (filListe.get(filnavn).booleanValue()) {
                traad = new Thread(new Sekvensdeler(filnavn, syk, subLengde));
            }
            // ellers for friske
            else {
                traad = new Thread(new Sekvensdeler(filnavn, frisk, subLengde));
            }
            System.out.println("starter subsekvensiering nr " + subing);
            traad.start();
            subing++;
        }
        System.out.println("ferdig med å starte subsekvensiering");

        CountDownLatch latch = new CountDownLatch(Integer.parseInt(args[0]));
        // bruker en boolean for aa alternere om hvilken traad gjor hva
        // slipper aa tenke paa aa dele paa to og rest og slikt
        // lager saa mange traader som onsket
        boolean alt = true;
        for (int i = 0; i < Integer.parseInt(args[0]); i++){
            Thread fletteTraad;
            if (alt) {
                fletteTraad = new Thread(new Fletter(syk, latch));
            }
            else {
                fletteTraad = new Thread(new Fletter(frisk, latch));
            }
            alt = !alt;
            System.out.println("Starter flettetråd nr " + i);
            fletteTraad.start();
        }
        // venter paa at alle traader skal vaere ferdige
        // Sekvensedeler traader maa vaere ferdige for at flettetraader skal kunne bli ferdige
        try {
            latch.await();
        }
        catch (InterruptedException e){
            e.getMessage();
        }
        System.out.println("Ferdig med fletting");
        // gjor en enkel statistisk test

        HashMap<String, SubSekvens> sykFerdig = syk.hentFerdigFlettet();
        HashMap<String, SubSekvens> friskFerdig = frisk.hentFerdigFlettet();

        int antall = 0;
        // henter ut de som forekommer mer enn fem ganger mer i de syke og printer det ut
        for (SubSekvens subSyk : sykFerdig.values()) {
            if (friskFerdig.containsKey(subSyk.hentSubSekvens()) && (subSyk.hentAntForekomster() - friskFerdig.get(subSyk.hentSubSekvens()).hentAntForekomster()) >= 5) {
                System.out.println(subSyk.hentSubSekvens() + " har forekommet mer enn 5 ganger mer hos syke enn friske.");
                System.out.println("Hos syke : " + subSyk);
                System.out.println("Hos friske : " +  friskFerdig.get(subSyk.hentSubSekvens()));
                System.out.println("Det er " + (subSyk.hentAntForekomster() - friskFerdig.get(subSyk.hentSubSekvens()).hentAntForekomster()) + " ganger mer.\n");
                antall++;
            }
        }
        System.out.println("Totalt er det " + antall + " subsekvenser som er mer dominante hos syke.");
    }

    //henter ut filnavn og om det er fra syk person eller ikke og returnerer det i en HashMap
    static HashMap<String, Boolean> lesMetadata(String filnavn) {
        HashMap<String, Boolean> filListe = new HashMap<>();
        Scanner fil = null;
        try {
            fil = new Scanner(new File(filnavn));
        }
        catch (FileNotFoundException e) {
            System.out.println("Fant ikke metadata filen, avslutter.");
            System.exit(0);
        }

        while (fil.hasNextLine()) {
            String[] linje = fil.nextLine().split(",");

            // hopper over forste linje for testdata
            if (linje[0].equals("testfiler")) {
                continue;
            }

            linje[1] = linje[1].toLowerCase();
            // for aa behandle problemene i reelle data
            if (!linje[1].equals("false")) {
                if (!linje[1].equals("true")) {
                    continue;
                }
            }
            Boolean syk = null;

            if (linje[1].equals("true")) {
                antSyke++;
                syk = true;
            }
            else {
                antFriske++;
                syk = false;
            }

            filListe.put(linje[0], syk);
        }

        return filListe;
    }
}


/**
 * Kjoreksempel med ssh siden pc-en min er for gammel:
 * 
 * [netaugbo@sauron oblig5]$ java Hoved 50
starter subsekvensiering nr 1
starter subsekvensiering nr 2
starter subsekvensiering nr 3
starter subsekvensiering nr 4
starter subsekvensiering nr 5
starter subsekvensiering nr 6
starter subsekvensiering nr 7
starter subsekvensiering nr 8
starter subsekvensiering nr 9
starter subsekvensiering nr 10
starter subsekvensiering nr 11
starter subsekvensiering nr 12
starter subsekvensiering nr 13
starter subsekvensiering nr 14
starter subsekvensiering nr 15
starter subsekvensiering nr 16
starter subsekvensiering nr 17
starter subsekvensiering nr 18
starter subsekvensiering nr 19
starter subsekvensiering nr 20
starter subsekvensiering nr 21
starter subsekvensiering nr 22
starter subsekvensiering nr 23
starter subsekvensiering nr 24
starter subsekvensiering nr 25
starter subsekvensiering nr 26
starter subsekvensiering nr 27
starter subsekvensiering nr 28
starter subsekvensiering nr 29
starter subsekvensiering nr 30
starter subsekvensiering nr 31
starter subsekvensiering nr 32
starter subsekvensiering nr 33
starter subsekvensiering nr 34
starter subsekvensiering nr 35
starter subsekvensiering nr 36
starter subsekvensiering nr 37
starter subsekvensiering nr 38
starter subsekvensiering nr 39
starter subsekvensiering nr 40
starter subsekvensiering nr 41
starter subsekvensiering nr 42
starter subsekvensiering nr 43
starter subsekvensiering nr 44
starter subsekvensiering nr 45
starter subsekvensiering nr 46
starter subsekvensiering nr 47
starter subsekvensiering nr 48
starter subsekvensiering nr 49
starter subsekvensiering nr 50
starter subsekvensiering nr 51
starter subsekvensiering nr 52
starter subsekvensiering nr 53
starter subsekvensiering nr 54
starter subsekvensiering nr 55
starter subsekvensiering nr 56
starter subsekvensiering nr 57
starter subsekvensiering nr 58
starter subsekvensiering nr 59
starter subsekvensiering nr 60
starter subsekvensiering nr 61
starter subsekvensiering nr 62
starter subsekvensiering nr 63
starter subsekvensiering nr 64
starter subsekvensiering nr 65
starter subsekvensiering nr 66
starter subsekvensiering nr 67
starter subsekvensiering nr 68
starter subsekvensiering nr 69
starter subsekvensiering nr 70
starter subsekvensiering nr 71
starter subsekvensiering nr 72
starter subsekvensiering nr 73
starter subsekvensiering nr 74
starter subsekvensiering nr 75
starter subsekvensiering nr 76
starter subsekvensiering nr 77
starter subsekvensiering nr 78
starter subsekvensiering nr 79
starter subsekvensiering nr 80
starter subsekvensiering nr 81
starter subsekvensiering nr 82
starter subsekvensiering nr 83
starter subsekvensiering nr 84
starter subsekvensiering nr 85
starter subsekvensiering nr 86
starter subsekvensiering nr 87
starter subsekvensiering nr 88
starter subsekvensiering nr 89
starter subsekvensiering nr 90
starter subsekvensiering nr 91
starter subsekvensiering nr 92
starter subsekvensiering nr 93
starter subsekvensiering nr 94
starter subsekvensiering nr 95
starter subsekvensiering nr 96
starter subsekvensiering nr 97
starter subsekvensiering nr 98
starter subsekvensiering nr 99
starter subsekvensiering nr 100
starter subsekvensiering nr 101
starter subsekvensiering nr 102
starter subsekvensiering nr 103
starter subsekvensiering nr 104
starter subsekvensiering nr 105
starter subsekvensiering nr 106
starter subsekvensiering nr 107
starter subsekvensiering nr 108
starter subsekvensiering nr 109
starter subsekvensiering nr 110
starter subsekvensiering nr 111
starter subsekvensiering nr 112
starter subsekvensiering nr 113
starter subsekvensiering nr 114
starter subsekvensiering nr 115
starter subsekvensiering nr 116
starter subsekvensiering nr 117
starter subsekvensiering nr 118
starter subsekvensiering nr 119
starter subsekvensiering nr 120
ferdig med å starte subsekvensiering
Starter flettetråd nr 0
Starter flettetråd nr 1
Starter flettetråd nr 2
Starter flettetråd nr 3
Starter flettetråd nr 4
Starter flettetråd nr 5
Starter flettetråd nr 6
Starter flettetråd nr 7
Starter flettetråd nr 8
Starter flettetråd nr 9
Starter flettetråd nr 10
Starter flettetråd nr 11
Starter flettetråd nr 12
Starter flettetråd nr 13
Starter flettetråd nr 14
Starter flettetråd nr 15
Starter flettetråd nr 16
Starter flettetråd nr 17
Starter flettetråd nr 18
Starter flettetråd nr 19
Starter flettetråd nr 20
Starter flettetråd nr 21
Starter flettetråd nr 22
Starter flettetråd nr 23
Starter flettetråd nr 24
Starter flettetråd nr 25
Starter flettetråd nr 26
Starter flettetråd nr 27
Starter flettetråd nr 28
Starter flettetråd nr 29
Starter flettetråd nr 30
Starter flettetråd nr 31
Starter flettetråd nr 32
Starter flettetråd nr 33
Starter flettetråd nr 34
Starter flettetråd nr 35
Starter flettetråd nr 36
Starter flettetråd nr 37
Starter flettetråd nr 38
Starter flettetråd nr 39
Starter flettetråd nr 40
Starter flettetråd nr 41
Starter flettetråd nr 42
Starter flettetråd nr 43
Starter flettetråd nr 44
Starter flettetråd nr 45
Starter flettetråd nr 46
Starter flettetråd nr 47
Starter flettetråd nr 48
Starter flettetråd nr 49
Ferdig med fletting
CEW har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: CEW med forekomst: 23
Hos friske : SubSekvens: CEW med forekomst: 18
Det er 5 ganger mer.

CIH har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: CIH med forekomst: 17
Hos friske : SubSekvens: CIH med forekomst: 11
Det er 6 ganger mer.

CMK har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: CMK med forekomst: 8
Hos friske : SubSekvens: CMK med forekomst: 3
Det er 5 ganger mer.

CWF har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: CWF med forekomst: 12
Hos friske : SubSekvens: CWF med forekomst: 7
Det er 5 ganger mer.

CYC har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: CYC med forekomst: 10
Hos friske : SubSekvens: CYC med forekomst: 3
Det er 7 ganger mer.

DWC har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: DWC med forekomst: 16
Hos friske : SubSekvens: DWC med forekomst: 11
Det er 5 ganger mer.

WYC har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: WYC med forekomst: 9
Hos friske : SubSekvens: WYC med forekomst: 4
Det er 5 ganger mer.

FYC har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: FYC med forekomst: 13
Hos friske : SubSekvens: FYC med forekomst: 8
Det er 5 ganger mer.

YCA har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: YCA med forekomst: 14
Hos friske : SubSekvens: YCA med forekomst: 9
Det er 5 ganger mer.

YCH har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: YCH med forekomst: 8
Hos friske : SubSekvens: YCH med forekomst: 3
Det er 5 ganger mer.

HCD har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: HCD med forekomst: 12
Hos friske : SubSekvens: HCD med forekomst: 6
Det er 6 ganger mer.

YEC har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: YEC med forekomst: 10
Hos friske : SubSekvens: YEC med forekomst: 4
Det er 6 ganger mer.

KCI har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: KCI med forekomst: 13
Hos friske : SubSekvens: KCI med forekomst: 4
Det er 9 ganger mer.

MVC har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: MVC med forekomst: 13
Hos friske : SubSekvens: MVC med forekomst: 5
Det er 8 ganger mer.

NCQ har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: NCQ med forekomst: 20
Hos friske : SubSekvens: NCQ med forekomst: 15
Det er 5 ganger mer.

QYC har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: QYC med forekomst: 13
Hos friske : SubSekvens: QYC med forekomst: 8
Det er 5 ganger mer.

RMC har forekommet mer enn 5 ganger mer hos syke enn friske.
Hos syke : SubSekvens: RMC med forekomst: 20
Hos friske : SubSekvens: RMC med forekomst: 6
Det er 14 ganger mer.

Totalt er det 17 subsekvenser som er mer dominante hos syke.

 */