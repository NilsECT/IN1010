public class HovedFigur {
    public static void main(String[] args){
        Trekant trekant = new Trekant(2, 3);
        Sirkel sirkel = new Sirkel(3);
        Rektangel rekt = new Rektangel(7, 3);
        Firkant fir = new Firkant(4);

        double svar = trekant.areal() + sirkel.areal() + rekt.areal() + fir.areal();
        System.out.println(svar);
    }
}
