public class BokstavTeller implements Runnable {
    private char bokstav;
    private  BokstavMonitor monitor;

    public BokstavTeller(BokstavMonitor monitor){
        this.monitor = monitor;
        this.bokstav = monitor.hentBokstav();
    }

    public void run(){
        int antForkomster = 0;
        String ord = monitor.hentOrd();
        while (ord != null){
            String ordLower = ord.toLowerCase();
            for (int i = 0; i < ord.length(); i++){
                if (ordLower.charAt(i) == bokstav) {
                    antForkomster++;
                }
            }
            System.out.println("I ordet " + ord + " forekommer bokstaven " + bokstav + antForkomster + " ganger.");
            ord = monitor.hentOrd();
        }
    }
}
