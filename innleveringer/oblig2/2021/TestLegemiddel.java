public class TestLegemiddel {
    public static void main(String[] args){
        Vanedannende vane = new Vanedannende("vane", 100, 10.5, 5); // id = 1
        Narkotisk nark = new Narkotisk("nark", 200, 5., 10);    // id = 2
        Vanlig vanlig = new Vanlig("vanlig", 50, 20.);  // id = 3

        // tester vanlig forst
        if (vanlig.hentId() == 3){
            System.out.println("Vanlig sin ID: OK");
        }
        else {
            System.out.println("Vanlig sitt ID : FEIL");
        }

        if (vanlig.hentNavn().compareTo("vanlig") == 0){
            System.out.println("Vanlig sitt NAVN : OK");
        }
        else {
            System.out.println("Vanlig sitt NAVN : FEIL");
        }

        if (vanlig.hentPris() == 50){
            System.out.println("Vanlig sin PRIS : OK");
        }
        else {
            System.out.println("Vanlig sin PRIS : FEIL");
        }

        if (vanlig.hentVirkestoff() == 20.){
            System.out.println("Vanlig sitt VIRKESTOFF : OK");
        }
        else {
            System.out.println("Vanlig sitt VIRKESTOFF : FEIL");
        }

        vanlig.settNyPris(500);
        if (vanlig.hentPris() == 500){
            System.out.println("vanlig sin NYE PRIS : OK");
        }
        else {
            System.out.println("vanlig sin NYE PRIS : FEIL");
        }
        // tester vanedannende
        if (vane.hentId() == 1){
            System.out.println("vanedannende sin ID : OK");
        }
        else {
            System.out.println("vanedannende sin ID : FEIL");
        }

        if (vane.hentNavn().compareTo("vane") == 0){
            System.out.println("vanedannende sitt NAVN : OK");
        }
        else {
            System.out.println("vanedannende sitt NAVN : FEIL");
        }

        if (vane.hentPris() == 100){
            System.out.println("vanedannende sin PRIS : OK");
        }
        else {
            System.out.println("vanedannende sin PRIS : FEIL");
        }

        if (vane.hentVirkestoff() == 10.5){
            System.out.println("vanedannende sitt VIRKESTOFF: OK");
        }
        else {
            System.out.println("vanedannende sitt VIRKESTOFF: FEIL");
        }

        if (vane.hentVanedannendeStyrke() == 5){
            System.out.println("vanedannende sin STYRKE: OK");
        }
        else {
            System.out.println("vanedannende sin STYRKE: FEIL");
        }

        vane.settNyPris(1000);
        if (vane.hentPris() == 1000){
            System.out.println("vane sin NYE PRIS : OK");
        }
        else {
            System.out.println("vane sin NYE PRIS : FEIL");
        }
        // tester narkotisk
        if (nark.hentId() == 2){
            System.out.println("narkotisk sin ID : OK");
        }
        else {
            System.out.println("narkotisk sin ID : FEIL");
        }

        if (nark.hentNavn().compareTo("nark") == 0){
            System.out.println("narkotisk sitt NAVN : OK");
        }
        else {
            System.out.println("narkotisk sitt NAVN : FEIL");
        }

        if (nark.hentPris() == 200){
            System.out.println("narkotisk sin PRIS : OK");
        }
        else {
            System.out.println("narkotisk sin PRIS : FEIL");
        }

        if (nark.hentVirkestoff() == 5.){
            System.out.println("narkotisk sitt VIRKESTOFF: OK");
        }
        else {
            System.out.println("narkotisk sitt VIRKESTOFF: FEIL");
        }

        if (nark.hentNarkotiskStyrke() == 10){
            System.out.println("narkotisk sin STYRKE: OK");
        }
        else {
            System.out.println("narkotisk sin STYRKE: FEIL");
        }

        nark.settNyPris(1500);
        if (nark.hentPris() == 1500){
            System.out.println("nark sin NYE PRIS : OK");
        }
        else {
            System.out.println("nark sin NYE PRIS : FEIL");
        }
    }
}

/**
 * kjoreeksempel
 * ~/Documents/Studies/Bachelor/IN/in1010/innleveringer/oblig2/2021$ java TestLegemiddel 
Vanlig sin ID: OK
Vanlig sitt NAVN : OK
Vanlig sin PRIS : OK
Vanlig sitt VIRKESTOFF : OK
vanlig sin NYE PRIS : OK
vanedannende sin ID : OK
vanedannende sitt NAVN : OK
vanedannende sin PRIS : OK
vanedannende sitt VIRKESTOFF: OK
vanedannende sin STYRKE: OK
vane sin NYE PRIS : OK
narkotisk sin ID : OK
narkotisk sitt NAVN : OK
narkotisk sin PRIS : OK
narkotisk sitt VIRKESTOFF: OK
narkotisk sin STYRKE: OK
nark sin NYE PRIS : OK

 */