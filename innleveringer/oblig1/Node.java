import java.util.ArrayList;


public class Node {
    protected ArrayList<Integer> prosessorer = new ArrayList<>();
    protected int gigabyte;
    protected String navn;

    public Node(String navn,int prosessor, int gb){
        this.navn = navn;

        // sjekker om gb er positivt
        if (gb > 0){
            gigabyte = gb;
        } else {
            System.out.println("Du må sette inn et positivt heltall for gb!");
        }
        // sjekker om det er et gyldig antall prosessorer
        // maks 2 professorer etter oppgaveteksten
        if (prosessor <= 2 && prosessor >= 0){
            for (int i = 0; i < prosessor; i++) {
                prosessorer.add(i);
            }
        } else {
            System.out.println("Du kan bare legge til maks 2 prosessorer!");
        }
    }

    // metode for å vite om det er plass til flere prosessorer
    public boolean plassProsessor(){
        if (prosessorer.size() > 1){
            return false;
        } return true;
    }

    // legger til en prosessor om gangen
    public void leggTilProsessor(){
        if (plassProsessor() == true){
            prosessorer.add(prosessorer.size());
        }
        else {
            System.out.println("Det er ikke plass til flere prosessorer i denne noden");
        }
    }

    // fjerner en prosessor om gangen
    public void fjernProsessor(){
        if (prosessorer.isEmpty()){
            System.out.println("Det er ingen prosessorer på denne noden!");
        }
        else {
            prosessorer.remove(prosessorer.size() - 1);
        }
    }

    public int getGb(){
        return gigabyte;
    }

    public void printInfoNode(){
        System.out.println("Navn på node: " + navn);
        System.out.println("Antall prosessorer: " + prosessorer.size());
        System.out.println("Gigabyte: " + gigabyte);
    }

    public String hentNavn(){
        return navn;
    }

    public int antProsessor(){
        return prosessorer.size();
    }
}