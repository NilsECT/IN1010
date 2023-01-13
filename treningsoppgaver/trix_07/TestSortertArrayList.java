public class TestSortertArrayList {
    public static void main(String[] args){
        SortertArrayList<Katt> katteliste = new SortertArrayList<>();


        Katt per = new Katt("Per", 12);
        Katt peder = new Katt("Peder", 2);
        Katt petter = new Katt("Petter", 31);
        Katt pedro = new Katt("Pedro", 21);

        katteliste.settInn(per);
        katteliste.settInn(peder);
        katteliste.settInn(petter);
        katteliste.settInn(pedro);

        for (int i = 0; i < 4; i++){
            System.out.println(katteliste.hentUtForste());
        }
    }
}
