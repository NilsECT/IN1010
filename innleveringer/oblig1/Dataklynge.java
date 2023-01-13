import java.util.HashMap;
import java.io.File;
import java.util.Scanner;

public class Dataklynge {
    protected HashMap<String, Rack> rackListe = new HashMap<>();
    protected int maxNoderPerRack;
    protected String navn;

    // konstruktøren henter ut info fra fil
    public Dataklynge(String navn, String filnavn) throws Exception {
        this.navn = navn;
        Scanner fil = new Scanner(new File(filnavn));
        int nodeTeller = 0;
        maxNoderPerRack = Integer.parseInt(fil.nextLine());

        while (fil.hasNextLine()){
            int antNoder;
            int antProsessorer;
            int antMinne;
            String[] linje = fil.nextLine().split(" ");
            antNoder = Integer.parseInt(linje[0]);
            antMinne = Integer.parseInt(linje[1]);
            antProsessorer = Integer.parseInt(linje[2]);

            // lager noder ettersom det filen sier
            for (int i = 0; i < antNoder; i++){
                Node node = new Node("Node" + (nodeTeller +1), antProsessorer, antMinne);
                settNode(node);
                nodeTeller++;
            }
        }
    }

    // metode for å lage rack, kan være en private metode
    public void leggTilNyRack(){
        String navnRack = String.valueOf(rackListe.size());
        Rack nyRack = new Rack(navnRack, maxNoderPerRack);
        rackListe.put(navnRack, nyRack);
    }

    // setter nodene i racks
    public void settNode(Node node){
        boolean plass = false;
        String rackMedPlass = "";

        // sjekker om det er plass i noen av rackene som allerede fins
        for (Rack rack : rackListe.values()){
            if (rack.sjekkPlass() == true){
                rackMedPlass += rack.hentNavn() + " ";
                plass = true;
            }
        }

        // hvis det er plass settes noden inn på den første racken som har plass
        if (plass == true){
            String[] rackSomFaarNode = rackMedPlass.split(" ");
            rackListe.get(rackSomFaarNode[0]).settNode(node);
        }

        // hvis det ikke er plass lages det en ny rack hvor noden settes inn
        else if (plass == false){
            leggTilNyRack();
            for (Rack rack : rackListe.values()){
                if (rack.sjekkPlass() == true){
                    rack.settNode(node);
                }
            }
        }
    }

    public String hentNavn(){
        return navn;
    }

    public int antProsessorer(){
        int antProsessorer = 0;
        for (Rack rack : rackListe.values()){
            antProsessorer += rack.antProsessor();
        }
        return antProsessorer;
    }

    public int getGb(){
        int gb = 0;
        for (Rack rack : rackListe.values()){
            gb += rack.getGb();
        }

        return gb;
    }

    // teller hvor mange noder har påkrevd minne
    public int noderMedNokMinne(int paakrevdMinne){
        int antNoderMedNokMinne = 0;
        for (Rack rack : rackListe.values()){
            antNoderMedNokMinne += rack.NoderMedNokMinne(paakrevdMinne);
        }

        return antNoderMedNokMinne;
    }

    public int antRack(){
        return rackListe.size();
    }
}
