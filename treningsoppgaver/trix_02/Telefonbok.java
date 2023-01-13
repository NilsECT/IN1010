import java.util.HashMap;
import java.util.Scanner;

class Telefonbok {
    public static void main(String[] args){
        HashMap<String, String> telefonbok = new HashMap<>();
        
        telefonbok.put("Arne", "22334455");
        telefonbok.put("Lisa", "95959595");
        telefonbok.put("Jonas", "97959795");
        telefonbok.put("Peder", "12345678");

        Scanner sc = new Scanner(System.in);

        System.out.println("Hvem vil du ha nummeret til?");
        String navn = sc.nextLine();

        if (telefonbok.containsKey(navn)){
            String tlf = telefonbok.get(navn);
            System.out.println(navn + " har nummer: " + tlf);
        } else {
            System.out.println("Fant ikke " + navn + " i telefonboken.");
        }
        sc.close();

        System.out.println("Oversikt:");
        for (String navnekey : telefonbok.keySet()){
            System.out.println("Navn: " + navnekey + ", tlf: " + telefonbok.get(navnekey));
        }
    }
}
