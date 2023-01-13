public class Rektangel extends Figur {
    private double hoyde;
    private double lengde;

    public Rektangel(double hoyde, double lengde){
        this.hoyde = hoyde;
        this.lengde = lengde;
    }

    public double areal(){
        return hoyde*lengde;
    }
}
