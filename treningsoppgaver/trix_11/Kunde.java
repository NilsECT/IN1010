import java.util.concurrent.CountDownLatch;

public class Kunde implements Runnable {
    CountDownLatch latch;
    private String navn;
    Postkontor postkontor;
    public boolean kjor = true;

    public Kunde(String navn, Postkontor postkontor, CountDownLatch latch){
        this.navn = navn;
        this.postkontor = postkontor;
        this.latch = latch;
    }

    public String hentNavn(){
        return this.navn;
    }

    public void run(){
        while (kjor){
            Post post = postkontor.hentPost(this.navn);
            if (post != null){
                System.out.println(post);
            }
        }
        this.latch.countDown();
    }
}
