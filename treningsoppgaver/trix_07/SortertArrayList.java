import java.util.ArrayList;

public class SortertArrayList<T extends Comparable<T>> {
    ArrayList<T> liste = new ArrayList<>();

    public void settInn(T data){
        // hvis data er mindre vil verdien fra comparTo være > 0
        for (int i = 0; i < liste.size(); i++){
            if (liste.get(i).compareTo(data) > 0){
                liste.add(i, data);
                return;
            }
        }
        liste.add(data);
    }

    public T hentUtForste(){
        return liste.remove(0);
    }
}
