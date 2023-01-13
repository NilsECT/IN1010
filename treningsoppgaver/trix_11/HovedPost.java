import java.util.concurrent.CountDownLatch;

public class HovedPost {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch postmanLatch = new CountDownLatch(1);
        CountDownLatch kundeLatch = new CountDownLatch(2);
        Postkontor postkontor = new Postkontor();

        Postman postman = new Postman(postkontor, postmanLatch);
        Kunde per = new Kunde("Per", postkontor, kundeLatch);
        Kunde jan = new Kunde("Jan", postkontor, kundeLatch);

        Thread traad = new Thread(postman);
        Thread perTraad = new Thread(per);
        Thread janTraad = new Thread(jan);

        traad.start();
        perTraad.start();
        janTraad.start();
        postmanLatch.await();
        per.kjor = false;
        jan.kjor = false;
        kundeLatch.await();
    }
}
