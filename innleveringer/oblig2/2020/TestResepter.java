public class TestResepter {
    public static void main(String[] args){

        //lager kun to preparat ettersom det allerede er testet
        // en av dem skal ha pris > 108 og den andre pris < 108
        Vanlig legemiddelDyr = new Vanlig("Legemiddel dyr", 150, 3);
        Vanlig legemiddelBillig = new Vanlig("Legemiddel billig", 100, 3);

        // lager kun en lege ettersom det skal ikke brukes til noe annet enn sammenlikning
        Lege utskrivendeLege = new Lege("Lege");

        // lager en instans for hver subklasse til Resept
        // trenger bare to av PResept siden der må rabatten testes mot en pris som er enten over eller under 108
        BlaaResept blaa = new BlaaResept(legemiddelDyr, utskrivendeLege, 11, 3);  // id = 1
        HvitResept hvit = new HvitResept(legemiddelDyr, utskrivendeLege, 12, 3);  // id = 2
        MilitaerResept militaer = new MilitaerResept(legemiddelDyr, utskrivendeLege, 13, 3);  // id = 3
        PResept prevensjonDyr = new PResept(legemiddelDyr, utskrivendeLege, 14);  // id = 4
        PResept prevensjonBillig = new PResept(legemiddelBillig, utskrivendeLege, 15); // id = 5

        // tester først hvit, siden er mest lik Resept
        // tester i rekkefølge som de er i Resept
        
        if (hvit.hentId() == 1){
            System.out.println("Metode hentId() funket.");
        }
        else {
            System.out.println("Metode hentId() funket ikke.");
        }

        
        if (hvit.hentLegemiddel().equals(legemiddelDyr)){
            System.out.println("Metode hentLegemiddel() funket.");
        }
        else {
            System.out.println("Metode hentLegemiddel() funket ikke.");
        }

        
        if (hvit.hentLege().equals(utskrivendeLege)){
            System.out.println("Metode hentLege() funket.");
        }
        else {
            System.out.println("Metode hentLege() funket ikke.");
        }

        
        if (hvit.hentPasientId() == 12){
            System.out.println("Metode hentPasientId funket.");
        }
        else {
            System.out.println("Metode hentPasientId funket ikke.");
        }

        
        if (hvit.hentReit() == 3){
            System.out.println("Metode hentReit() funket.");
        }
        else {
            System.out.println("Metode hentReit() funket ikke.");
        }

        // sjekker her for hver gang den blir brukt
        // gir to utsrkifter for vanlig bruk og for når den er tom
        if (hvit.bruk()){
            System.out.println("Metode bruk() funket.");
            if (hvit.bruk()){

                if (hvit.bruk()){

                    if (!hvit.bruk()){
                        System.out.println("Metode bruk() funket hele veien.");
                    }
                    else {
                        System.out.println("Metode bruk() funket ikke når reit = 0.");
                    }
                }
                else{
                    System.out.println("Metode bruk() funket ikke når reit = 1.");
                }
            }
            else{
                System.out.println("Metode bruk() funket ikke når reit = 2.");
            }

        }
        else{
            System.out.println("Metode bruk() funket ikke når reit = 3.");
        }

        
        if (hvit.farge().equals("Hvit")){
            System.out.println("Metode farge() funket.");
        }
        else {
            System.out.println("Metode farge() funket ikke.");
        }

        
        if (hvit.prisAaBetale() == 150){
            System.out.println("Metode prisAaBetale() funket for hvit.");
        }
        else {
            System.out.println("Metode prisAaBetale() funket ikke for hvit.");
        }

        // tester nå prisen på blaa
        if (blaa.prisAaBetale() == 150*0.25){
            System.out.println("Metode prisAaBetale() funket for blaa.");
        }
        else {
            System.out.println("Metode prisAaBetale() funket ikke for blaa.");
        }

        // tester nå prisen på militaer
        if (militaer.prisAaBetale() == 0){
            System.out.println("Metode prisAaBetale() funket for militaer.");
        }
        else {
            System.out.println("Metode prisAaBetale() funket ikke for militaer.");
        }

        // tester så prisen for PResept
        // pris > 108
        if (prevensjonDyr.prisAaBetale() == 150 - 108){
            System.out.println("Metode prisAaBetale() funket for prevensjonDyr.");
        }
        else {
            System.out.println("Metode prisAaBetale() funket ikke for prevensjonDyr.");
        }

        // pris < 108
        if (prevensjonBillig.prisAaBetale() == 0){
            System.out.println("Metode prisAaBetale() funket for prevensjonBillig.");
        }
        else {
            System.out.println("Metode prisAaBetale() funket ikke for prevensjonBillig.");
        }
    }
}


/**
 * Kjøreksempel:
 * ~/Documents/Studies/Bachelor/IN/in1010/pre_course/oblig2$ java TestResepter 
Metode hentId() funket.
Metode hentLegemiddel() funket.
Metode hentLege() funket.
Metode hentPasientId funket.
Metode hentReit() funket.
Metode bruk() funket.
Metode bruk() funket hele veien.
Metode farge() funket.
Metode prisAaBetale() funket for hvit.
Metode prisAaBetale() funket for blaa.
Metode prisAaBetale() funket for militaer.
Metode prisAaBetale() funket for prevensjonDyr.
Metode prisAaBetale() funket for prevensjonBillig.

 */