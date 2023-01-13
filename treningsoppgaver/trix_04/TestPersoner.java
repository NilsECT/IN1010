public class TestPersoner {
    public static void main(String[] args){
        BachelorStudent bachStud = new BachelorStudent("Liv", 22, "MAT1100", "UiO");
        MasterStudent masterstud = new MasterStudent("Ann", 19, "AST1010", "UiO");

        Professor prof = new Professor("Arne", 58, 350, "Algebra", "MAT1100");
        Forsker forsker = new Forsker("Per", 44, 250, "Kjernefysikk");

        Ansatt ansatt = new Professor("Grete", 34, 350, "Statsvitenskap", "SV1100");

        bachStud.skrivInformasjon();
        masterstud.skrivInformasjon();
        prof.skrivInformasjon();
        forsker.skrivInformasjon();
        ansatt.skrivInformasjon();
    }
}
