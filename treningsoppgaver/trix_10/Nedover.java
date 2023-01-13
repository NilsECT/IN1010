public class Nedover implements Runnable {
    private int tall;
    private Tallmonitor monitor;

    public Nedover(Tallmonitor monitor){
        this.monitor = monitor;
        tall = 1000;
    }

    public void run(){
        while (monitor.settStorste(tall)){
            System.out.println(tall);
            tall--;
        }
        System.out.println("STOP! Tallet er ikke storst lenger: " + tall);
    }
}
