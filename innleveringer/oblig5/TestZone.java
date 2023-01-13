import java.util.ArrayList;

public class TestZone {
    public static void main(String[] args) {
        String test = "ABCDEFG";
        int subLengde = 3;
        ArrayList<String> liste = new ArrayList<>();
        for (int i = 0; i + subLengde <= test.length(); i++) {
            liste.add(test.substring(i, i+subLengde));
        }

        for (String sub : liste) {
            System.out.println(sub);
        }
    }
}
