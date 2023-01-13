public class Student {
    private String navn;
    private int quizScore;
    private int deltatt;

    public Student(String navn, int quizScore, int deltatt){
        navn = this.navn;
        quizScore = this.quizScore;
        deltatt = this.deltatt;
    }

    public String hentNavn(){
        return navn;
    }

    public void leggTilQuizScore(int score){
        quizScore += score;
        deltatt ++;
    }

    public int hentTotalScore(){
        return quizScore;
    }

    public int hentGjennomsnittligScore(){
        return quizScore/deltatt;
    }
}
