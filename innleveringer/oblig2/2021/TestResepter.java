public class TestResepter {
    public static void main(String[] args){

        // lager en lege og tre forskjellige legemiddler
        Lege legen = new Lege("legen");
        Vanedannende vane = new Vanedannende("vane", 100, 10.5, 5);
        Narkotisk nark = new Narkotisk("nark", 200, 5., 10);
        Vanlig vanlig = new Vanlig("vanlig", 50, 20.);

        // lager en resept av hver type
        BlaaResept blaa = new BlaaResept(vane, legen, 111, 2);  // Id 1
        HvitResept hvit = new HvitResept(nark, legen, 112, 1);  // Id 2
        MilitaerResept mili = new MilitaerResept(vanlig, legen, 113, 5);    // Id 3
        PResept pResept = new PResept(vane, legen, 114);    // Id 4
        PResept pReseptDyr = new PResept(nark, legen, 115); // Id 5


        // tester blaa
        if (blaa.hentId() == 1){
            System.out.println("blaa sin ID : OK");
        }
        else {
            System.out.println("blaa sin ID : FEIL");
        }

        if (blaa.hentLegemiddel().equals(vane)){
            System.out.println("blaa sin LEGEMIDDEL: OK");
        }
        else {
            System.out.println("blaa sin LEGEMIDDEL: FEIL");
        }

        if (blaa.hentLege().equals(legen)){
            System.out.println("blaa sin LEGE : OK");
        }
        else{
            System.out.println("blaa sin LEGE : FEIL");
        }

        if (blaa.hentPasientId() == 111){
            System.out.println("blaa sin PASIENTID: OK");
        }
        else {
            System.out.println("blaa sin PASIENTID: FEIL");
        }

        if (blaa.hentReit() == 1){
            System.out.println("blaa sin REIT: OK");
        }
        else {
            System.out.println("blaa sin REIT: FEIL");
        }

        if (blaa.bruk()){
            System.out.println("blaa sin FORSTE BRUK: OK");
            if (blaa.hentReit() == 1){
                System.out.println("blaa sin ENDRET FORSTE REIT: OK");
                if (blaa.bruk()){
                    System.out.println("blaa sin ANDRE BRUK: OK");
                    if (blaa.bruk()){
                        // skal vaere false
                        System.out.println("blaa sin SISTE BRUK : FEIL");
                    }
                    else {
                        System.out.println("blaa sin SISTE BRUK : OK-OK");
                    }
                }
                else {
                    System.out.println("blaa sin ANDRE BRUK: FEIL");
                }
            }
            else {
                System.out.println("blaa sin ENDRET ANDRE REIT: FEIL");
            }
        }
        else {
            System.out.println("blaa sin FORSTE BRUK: FEIL");
        }

        if (blaa.farge().compareTo("blaa") == 0){
            System.out.println("blaa sin FARGE : OK");
        }
        else {
            System.out.println("blaa sin FARGE : FEIL");
        }

        int blaaPris = 25;
        if (blaa.prisAaBetale() == blaaPris){
            System.out.println("blaa sin PRIS : OK");
        }
        else {
            System.out.println("blaa sin PRIS : FEIL");
        }



        // tester hvit
        if (hvit.hentId() == 2){
            System.out.println("hvit sin ID : OK");
        }
        else {
            System.out.println("hvit sin ID : FEIL");
        }

        if (hvit.hentLegemiddel().equals(nark)){
            System.out.println("hvit sin LEGEMIDDEL: OK");
        }
        else {
            System.out.println("hvit sin LEGEMIDDEL: FEIL");
        }

        if (hvit.hentLege().equals(legen)){
            System.out.println("hvit sin LEGE : OK");
        }
        else{
            System.out.println("hvit sin LEGE : FEIL");
        }

        if (hvit.hentPasientId() == 112){
            System.out.println("hvit sin PASIENTID: OK");
        }
        else {
            System.out.println("hvit sin PASIENTID: FEIL");
        }

        if (hvit.hentReit() == 2){
            System.out.println("hvit sin REIT: OK");
        }
        else {
            System.out.println("hvit sin REIT: FEIL");
        }

        if (hvit.bruk()){
            System.out.println("hvit sin BRUK: OK");
            if (hvit.hentReit() == 0){
                System.out.println("hvit sin ENDRET REIT : OK");
                if (hvit.bruk()){
                    // skal vaere false
                    System.out.println("hvit sin SISTE BRUK : FEIL");
                }
                else {
                    System.out.println("hvit sin SISTE BRUK : OK-OK");
                }
            }
            else {
                System.out.println("hvit sin ENDRET REIT : FEIL");
            }
        }
        else {
            System.out.println("hvit sin BRUK: FEIL");
        }

        if (hvit.farge().compareTo("hvit") == 0){
            System.out.println("hvit sin FARGE : OK");
        }
        else {
            System.out.println("hvit sin FARGE : FEIL");
        }

        if (hvit.prisAaBetale() == 200){
            System.out.println("hvit sin PRIS : OK");
        }
        else {
            System.out.println("hvit sin PRIS : FEIL");
        }

        // tester militaerResept
        // dens andre metoder er testet med hvit
        if (mili.prisAaBetale() == 0){
            System.out.println("militaer sin PRIS : OK");
        }
        else {
            System.out.println("militaer sin PRIS : FEIL");
        }

        // tester p-resept
        if (pResept.prisAaBetale() == 0){
            System.out.println("PResept sin PRIS : OK");
        }
        else {
            System.out.println("PResept sin PRIS : FEIL");
        }
        if (pReseptDyr.prisAaBetale() == 92){
            System.out.println("PResept sin DYRE PRIS : OK");
        }
        else {
            System.out.println("PResept sin DYRE PRIS : FEIL");
        }
    }
}

/**
 * kjoreeksempel
 * ~/Documents/Studies/Bachelor/IN/in1010/innleveringer/oblig2/2021$ java TestResepter 
blaa sin ID : OK
blaa sin LEGEMIDDEL: OK
blaa sin LEGE : OK
blaa sin PASIENTID: OK
blaa sin REIT: FEIL
blaa sin FORSTE BRUK: OK
blaa sin ENDRET FORSTE REIT: OK
blaa sin ANDRE BRUK: OK
blaa sin SISTE BRUK : OK-OK
blaa sin FARGE : OK
blaa sin PRIS : OK
hvit sin ID : OK
hvit sin LEGEMIDDEL: OK
hvit sin LEGE : OK
hvit sin PASIENTID: OK
hvit sin REIT: FEIL
hvit sin BRUK: OK
hvit sin ENDRET REIT : OK
hvit sin SISTE BRUK : OK-OK
hvit sin FARGE : OK
hvit sin PRIS : OK
militaer sin PRIS : OK
PResept sin PRIS : OK
PResept sin DYRE PRIS : OK

 */