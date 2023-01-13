public class IkkeMerPlassException extends Exception {
    
    public IkkeMerPlassException(String boktittel){
        super("Det er ikke mer plass i bokhyllen for å sette inn " + boktittel);
    }
}
