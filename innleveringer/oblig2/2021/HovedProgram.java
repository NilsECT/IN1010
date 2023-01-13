public class HovedProgram {
    public static void main(String[] args){
        // lager tre legemiddler av forskjellige preparat
        Narkotisk a = new Narkotisk("narkostisk", 10, 5, 15);
        Vanedannende b = new Vanedannende("vanedannende", 20, 10, 2);
        Vanlig c = new Vanlig("vanlig legemiddel", 5, 50);

        //lager to typer leger
        Lege lege = new Lege("Lege");
        Spesialist spes = new Spesialist("Spesialist", "1111");
        
        // Lager Reseptene
        HvitResept hvitB = new HvitResept(b, lege, 111, 3);
        BlaaResept blaaC = new BlaaResept(c, lege, 112, 2);
        MilitaerResept militaerA = new MilitaerResept(a, spes, 113, 4);
        PResept prevensjonA = new PResept(a, spes, 114);

        // printer ut infoen og leser saa om det stemmer
        System.out.println(a.toString());   // id 1
        System.out.println();
        System.out.println(b.toString());   // id 2
        System.out.println();
        System.out.println(c.toString());   // id 3
        System.out.println();
        System.out.println(lege.toString());    // id = 1
        System.out.println();
        System.out.println(spes.toString());    // id = 2
        System.out.println();
        System.out.println(hvitB.toString());   // id = 1
        System.out.println();
        System.out.println(blaaC.toString());   // id = 2
        System.out.println();
        System.out.println(militaerA.toString());   // id = 3
        System.out.println();
        System.out.println(prevensjonA.toString()); // id = 4
    }
}

/**
 * kjoreeksempel : 
 * ~/Documents/Studies/Bachelor/IN/in1010/innleveringer/oblig2/2021$ java HovedProgram 
Narkotisk (PreparatA) med navn: narkostisk.
ID: 1.
Pris: 10.
Virkestoff: 5.0.
Narkotisk styrke: 15.

Vanedannende (PreparatB) med navn: vanedannende.
ID: 2.
Pris: 20.
Virkestoff: 10.0.
Vanedannende styrke: 2.

Vanlig legemiddel (PreparatC) med navn: vanlig legemiddel.
ID: 3.
Pris: 5.
Virkestoff: 50.0.

Lege med navn: Lege.
ID: 1
Kan ikke lage resepter for narkostiske legemiddler.

Spesialist (Lege) med navn: Spesialist.
ID: 2.
KontrollID: 1111.
Kan lage resepter for narkostiske legemiddler.

Resept av farge: hvit.
ID: 1.
Utskrevet for pasient med id: 111.
Resept for legemiddel: vanedannende.
Legen som har skrevet ut reseptet er: Lege.
Har 3 bruk igjen.
Gir ingen rabatt.

Resept av farge: blaa.
ID: 2.
Utskrevet for pasient med id: 112.
Resept for legemiddel: vanlig legemiddel.
Legen som har skrevet ut reseptet er: Lege.
Har 2 bruk igjen.
Gir rabatt paa 75%.

Resept av farge: hvit.
Type hvit resept: Militaeresept.
ID: 3.
Utskrevet for pasient med id: 113.
Resept for legemiddel: narkostisk.
Legen som har skrevet ut reseptet er: Spesialist.
Har 4 bruk igjen.
Gir rabatt paa 100%.

Resept av farge: hvit.
Type hvit resept: P-resept.
ID: 4.
Utskrevet for pasient med id: 114.
Resept for legemiddel: narkostisk.
Legen som har skrevet ut reseptet er: Spesialist.
Har 3 bruk igjen.
Gir rabatt paa 108kr.

 */
