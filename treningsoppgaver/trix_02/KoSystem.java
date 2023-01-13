import java.util.ArrayList;

public class KoSystem {
    int teller = 0;
    ArrayList<KoLapp> ko = new ArrayList<>();

    //plusser till i telleren og lager et KoLapp objekt som settes inn i arraylisten ko
    public void trekkKoLapp(){
        teller ++;
        KoLapp plass = new KoLapp(teller);
        ko.add(plass);

        System.out.println("Du har fått tildelt billettnr " + plass.hentNummer() + ".");
        System.out.println("Det står " + (ko.size() - 1) + " forran deg.");
    }

    //sjekker om ko er tom, hvis ikke printer den ut den første i listen for så å slette den
    public void betjentKunde(){
        if (ko.isEmpty()){
            System.out.println("Det er ingen flere kunder å betjene akkurat nå.");
        } else {
            System.out.println("Kunde med bilettnr " + ko.get(0).hentNummer() + " er betjent.");
            ko.remove(0);
        }
    }

    //gir lengde på ko
    public int antKunder(){
        return ko.size();
    }

    //printer alle nummer som står i kø i rekkefølge
    public void printKunderIKo(){
        System.out.println("Disse står i kø: ");
        for (KoLapp person : ko){
            System.out.println(person.hentNummer());
        }
    }


}
