class Person {
    private String person;
    private Bil3 bilen;

    public Person(String navn, Bil3 bil){
        person = navn;
        bilen = bil;
    }
    public void hentBilnummer(){
        System.out.println(person + " eier bil med nummer: " + bilen.hentNummer());
    }
}
