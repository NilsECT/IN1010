import java.util.concurrent.locks.*;

public class Postkontor {
    Post[] post = new Post[10];
    Lock laas = new ReentrantLock();
    Condition ikkeFull = laas.newCondition();
    Condition ikkeTom = laas.newCondition();

    public int storrelse(){
        int storrelse = 0;
        for (int i = 0; i < this.post.length; i++){
            if (this.post[i] != null){
                storrelse++;
            }
        }

        return storrelse;
    }

    public void leverPost(Post post){
        laas.lock();
        try {
            if (storrelse() == 10){
                ikkeFull.await();
            }
            for (int i = 0; i < this.post.length; i++){
                if (this.post[i] == null){
                    this.post[i] = post;
                    ikkeTom.signal();
                    return;
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        finally{
            laas.unlock();
        }
    }

    public Post hentPost(String navn){
        laas.lock();
        try {
            if (storrelse() == 0){
                ikkeTom.await();
            }
            for (int i = 0; i < this.post.length; i++){
                if (this.post[i] != null){
                    if (this.post[i].hentMottaker().equals(navn)){
                        Post ut = this.post[i];
                        this.post[i] = null;
                        ikkeFull.signal();
                        return ut;
                    }
                }
            }
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        finally {
            laas.unlock();
        }
        return null;
    }
}
