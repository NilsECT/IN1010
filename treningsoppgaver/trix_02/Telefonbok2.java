import java.util.ArrayList;

class Telefonbok2 {
    public static void main(String[] args){
        Person jon = new Person("Jon", "22334455", "Oslogate 3");
        Person ada = new Person("Ada", "23456789", "Bestumveien 39");
        Person per = new Person("Per", "99889988", "Tøyenveien 32");

        ArrayList<Person> personer = new ArrayList<>();

        personer.add(jon);
        personer.add(ada);
        personer.add(per);

        for (Person pers : personer){
            pers.skrivInfo();
        }

    }    
}
