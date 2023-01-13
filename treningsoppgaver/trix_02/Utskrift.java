public class Utskrift {
    public static void main(String[] args){
        String t = "her er en tekst";
        int tall1 = 3;
        int tall2 = 2;

        utskrift(t);
        utskrift(tall1, tall2);
    }
    
    
    
    public static void utskrift(String tekst){
        System.out.println("Tekst: " + tekst);
    }
    public static void utskrift(int heltall, int heltall2){
        System.out.println("Tallene plusset sammen: " + (heltall + heltall2));
    }
}
