public class Zone {
    public static void main(String[] args){
        Vanlig c = new Vanlig("c", 1, 1);

        Legemiddel l = c;
        System.out.println(l.hentId() + l.hentNavn() + l.hentPris());
    }
}
