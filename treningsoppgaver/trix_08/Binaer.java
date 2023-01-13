public class Binaer {
    public static void main(String[] args){
        skrivUtBinaer(27);
        System.out.println();
    }

    static void skrivUtBinaer(int n){
        if(n == 0){
          System.out.print(0);
        }
        else {
            // when n = 1 it jumps out
          if(n > 1){
            skrivUtBinaer(n/2);
          }
          System.out.print(n%2);
        }
      }
}
