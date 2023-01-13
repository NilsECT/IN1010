public class TestStabel {
    private static int antallTester = 0;
    private static int antallPasserte = 0;
    private static int antallFeil = 0;

    public static void main(String[] args) {
        // Disse metodene er identiske med testmetodene i TestLenkeliste
        testTom();
        testEttElement();
        testLeggTilOgFjerningAvFlereElementer();
        testLeggTilPaaIndeks();
        testFjernOgSettMedIndeks();
        testUnntak();
        // Ekstra Stabel-spesifikke tester
        testStabelMetoder();
        System.out.println("\n"+ antallTester + " tester ferdig");
        System.out.println(antallPasserte + " passerte, " + antallFeil + " feil");
    }

    static void testTom() {
        System.out.println("Test tom liste");
        Liste<String> liste = new Stabel<String>();
        sjekk(0, liste.stoerrelse(), "stoerrelse() i tom liste");
    }

    static void testEttElement() {
        System.out.println("\nTest ett element");
        // Her tester vi med Integer, det burde fungere like bra som String
        Liste<Integer> liste = new Stabel<Integer>();
        liste.leggTil(0);
        sjekk(1, liste.stoerrelse(), "stoerrelse() i liste med ett element");
        Integer hentetElement = liste.hent(0);
        sjekk(0, hentetElement, "hent(0) i liste med ett element");
        // hent(0) skal ikke fjerne elementet, la oss sjekke at fjerning fungerer
        Integer fjernetElement = liste.fjern(0);
        sjekk(0, fjernetElement, "fjern(0) i liste med ett element");
        sjekk(0, liste.stoerrelse(), "stoerrelse() etter at eneste element er fjernet");
    }

    static void testLeggTilOgFjerningAvFlereElementer() {
        System.out.println("\nTest leggTil() og fjern() med flere elementer");
        Liste<String> liste = new Stabel<String>();
        liste.leggTil("Element 0");
        liste.leggTil("Element X");
        liste.leggTil("Element X"); // Legg til begge selv om de har samme verdi
        liste.leggTil("Element 3");
        sjekk(4, liste.stoerrelse(), "stoerrelse() i liste med 4 elementer");
        sjekk("Element 0", liste.hent(0), "hent(0) i liste med 4 elementer");
        sjekk("Element 3", liste.hent(3), "hent(3) i liste med 4 elementer");
        sjekk("Element 0", liste.fjern(), "fjern() i liste med 4 elementer");
        sjekk("Element X", liste.fjern(), "fjern() (for andre gang) i liste med 3 elementer");
        sjekk(2, liste.stoerrelse(), "stoerrelse() etter fjerning av 2 av 4 elementer");
    }

    static void testLeggTilPaaIndeks() {
        System.out.println("\nTest leggTil() og leggTil(pos) paa indeks");
        Liste<String> liste = new Stabel<String>();
        liste.leggTil(0, "Element X");
        sjekk("Element X", liste.hent(0), "hent(0) etter leggTil(0, \"Element X\")");
        liste.leggTil("Element A");
        liste.leggTil("Element B");
        liste.leggTil(0, "Foran X");
        liste.leggTil(2, "Foran A");
        // Forventet rekkefolge: Foran X, Element X, Foran A, Element A, Element B
        sjekk("Foran X", liste.hent(0), "hent(0) etter leggTil(0, \"Foran X\")");
        sjekk("Foran A", liste.hent(2), "hent(2) etter flere leggTil med og uten indeks");
        sjekk("Element B", liste.hent(4), "hent(4) etter flere leggTil med og uten indeks");
        liste.leggTil(5, "Bakerst");
        sjekk("Bakerst", liste.hent(5), "hent(5) etter leggTil(5, \"Bakerst\")");
        sjekk(6, liste.stoerrelse(), "stoerrelse() etter leggTil med og uten indeks");
    }

    static void testFjernOgSettMedIndeks() {
        System.out.println("\nTest fjern(pos) og sett(pos, x) med indekser");
        Liste<String> liste = new Stabel<String>();
        liste.leggTil("Element 0");
        liste.leggTil("Element 1");
        liste.leggTil("Element 2");
        liste.leggTil("Element 3");
        liste.leggTil("Element 4");
        liste.sett(0, "nyVerdi 0");
        liste.sett(2, "nyVerdi 2");
        sjekk("nyVerdi 0", liste.hent(0), "hent(0) etter sett(0, \"nyVerdi 0\")");
        sjekk("nyVerdi 2", liste.hent(2), "hent(2) etter sett(2, \"nyVerdi 2\")");
        sjekk("Element 3", liste.fjern(3), "fjern(3)");
        sjekk("Element 4", liste.fjern(3), "fjern(3) for andre gang");
        liste.leggTil("NyttElement");
        sjekk("NyttElement", liste.hent(3), "hent(3) skal hente nytt element lagt til etter at andre elementer har blitt fjernet");
        sjekk(4, liste.stoerrelse(), "stoerrelse() etter flere kall paa fjern() og leggTil()");
    }

    static void testUnntak() {
        System.out.println("\nTest unntak");
        Liste<String> liste = new Stabel<String>();
        try {
            liste.fjern(); // skal ikke fungere, men skal kaste et unntak
            // hit kommer vi ikke om det ble kastet et unntak
            sjekkFeilet("fjern() paa tom liste skulle kastet unntak");
        } catch(UgyldigListeIndeks e) {
            sjekkPasserte();
        }

        try {
            liste.fjern(0);
            sjekkFeilet("fjern(0) paa tom liste skulle kastet unntak");
        } catch(UgyldigListeIndeks e) {
            sjekkPasserte();
        }

        try {
            liste.hent(0);
            sjekkFeilet("hent(0) paa tom liste skulle kastet unntak");
        } catch(UgyldigListeIndeks e) {
            sjekkPasserte();
        }

        try {
            liste.sett(0, "asd");
            sjekkFeilet("sett(0, ...) paa tom liste skulle kastet unntak");
        } catch(UgyldigListeIndeks e) {
            sjekkPasserte();
        }

        try {
            liste.leggTil(1, "asd");
            sjekkFeilet("leggTil(1, ...) paa tom liste skulle kastet unntak - kun indeks 0 er gyldig i tom liste");
        } catch(UgyldigListeIndeks e) {
            sjekkPasserte();
        }

        liste.leggTil("Forste element");
        liste.leggTil(1, "Andre element"); // Sette inn bakerst skal fungere
        try {
            liste.fjern(2);
            sjekkFeilet("fjern(2) paa liste med 2 elementer skulle kastet unntak");
        } catch(UgyldigListeIndeks e) {
            sjekkPasserte();
        }

        try {
            liste.hent(2);
            sjekkFeilet("hent(2) paa liste med 2 elementer skulle kastet unntak");
        } catch(UgyldigListeIndeks e) {
            sjekkPasserte();
        }

        try {
            liste.sett(2, "2 er ugyldig indeks");
            sjekkFeilet("sett(2, ...) paa liste med 2 elementer skulle kastet unntak");
        } catch(UgyldigListeIndeks e) {
            sjekkPasserte();
        }

        try {
            liste.leggTil(3, "3 er ugyldig indeks");
            sjekkFeilet("leggTil(3, ...) paa liste med 2 elementer skulle kastet unntak");
        } catch(UgyldigListeIndeks e) {
            sjekkPasserte();
        }

        try {
            liste.fjern(-1);
            sjekkFeilet("fjern(-1) skal kaste unntaket UgyldigListeIndeks");
        } catch(UgyldigListeIndeks e) {
            sjekkPasserte();
        }

        try {
            liste.hent(-1);
            sjekkFeilet("hent(-1) skal kaste unntaket UgyldigListeIndeks");
        } catch(UgyldigListeIndeks e) {
            sjekkPasserte();
        }

        try {
            liste.sett(-1, "-1 er en ugyldig indeks!");
            sjekkFeilet("sett(-1, ...) skal kaste unntaket UgyldigListeIndeks");
        } catch(UgyldigListeIndeks e) {
            sjekkPasserte();
        }

        try {
            liste.leggTil(-1, "-1 er en ugyldig indeks!");
            sjekkFeilet("leggTil(-1, ...) skal kaste unntaket UgyldigListeIndeks");
        } catch(UgyldigListeIndeks e) {
            sjekkPasserte();
        }
    }

    static void testStabelMetoder() {
        Stabel<String> stabel = new Stabel<String>();
        System.out.println("\nTest stabel-spesifikke metoder leggPaa og taAv");
        stabel.leggPaa("Element 0");
        stabel.leggPaa("Element 1");
        stabel.leggPaa("Element 2");
        sjekk("Element 2", stabel.hent(2), "hent(2) paa stabel med 3 elementer");
        sjekk(3, stabel.stoerrelse(), "stoerrelse paa stabel med 3 elementer");
        sjekk("Element 2", stabel.taAv(), "taAv() paa stabel med 3 elementer");
        sjekk("Element 1", stabel.taAv(), "taAv() paa stabel for andre gang");
        sjekk(1, stabel.stoerrelse(), "stoerrelse() paa stabel etter at taAv() har blitt kalt");
        sjekk("Element 0", stabel.taAv(), "taAv() paa stabel med ett element");
        sjekk(0, stabel.stoerrelse(), "stoerrelse() paa stabel som har blitt tom etter flere taAv()");

        try {
            stabel.taAv();
            sjekkFeilet("taAv() paa tom stabel skal kaste et unntak");
        } catch(UgyldigListeIndeks e) {
            sjekkPasserte();
        }
    }

    static void sjekk(Object forventet, Object faktisk, String testmelding) {
        if (forventet.equals(faktisk)) {
            sjekkPasserte();
        } else {
            sjekkFeilet(testmelding);
            System.out.println("  > Forventet verdi: " + forventet);
            System.out.println("  > Faktisk verdi: " + faktisk);
        }
    }

    static void sjekkPasserte() {
        antallTester++;
        antallPasserte++;
        System.out.println("- Test " + antallTester + ": OK");
    }

    static void sjekkFeilet(String testmelding) {
        antallTester++;
        antallFeil++;
        System.out.println("- Test " + antallTester + " feilet: " + testmelding);
    }
}

/**
 * kjoreeksempel:
 * ~/Documents/Studies/Bachelor/IN/in1010/innleveringer/oblig3/2021$ java TestStabel 
Test tom liste
- Test 1: OK

Test ett element
- Test 2: OK
- Test 3: OK
- Test 4: OK
- Test 5: OK

Test leggTil() og fjern() med flere elementer
- Test 6: OK
- Test 7: OK
- Test 8: OK
- Test 9: OK
- Test 10: OK
- Test 11: OK

Test leggTil() og leggTil(pos) paa indeks
- Test 12: OK
- Test 13: OK
- Test 14: OK
- Test 15: OK
- Test 16: OK
- Test 17: OK

Test fjern(pos) og sett(pos, x) med indekser
- Test 18: OK
- Test 19: OK
- Test 20: OK
- Test 21: OK
- Test 22: OK
- Test 23: OK

Test unntak
- Test 24: OK
- Test 25: OK
- Test 26: OK
- Test 27: OK
- Test 28: OK
- Test 29: OK
- Test 30: OK
- Test 31: OK
- Test 32: OK
- Test 33: OK
- Test 34: OK
- Test 35: OK
- Test 36: OK

Test stabel-spesifikke metoder leggPaa og taAv
- Test 37: OK
- Test 38: OK
- Test 39: OK
- Test 40: OK
- Test 41: OK
- Test 42: OK
- Test 43: OK
- Test 44: OK

44 tester ferdig
44 passerte, 0 feil

 */