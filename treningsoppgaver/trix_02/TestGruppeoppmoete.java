class TestGruppeoppmoete {
    public static void main(String[] args) throws Exception {
        Gruppeoppmoete test = new Gruppeoppmoete();
        test.lesInnFil("Gruppeliste.txt");
        test.registrerOppmoete("Nille");
        test.registrerOppmoete("Lisa");
        test.registrerOppmoete("Teodor");
        test.skrivUtOppmoete();
    }
}
