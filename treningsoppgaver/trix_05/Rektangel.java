public class Rektangel implements Figur {
    private double hoyde;
    private double bredde;

    public Rektangel(double hoyde, double bredde){
        this.hoyde = hoyde;
        this.bredde = bredde;
    }

    @Override
    public double beregnAreal(){
        return hoyde * bredde;
    }

    @Override
    public double beregnOmkrets(){
        return 2 * (hoyde + bredde);
    }
    
}
