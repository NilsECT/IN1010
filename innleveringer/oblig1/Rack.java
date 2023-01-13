import java.util.HashMap;

public class Rack {
    protected HashMap<String, Node> nodeListe = new HashMap<>();
    protected int maxAntNoder;  // skal kunne varieres
    protected String navn;

    public Rack(String navn, int maxAntNoder){
        this.maxAntNoder = maxAntNoder;
        this.navn = navn;
    }

    // setter in en node o det er plass
    public void settNode(Node node){
        if (sjekkPlass() == true){
            nodeListe.put(node.hentNavn(), node);
        }
        else {
            System.out.println("Denne racken er full.");
        }
    }

    // fjerner node, systemet bygges opp fra regneklynge
    public void fjernNode(Node node){
        if (nodeListe.containsKey(node.hentNavn())){
            nodeListe.remove(node.hentNavn());
        }
        else {
            System.out.println("Denne noden er ikke i denne racken.");
        }
    }

    // returnerer true om det er plass
    public boolean sjekkPlass(){
        if (nodeListe.size() < maxAntNoder){
            return true;
        }
        else {
            return false;
        }
    }

    public String hentNavn(){
        return navn;
    }

    // teller antall prosessorer og returner en int
    public int antProsessor(){
        int antProsessor = 0;
        for (Node node : nodeListe.values()){
            antProsessor += node.antProsessor();
        }
        
        return antProsessor;
    }

    public int getGb(){
        int gb = 0;
        for (Node node : nodeListe.values()){
            gb += node.getGb();
        }

        return gb;
    }

    // sjekker minne til noder og sammenligner med det som er påkrevd
    // returnerer int av hvor mange som har påkrevd minne
    public int NoderMedNokMinne(int paakrevdMinne){
        int antNoderMedNokMinne = 0;
        for (Node node : nodeListe.values()){
            if (node.getGb() >= paakrevdMinne){
                antNoderMedNokMinne++;
            }
        }
        return antNoderMedNokMinne;
    }
}
