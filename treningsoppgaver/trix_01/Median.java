import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

class Median{
    private static int finnMedian(int[] a){
        Arrays.sort(a); return a[1];
    }
    public static void main(String[] args){
        int[] data = new int[3];
        Scanner fil = null;
        try{
            fil = new Scanner(new File("tall.data"));
        } catch (Exception e) {
            System.exit(1);
        }
        for (int i = 0; i < 3; i++){
            data[i] = fil.nextInt();
        }
        System.out.println("Medianen er " + finnMedian(data));
    }
}