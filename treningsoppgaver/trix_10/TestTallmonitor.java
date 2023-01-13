public class TestTallmonitor {
    public static void main(String[] args){
        Tallmonitor monitor = new Tallmonitor();
        Thread traadned = new Thread(new Nedover(monitor));
        Thread traadopp = new Thread(new Oppover(monitor));

        traadned.start();
        traadopp.start();
    }
}
