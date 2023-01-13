import java.util.concurrent.CountDownLatch;

public class Postman implements Runnable {
    Postkontor postkontor;
    CountDownLatch latch;

    public Postman(Postkontor postkontor, CountDownLatch latch){
        this.postkontor = postkontor;
        this.latch = latch;
    }

    public void run(){
        for (int i = 1; i < 101; i++){
            if (i % 2 == 0){
                postkontor.leverPost(new Post("post nr: " + i, "Per"));
            }
            else {
                postkontor.leverPost(new Post("post nr: " + i, "Jan"));
            }
        }
        this.latch.countDown();
    }
    
}
