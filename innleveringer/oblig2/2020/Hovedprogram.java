public class Hovedprogram {
    public static void main(String[] args) throws UlovligUtskrift{

        // lager tre legemiddler av forskjellige preparat
        Narkotisk a = new Narkotisk("narkostisk", 10, 5, 15);
        Vanedannende b = new Vanedannende("vanedannende", 20, 10, 2);
        Vanlig c = new Vanlig("vanlig legemiddel", 5, 50);

        //lager to typer leger
        // disse skal brukes for å opprette insanser av forskjellige resepter
        Lege lege = new Lege("Lege");
        Spesialist spes = new Spesialist("Spesialist", 1111);
        
    
        // reseptet skal ha id 1
        Resept hvitB = lege.skrivResept(b, 111, 3);
        System.out.println(hvitB.toString() + "\n");

        // skal ha id 2
        Resept blaaC = lege.skrivBlaaResept(c, 112, 2);
        System.out.println(blaaC.toString() + "\n");

        // skal ha id 3
        Resept militaerA = spes.skrivMilitaerResept(a, 113, 4);
        System.out.println(militaerA.toString() + "\n");

        // skal ha id 4
        Resept prevensjonA = spes.skrivPResept(a, 114);
        System.out.println(prevensjonA.toString() + "\n");


        System.out.println(a.toString() + "\n");    // id = 1
        System.out.println(b.toString() + "\n");    // id = 2
        System.out.println(c.toString() + "\n");    // id = 3

        System.out.println(lege.toString() + "\n"); // id = 1
        System.out.println(spes.toString() + "\n"); // id = 2

        // sjekker om UlovligUtskrift implementasjonen fungerer som den skal
        try {
            Resept testA = lege.skrivResept(a, 123, 3);
        }
        catch (UlovligUtskrift e){
            System.out.println(e.getMessage());
        }
    }
}

/**
 * Kjøreeksempel:
 * 
 * Det må sies at all informasjon stemmer, tar litt tid å se over
 * 
 * ~/Documents/Studies/Bachelor/IN/in1010/innleveringer/oblig2$ java Hovedprogram 
Resept av farge: Hvit.
ID: 1.
Utskrevet for pasient med id: 111.
Resept for legemiddel: vanedannende.
Legen som har skrevet ut reseptet er: Lege.
Har 3 bruk igjen.
Gir ingen rabatt.

Resept av farge: Blå.
ID: 2.
Utskrevet for pasient med id: 112.
Resept for legemiddel: vanlig legemiddel.
Legen som har skrevet ut reseptet er: Lege.
Har 2 bruk igjen.
Gir rabatt på 75%.

Resept av farge: Hvit.
Type Hvit resept: Militæresept.
ID: 3.
Utskrevet for pasient med id: 113.
Resept for legemiddel: narkostisk.
Legen som har skrevet ut reseptet er: Spesialist.
Har 4 bruk igjen.
Gir rabatt på 100%.

Resept av farge: Hvit.
Type Hvit resept: P-resept.
ID: 4.
Utskrevet for pasient med id: 114.
Resept for legemiddel: narkostisk.
Legen som har skrevet ut reseptet er: Spesialist.
Har 3 bruk igjen.
Gir rabatt på 108kr.

Narkotisk (PreparatA) med navn: narkostisk.
ID: 1.
Pris: 10.0.
Virkestoff: 5.0.
Narkotisk styrke: 15.

Vanedannende (PreparatB) med navn: vanedannende.
ID: 2.
Pris: 20.0.
Virkestoff: 10.0.
Vanedannende styrke: 2.

Vanlig legemiddel (PreparatC) med navn: vanlig legemiddel.
ID: 3.
Pris: 5.0.
Virkestoff: 50.0.

Lege med navn: Lege.
ID: 1
Kan ikke lage resepter for narkostiske legemiddler.

Spesialist (Lege) med navn: Spesialist.
ID: 2.
KontrollID: 1111.
Kan lage resepter for narkostiske legemiddler.

Legen Lege har ikke lov til å skrive ut narkostisk.


 */
