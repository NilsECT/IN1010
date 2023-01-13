import java.util.ArrayList;

class HovedStudent {
    static ArrayList<Student> alle = new ArrayList<Student>();
    public static void main(String[] args){
        
        Student joakim = new Student("Joakim", 10, 2);
        Student kristin = new Student("Kristin", 14, 2);
        Student dag = new Student("Dag", 10, 1);

        joakim.leggTilQuizScore(7);
        kristin.leggTilQuizScore(6);
        dag.leggTilQuizScore(10);
        joakim.leggTilQuizScore(4);
        kristin.leggTilQuizScore(6);
        dag.leggTilQuizScore(8);

        alle.add(joakim);
        alle.add(kristin);
        alle.add(dag);
        
        for (Student student : alle){
            System.out.println(student.hentNavn() + "har en totalscore på: " + student.hentTotalScore() + ", og gjennomsnittlig score på: " + student.hentGjennomsnittligScore());
        }
    }
}
