public class Person {
    private Bil3 bil;
    private String navn;    // legger til for oversiktens skyld.

    public Person(String navn, Bil3 bil){
        this.bil = bil;
        this.navn = navn;
    }

    public void skrivBilNummer(){
        System.out.println(navn + " har bil med bilnummer: " + bil.hentNummer());
    }
}
