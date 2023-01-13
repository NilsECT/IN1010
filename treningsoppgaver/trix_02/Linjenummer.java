import java.util.Scanner;
import java.io.File;

class Linjenummer {
    public static void main(String[] args)throws Exception{
        Scanner fil = new Scanner(new File("MaryLamb.txt"));

        while (fil.hasNextLine()){
            String linje = "# 1: " + fil.nextLine();
            System.out.println(linje);
        }
        fil.close();
    }
}
