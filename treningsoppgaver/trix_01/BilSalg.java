public class BilSalg {
    public static void main(String[]args){
        int antallStein;
        Bil steinsT = new Bil("Stein");
        Bil sirisO = new Bil("Siri");
        steinsT.foresporsel();
        sirisO.foresporsel();
        steinsT.foresporsel();
        antallStein = steinsT.finnAntForesp();
        System.out.println("Antall forespørsler på" + " Steins Toyota er " + antallStein);
        System.out.println("Antall forespørsler totalt" + " er nå " + Bil.finnTotal());
    }
}
