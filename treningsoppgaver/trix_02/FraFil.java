import java.util.Scanner;
import java.io.File;

class FraFil {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("tekst.txt"));

        String linje = "";
        while (sc.hasNextLine()){
            linje = sc.nextLine();
            System.out.println(linje);
        }
        sc.close();
    }
}
