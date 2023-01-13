import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class HunderPersoner {
    public static void main(String[] args) throws Exception {
        Scanner fil = new Scanner(new File("navn.txt"));

        ArrayList<Personer> personer = new ArrayList<>();
        ArrayList<Hund> hunder = new ArrayList<>();

        while (fil.hasNextLine()){
            String part = fil.nextLine();
            String[] parts = part.split(" ");

            if (parts[0].equals("H")){
                String navn = "";

                for (int i = 1; i < parts.length; i++){
                    navn += parts[i] + " ";
                }

                Hund h = new Hund(navn);
                hunder.add(h);

            } else if (parts[0].equals("P")){
                String navn = "";

                for (int i = 1; i < parts.length; i++){
                    navn += parts[i] + " ";
                }

                Personer p = new Personer(navn);
                personer.add(p);
            }
        }

        System.out.println("Liste med personer:");
        for (Personer p : personer){
            System.out.println(p.getNavn());
        }
        
        System.out.println("");

        System.out.println("Liste med hunder:");
        for (Hund h : hunder){
            System.out.println(h.getNavn());
        }
    }
}
