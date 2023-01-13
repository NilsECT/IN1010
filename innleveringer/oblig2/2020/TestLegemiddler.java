public class TestLegemiddler {
    public static void main(String[] args){
        Narkotisk a = new Narkotisk("narkostisk", 10, 5, 15);
        Vanedannende b = new Vanedannende("vanedannende", 20, 10, 2);
        Vanlig c = new Vanlig("vanlig legemiddel", 5, 50);

        // tester først PrepratA

        // sjekker id, siden a ble laget først må den være 1
        if (a.hentId() == 1){
            System.out.println("Id til Narkotisk er riktig.");
        }
        else {
            System.out.println("Id til Narkotisk er feil.");
        }

        // sjekker navn
        if (a.hentNavn().equals("narkostisk")){
            System.out.println("Navn til Narkotisk er riktig.");
        }
        else {
            System.out.println("Navn til Narkotisk er feil.");
        }

        // sjekker pris
        if (a.hentPris() == 10.0){
            System.out.println("Pris til Narkotisk er riktig.");
        }
        else {
            System.out.println("Pris til Narkotisk er feil.");
        }

        // sjekker virkestoff
        if (a.hentVirkestoff() == 5.0){
            System.out.println("Virkestoff til Narkotisk er riktig.");
        }
        else {
            System.out.println("Virkestoff til Narkotisk er feil.");
        }

        // sjekker styrke
        if (a.hentNarkotiskStyrke() == 15){
            System.out.println("Narkotisk styrke til Narkotisk er riktig.");
        }
        else {
            System.out.println("Narkotisk styrke til Narkotisk er feil.");
        }


        // tester nå Vanedannende

        // sjekker id, siden b ble laget etter a må den være 2
        if (b.hentId() == 2){
            System.out.println("Id til Vanedannende er riktig.");
        }
        else {
            System.out.println("Id til Vanedannende er feil.");
        }

        // sjekker navn
        if (b.hentNavn().equals("vanedannende")){
            System.out.println("Navn til Vanedannende er riktig.");
        }
        else {
            System.out.println("Navn til Vanedannende er feil.");
        }

        // sjekker pris
        if (b.hentPris() == 20.0){
            System.out.println("Pris til Vanedannende er riktig.");
        }
        else {
            System.out.println("Pris til Vanedannende er feil.");
        }

        // sjekker virkestoff
        if (b.hentVirkestoff() == 10.0){
            System.out.println("Virkestoff til Vanedannende er riktig.");
        }
        else {
            System.out.println("Virkestoff til Vanedannende er feil.");
        }

        // sjekker styrke
        if (b.hentVanedannendeStyrke() == 2){
            System.out.println("Vanedannende styrke til Vanedannende er riktig.");
        }
        else {
            System.out.println("Vanedannende styrke til Vanedannende er feil.");
        }


        // sjekker til sist Vanlig

        // sjekker id, siden c ble laget etter b må den være 3
        if (c.hentId() == 3){
            System.out.println("Id til Vanlig er riktig.");
        }
        else {
            System.out.println("Id til Vanlig er feil.");
        }

        // sjekker navn
        if (c.hentNavn().equals("vanlig legemiddel")){
            System.out.println("Navn til Vanlig er riktig.");
        }
        else {
            System.out.println("Navn til Vanlig er feil.");
        }

        // sjekker pris
        if (c.hentPris() == 5.0){
            System.out.println("Pris til Vanlig er riktig.");
        }
        else {
            System.out.println("Pris til Vanlig er feil.");
        }

        // sjekker virkestoff
        if (c.hentVirkestoff() == 50.0){
            System.out.println("Virkestoff til Vanlig er riktig.");
        }
        else {
            System.out.println("Virkestoff til Vanlig er feil.");
        }
    }
}



/**
 * Kjøreeksempel:
 * 
 * ~/Documents/Studies/Bachelor/IN/in1010/innleveringer/oblig2$ java TestLegemiddler 
Id til Narkotisk er riktig.
Navn til Narkotisk er riktig.
Pris til Narkotisk er riktig.
Virkestoff til Narkotisk er riktig.
Narkotisk styrke til Narkotisk er riktig.
Id til Vanedannende er riktig.
Navn til Vanedannende er riktig.
Pris til Vanedannende er riktig.
Virkestoff til Vanedannende er riktig.
Vanedannende styrke til Vanedannende er riktig.
Id til Vanlig er riktig.
Navn til Vanlig er riktig.
Pris til Vanlig er riktig.
Virkestoff til Vanlig er riktig.

 */