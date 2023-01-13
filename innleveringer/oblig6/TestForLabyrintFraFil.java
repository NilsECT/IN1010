import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestForLabyrintFraFil {
    public static void main(String[] args) throws FileNotFoundException {
        Labyrint labyrint = new Labyrint("3.in");
        
        ArrayList<ArrayList<Tuppel>> liste = labyrint.finnUtveiFra(5, 3);

        for (ArrayList<Tuppel> utvei : liste) {
            for (Tuppel pos : utvei) {
                System.out.print(pos);
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}
