public class Oppover implements Runnable {
    private int tall;
    private Tallmonitor monitor;

    public Oppover(Tallmonitor monitor){
        this.monitor = monitor;
        tall = -1000;
    }

    public void run(){
        while (monitor.settMinste(tall)){
            System.out.println(tall);
            tall++;
        }
        System.out.println("STOP! Tallet er ikke minst lenger: " + tall);
    }
}
