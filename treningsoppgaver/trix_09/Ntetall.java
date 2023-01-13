public class Ntetall {
    public static void main(String[] args){
        for (int i = 0; i < 10; i++){
            new Thread(new MinRun(i, 1000, 10)).start();
        }
    }
}