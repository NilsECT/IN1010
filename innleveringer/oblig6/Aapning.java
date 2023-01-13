import java.util.ArrayList;

public class Aapning extends HvitRute {
    
    public Aapning(int rad, int kol) {
        super(rad, kol);
    }

    @Override
    // en aapning betyr at en har naad utgangen
    // veien som er blitt tatt settes da in i labyrint-objektet
    protected void gaa(Labyrint labyrint, ArrayList<Tuppel> veiHittil) {
        brukt();
        vei = new ArrayList<>(veiHittil);
        vei.add(new Tuppel(rad, kol));
        labyrint.settUtvei(vei);
    }
}
