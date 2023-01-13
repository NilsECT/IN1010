import java.util.ArrayList;

public class Aapning extends HvitRute {
    
    public Aapning(int rad, int kol) {
        super(rad, kol);
    }

    @Override
    // en aapning betyr at en har naad utgangen
    // veien som er blitt tatt settes da in i labyrint-objektet
    protected void gaa(Labyrint labyrint, ArrayList<Rute> veiHittil) {
        besokt = true;
        vei = new ArrayList<>(veiHittil);
        vei.add(this);
        labyrint.settUtvei(vei);
        besokt = false;
    }
}
