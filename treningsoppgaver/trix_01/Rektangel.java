class Rektangel {
    double bredde;
    double lengde;

    public Rektangel(double l, double b){
        bredde = b;
        lengde = l;
    }
    public void oekLengde(int okning){
        lengde += okning;
    }
    public void oekBredde(int okning){
        bredde += okning;
    }
    public double areal(){
        return bredde * lengde;
    }
    public double omkrets(){
        return (bredde * 2) + (lengde * 2);
    }
    public void reduserBredde(int reduser){
        if ((bredde - reduser) < 1){
            System.out.println("Bredden kan ikke reduseres med så mye!");
        }
        else {
            bredde = bredde - reduser;
        }
    }
    public void reduserLengde(int reduser){
        if ((lengde - reduser) < 1) {
            System.out.println("Lengden kan ikke reduseres med så mye!");
        }
        else {
            lengde = lengde -reduser;
        }
    }
}
