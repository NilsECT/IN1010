public class Trekant extends Figur {
    private double hoyde;
    private double grunnlinje;

    public Trekant(double hoyde, double grunnlinje){
        this.hoyde = hoyde;
        this.grunnlinje = grunnlinje;
    }

    public double areal(){
        return (hoyde * grunnlinje) / 2;
    }
}
