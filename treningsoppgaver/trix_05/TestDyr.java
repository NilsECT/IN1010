public class TestDyr {
    public static void main(String[] args){
        Rovdyr[] rovdyr = new Rovdyr[2];
        Planteetere[] planteetere = new Planteetere[5];

        Bjorn bjorn = new Bjorn();
        Ulv ulv = new Ulv();
        Elg elg = new Elg();
        Sau sau = new Sau();

        rovdyr[0] = bjorn;
        rovdyr[1] = ulv;

        planteetere[0] = elg;
        planteetere[1] = sau;

        for (int i = 0; i < rovdyr.length; i++){
            if (rovdyr[i] instanceof Rovdyr && planteetere[i] instanceof Planteetere){
                System.out.println("Alt ok hittil.");
            }
            else {
                System.out.println("feil i index " + i);
            }
        }
        System.out.println("Alt gikk bra!");
    }
}
