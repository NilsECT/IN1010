public class StudentRegister {
    public static void main(String[] args){
        Person pers, pers2;
        Studente stud, stud2;
        BachelorStudent bachelor, bachelor2;

        pers = new Person();
        stud = new Studente();
        bachelor = new BachelorStudent();

        pers2 = stud;
        bachelor2 = (BachelorStudent) stud;
        stud2 = (BachelorStudent) stud;
        stud2 = (Person) stud;
        stud2 = (Studente) bachelor;
        bachelor = stud2;
    }
}

class Person {}
class Studente extends Person {}
class BachelorStudent extends Studente {}